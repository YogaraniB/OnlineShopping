package com.tvm.OnlineFishMart.OnlineFishMart.Model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "name", nullable = false, unique = true)
    @Length(min = 3, message = "*Name must have at least 5 characters")
	private String categoryName;
	
	@Lob
	private String categoryDescription;
	
	@Lob
	private byte[] imgid;

    @Column(name = "quantity", nullable = false)
    @Min(value = 0, message = "*Quantity has to be non negative number")
    private Integer quantity;

    @Column(name = "price", nullable = false)
    @DecimalMin(value = "0.00", message = "*Price has to be non negative number")
    private BigDecimal price;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productId", nullable = false)
    private Product product;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "cartId", nullable = true)
    private Cart cartId;
  

	public Category(Long id, @Length(min = 3, message = "*Name must have at least 5 characters") String categoryName,
			String categoryDescription, byte[] imgid,
			@Min(value = 0, message = "*Quantity has to be non negative number") Integer quantity,
			@DecimalMin(value = "0.00", message = "*Price has to be non negative number") BigDecimal price,
			Product product, Cart cartId) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.imgid = imgid;
		this.quantity = quantity;
		this.price = price;
		this.product = product;
		this.cartId = cartId;
	}


	public Cart getCartId() {
		return cartId;
	}


	public void setCartId(Cart cartId) {
		this.cartId = cartId;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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