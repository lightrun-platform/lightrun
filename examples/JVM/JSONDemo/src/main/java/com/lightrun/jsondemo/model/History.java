package com.lightrun.jsondemo.model;

import java.time.Instant;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class History {
    private String objectId;
    private int ordinal;
    private Instant time;
    private Action action;
    private String userId;
}
