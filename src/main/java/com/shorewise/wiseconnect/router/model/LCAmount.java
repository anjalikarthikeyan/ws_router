package com.shorewise.wiseconnect.router.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "LCAmount", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
public class LCAmount {
	
    @XmlElement(name = "Amount", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    private String amount;
    
    @XmlElement(name = "Currency", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    private String currency;

}
