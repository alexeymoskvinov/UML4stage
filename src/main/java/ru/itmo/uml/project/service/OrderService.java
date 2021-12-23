package ru.itmo.uml.project.service;

import ru.itmo.uml.project.exception.NotEnoughTicketsInStockException;
import ru.itmo.uml.project.model.EventEntity;

import java.math.BigDecimal;
import java.util.Map;

public interface OrderService {

    void addTicket(EventEntity eventEntity);

    void removeTicket(EventEntity eventEntity);

    Map<EventEntity, Integer> getEventsInOrder();

    void checkout() throws NotEnoughTicketsInStockException;

    BigDecimal getTotal();
}
