package com.lightrun.demo.jms.service;

import com.lightrun.demo.jms.dao.EventDTO;
import com.lightrun.demo.jms.repo.Event;
import com.lightrun.demo.jms.repo.EventRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    @Async
    public void storeEvent(EventDTO event) {
        eventRepository.save(new Event(event.getId(), event.getType(), event.getUserId(),
                event.getTimestamp(), event.getMetadata()));
    }

    public List<EventDTO> listEvents() {
        return eventRepository.findAll().stream()
                .map(e -> new EventDTO(e.getId(), e.getType(), e.getUserId(), e.getTimestamp(), e.getMetadata()))
                .collect(java.util.stream.Collectors.toList());
    }
}
