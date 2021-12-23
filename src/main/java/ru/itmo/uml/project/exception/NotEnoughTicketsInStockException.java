package ru.itmo.uml.project.exception;

import ru.itmo.uml.project.model.EventEntity;

public class NotEnoughTicketsInStockException extends Exception {

    private static final String DEFAULT_MESSAGE = "Not enough tickets in stock";

    public NotEnoughTicketsInStockException() {
        super(DEFAULT_MESSAGE);
    }

    public NotEnoughTicketsInStockException(EventEntity eventEntity) {
        super(String.format("Not enough %s tickets in stock. Only %d left", eventEntity.getName(), eventEntity.getQuantity()));
    }

}
