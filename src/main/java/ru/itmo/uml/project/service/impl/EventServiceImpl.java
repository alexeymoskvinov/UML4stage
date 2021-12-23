package ru.itmo.uml.project.service.impl;

import ru.itmo.uml.project.model.EventEntity;
import ru.itmo.uml.project.repository.EventRepository;
import ru.itmo.uml.project.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Page<EventEntity> findAllEventsPageable(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    @Override
    public Optional<EventEntity> findById(Long id) {
        return eventRepository.findById(id);
    }
}
