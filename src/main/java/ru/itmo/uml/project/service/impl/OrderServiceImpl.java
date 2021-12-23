package ru.itmo.uml.project.service.impl;

import ru.itmo.uml.project.model.Order;
import ru.itmo.uml.project.exception.NotEnoughTicketsInStockException;
import ru.itmo.uml.project.model.EventEntity;
import ru.itmo.uml.project.repository.EventRepository;
import ru.itmo.uml.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Map;

import static ru.itmo.uml.project.model.Order.State.*;


@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class OrderServiceImpl implements OrderService {

    private final EventRepository eventRepository;

    private final Order order = new Order();

    @Autowired
    public OrderServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void addTicket(EventEntity eventEntity) {
        order.setState(IN_PROGRESS);
        if (order.containsKey(eventEntity)) {
            order.replace(eventEntity, order.get(eventEntity) + 1);
        } else {
            order.put(eventEntity, 1);
        }
    }

    @Override
    public void removeTicket(EventEntity eventEntity) {
        order.setState(IN_PROGRESS);
        if (order.containsKey(eventEntity)) {
            if (order.get(eventEntity) > 1)
                order.replace(eventEntity, order.get(eventEntity) - 1);
            else if (order.get(eventEntity) == 1) {
                order.remove(eventEntity);
            }
        }
    }

    @Override
    public Map<EventEntity, Integer> getEventsInOrder() {
        return order;
    }

    @Override
    public void checkout() throws NotEnoughTicketsInStockException {
        order.setState(CHECKING);
        EventEntity eventEntity;
        for (Map.Entry<EventEntity, Integer> entry : order.entrySet()) {
            eventEntity = eventRepository.findOne(entry.getKey().getId());
            if (eventEntity.getQuantity() < entry.getValue())
                throw new NotEnoughTicketsInStockException(eventEntity);
            entry.getKey().setQuantity(eventEntity.getQuantity() - entry.getValue());
        }
        order.setState(READY_FOR_PAYMENT);
        eventRepository.save(order.keySet());
        eventRepository.flush();
        order.clear();
        order.setState(PAID);
    }

    @Override
    public BigDecimal getTotal() {
        return order.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
