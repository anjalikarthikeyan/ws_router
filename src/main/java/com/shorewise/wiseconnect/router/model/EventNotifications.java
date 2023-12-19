package com.shorewise.wiseconnect.router.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "EventNotifications", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
public class EventNotifications {
	
    @XmlElement(name = "MessageData", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private String messageData;
    
    @XmlElement(name = "MessageDescription", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private String messageDescription;
    
    @XmlElement(name = "MessageInfo", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private String messageInfo;
    
    @XmlElement(name = "Actioned", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private String actioned;

}