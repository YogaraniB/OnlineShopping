package com.tvm.OnlineFishMart.OnlineFishMart.Model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	private String categoryName;
	private String categoryDescription;
	@Lob
	private byte[] imgid;

	
	public Category(String categoryName, String categoryDescription, byte[] imgid) {
		super();
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.imgid = imgid;
	}

	public Category(Long id, String categoryName, String categoryDescription, byte[] imgid) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.imgid = imgid;
	}

	public void setImgid(byte[] imgid) {
		this.imgid = imgid;
	}

	public byte[] getImgid() {
		return imgid;
	}

	public Long getId() {
		return id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}