package com.lightrun.demo.jms.repo;

import com.lightrun.demo.jms.dao.EventType;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Event {
    @Id
    private String id;
    private EventType type;
    private String userId;
    private long timestamp;
    private String metadata;

    public Event() {}
}
