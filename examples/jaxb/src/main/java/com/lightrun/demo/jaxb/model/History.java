package com.lightrun.demo.jaxb.model;

import java.time.Instant;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@XmlRootElement(name = "history")
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
public class History {
    private String objectId;
    private int ordinal;

    @XmlJavaTypeAdapter(InstantAdapter.class)
    private Instant time;
    private Action action;
    private String userId;

    public History() {}
}
