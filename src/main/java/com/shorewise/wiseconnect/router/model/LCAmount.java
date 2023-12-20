package com.shorewise.wiseconnect.router.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "LCAmount", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
public class LCAmount {
    private String amount;
    private String currency;

    @XmlElement(name = "Amount", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @XmlElement(name = "Currency", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
