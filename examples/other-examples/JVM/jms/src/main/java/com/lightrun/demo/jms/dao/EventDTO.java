package com.lightrun.demo.jms.dao;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventDTO implements Serializable {
    private String id;
    private EventType type;
    private String userId;
    private long timestamp;
    private String metadata;

    public EventDTO() {
    }
}
