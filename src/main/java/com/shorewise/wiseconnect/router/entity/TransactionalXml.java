package com.shorewise.wiseconnect.router.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactional_xml", schema = "xml_storage")
public class TransactionalXml implements Serializable  {

    public TransactionalXml() {
		super();
	}

	@Id
    private String id;

    @Column(name = "xml_data", length = 20000)
    private String xmlData;

    @Column(name = "operation_type", length = 8)
    private String operation_type;
    
    @Column(name = "status", length = 24)
    private String status;

    @Column(name = "created_user", length = 24)
    private String createdUser;

    @Column(name = "updated_user", length = 24)
    private String updatedUser;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

	public String getId() {
		return id;
	}

	public String getXmlData() {
		return xmlData;
	}

	public String getStatus() {
		return status;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public String getUpdatedUser() {
		return updatedUser;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

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

	public TransactionalXml(String id, String xmlData, String status, String createdUser, String updatedUser,
			Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.xmlData = xmlData;
		this.status = status;
		this.createdUser = createdUser;
		this.updatedUser = updatedUser;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
    
}