package com.tvm.OnlineFishMart.OnlineFishMart.Model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	
//	@OneToOne(fetch = FetchType.LAZY,
//    cascade =  {CascadeType.MERGE,CascadeType.REFRESH},
//    mappedBy = "cartId")
//	private Category category;
	
	private String categoryDescription;
	private String categoryName;
	@Lob
	private byte[] imgId;
	private BigDecimal price;
	private Integer quanity;
	private Integer usersignupid;
	
	
	
	public Integer getQuanity() {
		return quanity;
	}
	public void setQuanity(Integer quanity) {
		this.quanity = quanity;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public byte[] getImgId() {
		return imgId;
	}
	public void setImgId(byte[] imgId) {
		this.imgId = imgId;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getUsersignupid() {
		return usersignupid;
	}
	public void setUsersignupid(Integer usersignupid) {
		this.usersignupid = usersignupid;
	}
	
	public Cart(Integer cartId, String categoryDescription, String categoryName, byte[] imgId, BigDecimal price,
			Integer quanity, Integer usersignupid) {
		super();
		this.cartId = cartId;
		this.categoryDescription = categoryDescription;
		this.categoryName = categoryName;
		this.imgId = imgId;
		this.price = price;
		this.quanity = quanity;
		this.usersignupid = usersignupid;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
}