package com.lightrun.demo.jms.web;

import com.lightrun.demo.jms.dao.EventDTO;
import com.lightrun.demo.jms.service.EventService;
import com.squareup.moshi.Moshi;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EventRequest {
    private final JmsTemplate jmsTemplate;
    private final EventService eventService;
    private final Moshi moshi = new Moshi.Builder().build();

    @PostMapping("/add")
    public void event(@RequestBody EventDTO event) {
        String json = moshi.adapter(EventDTO.class).toJson(event);
        jmsTemplate.send("event", session ->
                session.createTextMessage(json));
    }

    @GetMapping("/list")
    public List<EventDTO> listEvents() {
        return eventService.listEvents();
    }
}
