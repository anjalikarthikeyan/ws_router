package com.shorewise.wiseconnect.router.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Revocable", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
public class Revocable {
    private String value;

    @XmlElement(namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
