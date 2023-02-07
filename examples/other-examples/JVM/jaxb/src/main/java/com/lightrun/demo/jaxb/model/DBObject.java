package com.lightrun.demo.jaxb.model;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "dbobject")
public class DBObject {
    private String id;
    private byte[] coreData;
}
