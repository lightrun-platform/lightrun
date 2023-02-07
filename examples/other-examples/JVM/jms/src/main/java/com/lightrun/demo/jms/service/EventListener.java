package com.lightrun.demo.jms.service;

import com.lightrun.demo.jms.dao.EventDTO;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventListener {
    private final EventService eventService;

    private final Moshi moshi = new Moshi.Builder().build();

    @JmsListener(destination = "event")
    public void handleMessage(String eventDTOJSON) throws IOException {
        eventService.storeEvent(moshi.adapter(EventDTO.class).fromJson(eventDTOJSON));
    }
}
