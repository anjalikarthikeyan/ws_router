package com.shorewise.wiseconnect.router.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "Sender", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
public class Sender {
	
    @XmlElement(name = "Customer", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    private String customer;

}
