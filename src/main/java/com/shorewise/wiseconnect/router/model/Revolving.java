package com.shorewise.wiseconnect.router.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "Revolving", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
public class Revolving {
	
    @XmlElement(name = "Revolving", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    private String revolving;
    
    @XmlElement(name = "Cumulative", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    private String cumulative;
    
    @XmlElement(name = "Period", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    private String period;
    
    @XmlElement(name = "ChargeToFirstPeriod", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    private String chargeToFirstPeriod;
    
}
