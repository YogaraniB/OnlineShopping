package com.tvm.OnlineFishMart.OnlineFishMart.Model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
	private Integer quantity;
	private Integer usersignupid;
	
	
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
			Integer quantity, Integer usersignupid) {
		super();
		this.cartId = cartId;
		this.categoryDescription = categoryDescription;
		this.categoryName = categoryName;
		this.imgId = imgId;
		this.price = price;
		this.quantity = quantity;
		this.usersignupid = usersignupid;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
}