package com.shorewise.wiseconnect.router.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "EventNotificationss", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
public class EventNotificationss {
	
    @XmlElement(name = "EventNotifications", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private List<EventNotifications> eventNotifications;

}