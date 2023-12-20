package com.shorewise.wiseconnect.router.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "EventNotifications", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
public class EventNotifications {
    private String messageData;
    private String messageDescription;
    private String messageInfo;
    private String actioned;

    // Getters and Setters

    @XmlElement(name = "MessageData", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    public String getMessageData() {
        return messageData;
    }

    public void setMessageData(String messageData) {
        this.messageData = messageData;
    }

    @XmlElement(name = "MessageDescription", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }

    @XmlElement(name = "MessageInfo", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    @XmlElement(name = "Actioned", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    public String getActioned() {
        return actioned;
    }

    public void setActioned(String actioned) {
        this.actioned = actioned;
    }
}