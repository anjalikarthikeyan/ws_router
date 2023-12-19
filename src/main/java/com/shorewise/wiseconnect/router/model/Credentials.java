package com.shorewise.wiseconnect.router.model;
import javax.xml.bind.annotation.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Credentials {

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Password")
    private String password;

    @XmlElement(name = "Certificate")
    private String certificate;

    @XmlElement(name = "Digest")
    private String digest;

}
