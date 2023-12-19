package com.shorewise.wiseconnect.router.model;
import javax.xml.bind.annotation.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestHeader {

    @XmlElement(name = "Service")
    private String service;

    @XmlElement(name = "Operation")
    private String operation;

    @XmlElement(name = "ReplyFormat")
    private String replyFormat;

    @XmlElement(name = "SourceSystem")
    private String sourceSystem;

    @XmlElement(name = "NoRepair")
    private String noRepair;

    @XmlElement(name = "NoOverride")
    private String noOverride;

    @XmlElement(name = "CorrelationId")
    private String correlationId;

    @XmlElement(name = "TransactionControl")
    private String transactionControl;

	@XmlElement(name = "Credentials")
	private Credentials credentials;
}
