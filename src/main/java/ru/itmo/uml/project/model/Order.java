package ru.itmo.uml.project.model;


import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ConcurrentHashMap;

public class Order extends ConcurrentHashMap<EventEntity, Integer> {
    @Getter
    @Setter
    private volatile State state;

    public enum State {
        IN_PROGRESS,
        CHECKING,
        READY_FOR_PAYMENT,
        PAID
    }
}
