package com.lightrun.demo.jaxb.model;

import java.time.Instant;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class InstantAdapter extends XmlAdapter<String, Instant> {
    @Override
    public Instant unmarshal(String v) throws Exception {
        return Instant.ofEpochMilli(Long.parseLong(v));
    }

    @Override
    public String marshal(Instant v) throws Exception {
        return "" + v.toEpochMilli();
    }
}
