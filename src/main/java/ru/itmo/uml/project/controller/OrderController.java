package ru.itmo.uml.project.controller;

import org.springframework.web.bind.annotation.RestController;
import ru.itmo.uml.project.exception.NotEnoughTicketsInStockException;
import ru.itmo.uml.project.service.EventService;
import ru.itmo.uml.project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class OrderController {

    private final OrderService orderService;

    private final EventService eventService;

    @Autowired
    public OrderController(OrderService orderService, EventService eventService) {
        this.orderService = orderService;
        this.eventService = eventService;
    }

    @GetMapping("/order")
    public ModelAndView order() {
        ModelAndView modelAndView = new ModelAndView("/order");
        modelAndView.addObject("events", orderService.getEventsInOrder());
        modelAndView.addObject("total", orderService.getTotal().toString());
        return modelAndView;
    }

    @GetMapping("/order/addTicket/{eventId}")
    public ModelAndView addTicketToOrder(@PathVariable("eventId") Long eventId) {
        eventService.findById(eventId).ifPresent(orderService::addTicket);
        return order();
    }

    @GetMapping("/order/removeTicket/{eventId}")
    public ModelAndView removeTicketFromOrder(@PathVariable("eventId") Long eventId) {
        eventService.findById(eventId).ifPresent(orderService::removeTicket);
        return order();
    }

    @GetMapping("/order/checkout")
    public ModelAndView checkout() {
        try {
            orderService.checkout();
        } catch (NotEnoughTicketsInStockException e) {
            return order().addObject("outOfStockMessage", e.getMessage());
        }
        return order();
    }
}
