package com.shorewise.wiseconnect.router.model;
import javax.xml.bind.annotation.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "ServiceRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceRequest {

    @XmlElement(name = "RequestHeader")
    private RequestHeader requestHeader;
    
    @XmlElement(name = "TFCOLAMD", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private TFCOLAMD tfcolamd;
    
    @XmlElement(name = "TFCOLCOR", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private TFCOLCOR tfcolcor;
    
    @XmlElement(name = "TFCOLNEW", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private TFCOLNEW tfcolnew;
    
    @XmlElement(name = "TFILCAMN", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private TFILCAMN tfilcamn;
    
    @XmlElement(name = "TFILCAPP", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private TFILCAPP tfilcapp;
    
    @XmlElement(name = "TFILCCOR", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private TFILCCOR tfilccor;
    
    @XmlElement(name = "TFSHGAPP", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private TFSHGAPP tfshgapp;
    
    @XmlElement(name = "TFSHGCOR", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private TFSHGCOR tfshgcor;
 
}
