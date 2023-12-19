package com.shorewise.wiseconnect.router.model;

import javax.xml.bind.annotation.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "Context")
@XmlAccessorType(XmlAccessType.FIELD)
public class Context {

    @XmlElement(name = "Customer", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    private String customer;
    
    @XmlElement(name = "OurReference", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    private String ourReference;

    @XmlElement(name = "TheirReference", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    private String theirReference;

    @XmlElement(name = "BehalfOfBranch", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    private String behalfOfBranch;
  
}

