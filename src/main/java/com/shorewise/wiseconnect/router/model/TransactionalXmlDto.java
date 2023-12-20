package com.shorewise.wiseconnect.router.model;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement // Add this annotation to specify the root element for XML
public class TransactionalXmlDto {

  	private String id;
    private String xmlData;
    private String status;
    private String createdUser;
    private String updatedUser;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
    public void setId(String id) {
  		this.id = id;
  	}

  	public void setXmlData(String xmlData) {
  		this.xmlData = xmlData;
  	}

  	public void setStatus(String status) {
  		this.status = status;
  	}

  	public void setCreatedUser(String createdUser) {
  		this.createdUser = createdUser;
  	}

  	public void setUpdatedUser(String updatedUser) {
  		this.updatedUser = updatedUser;
  	}

  	public void setCreatedAt(Timestamp createdAt) {
  		this.createdAt = createdAt;
  	}

  	public void setUpdatedAt(Timestamp updatedAt) {
  		this.updatedAt = updatedAt;
  	}



    // Add JAXB annotations to the getter methods
    @XmlElement
    public String getId() {
        return id;
    }

    @XmlElement
    public String getXmlData() {
        return xmlData;
    }

    @XmlElement
    public String getStatus() {
        return status;
    }

    @XmlElement
    public String getCreatedUser() {
        return createdUser;
    }

    @XmlElement
    public String getUpdatedUser() {
        return updatedUser;
    }

    @XmlElement
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @XmlElement
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    
}
