package com.shorewise.wiseconnect.router.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "MasterRef", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
public class MasterRef {
	
    @XmlElement(namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private String masterRef;

}
