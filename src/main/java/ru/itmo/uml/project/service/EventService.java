package ru.itmo.uml.project.service;

import ru.itmo.uml.project.model.EventEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EventService {

    Optional<EventEntity> findById(Long id);

    Page<EventEntity> findAllEventsPageable(Pageable pageable);

}
