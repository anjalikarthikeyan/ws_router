package com.shorewise.wiseconnect.router.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MasterRef", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
public class MasterRef {
    private String masterRef;

    @XmlElement(namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    public String getMasterRef() {
        return masterRef;
    }

    public void setMasterRef(String masterRef) {
        this.masterRef = masterRef;
    }
}
