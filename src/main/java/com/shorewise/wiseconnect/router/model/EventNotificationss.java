package com.shorewise.wiseconnect.router.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "EventNotificationss", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
public class EventNotificationss {
    private List<EventNotifications> eventNotifications;

    // Getters and Setters

    @XmlElement(name = "EventNotifications", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    public List<EventNotifications> getEventNotifications() {
        return eventNotifications;
    }

    public void setEventNotifications(List<EventNotifications> eventNotifications) {
        this.eventNotifications = eventNotifications;
    }
}