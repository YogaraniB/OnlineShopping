package com.tvm.OnlineFishMart.OnlineFishMart.Model.File;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.tvm.OnlineFishMart.OnlineFishMart.Model.Category;

@Entity
public class FileModel {
	@Id
	@GeneratedValue
	@JsonView(View.FileInfo.class)
	private Long id;
	@JsonView(View.FileInfo.class)
	private String name;
	private String mimetype;
	@Lob
	private byte[] file;
	
	
	
	
	public FileModel(String name, String mimetype, byte[] file) {
		super();
		this.name = name;
		this.mimetype = mimetype;
		this.file = file;
	}
	
	public FileModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMimetype() {
		return mimetype;
	}
	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	
	
	
}
