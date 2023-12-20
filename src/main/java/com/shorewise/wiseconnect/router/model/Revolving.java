package com.shorewise.wiseconnect.router.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Revolving", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com")
public class Revolving {
    private String revolving;
    private String cumulative;
    private String period;
    private String chargeToFirstPeriod;

    @XmlElement(name = "Revolving", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    public String getRevolving() {
        return revolving;
    }

    public void setRevolving(String revolving) {
        this.revolving = revolving;
    }

    @XmlElement(name = "Cumulative", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    public String getCumulative() {
        return cumulative;
    }

    public void setCumulative(String cumulative) {
        this.cumulative = cumulative;
    }

    @XmlElement(name = "Period", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @XmlElement(name = "ChargeToFirstPeriod", namespace = "urn:common.service.ti.apps.tiplus2.misys.com")
    public String getChargeToFirstPeriod() {
        return chargeToFirstPeriod;
    }

    public void setChargeToFirstPeriod(String chargeToFirstPeriod) {
        this.chargeToFirstPeriod = chargeToFirstPeriod;
    }
}
