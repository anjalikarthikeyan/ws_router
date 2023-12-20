package com.shorewise.wiseconnect.router.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TermsOfPayment", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
public class TermsOfPayment {
    private String availableBy;

    @XmlElement(name = "AvailableBy", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    public String getAvailableBy() {
        return availableBy;
    }

    public void setAvailableBy(String availableBy) {
        this.availableBy = availableBy;
    }
}
