package com.tvm.OnlineFishMart.OnlineFishMart.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value = { "createdAt", "modifiedAt" }, allowGetters = true)
@MappedSuperclass
public class Audit {

	//@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	private Date createdAt;
	
	//@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = true)
	private Date modifiedAt;
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	@PrePersist
	protected void onCreate() {
		
		createdAt = new Date();
		modifiedAt = new Date();
		
	}

	@PreUpdate
	protected void onUpdate() {
		
		modifiedAt = new Date();
		
	}
}
