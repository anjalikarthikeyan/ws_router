package com.shorewise.wiseconnect.router.model;


import javax.xml.bind.annotation.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class TFILCCOR {

    @XmlElement(name = "EventNotificationss", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private EventNotificationss eventNotificationss;
	
    @XmlElement(name = "Context", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private Context context;
    
    @XmlElement(name = "MasterRef", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private MasterRef masterRef;
    
    @XmlElement(name = "Applicant", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private Applicant applicant;
    
    @XmlElement(name = "LCAmount", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private LCAmount lCAmount;
    

    @XmlElement(name = "Revocable", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private Revocable revocable;
    
    
    @XmlElement(name = "Revolving", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private Revolving revolving;
    
    
    @XmlElement(name = "ApplicationDate", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private String  applicationDate;
    
    @XmlElement(name = "IssueDate", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private String issueDate;
    
    
    @XmlElement(name = "TermsOfPayment", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private TermsOfPayment termsOfPayment;
    
    
    @XmlElement(name = "eBankMasterRef", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private String eBankMasterRef;
    
    @XmlElement(name = "eBankEvent", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private String eBankEvent;
    
    @XmlElement(name = "Sender", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private Sender sender;
    
    @XmlElement(name = "IncreaseAmount", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private IncreaseAmount increaseAmount;
    
    @XmlElement(name = "AmendmentNarrative", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private String amendmentNarrative;
    
    
    @XmlElement(name = "AmendDate", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
    private String amendDate;

}

