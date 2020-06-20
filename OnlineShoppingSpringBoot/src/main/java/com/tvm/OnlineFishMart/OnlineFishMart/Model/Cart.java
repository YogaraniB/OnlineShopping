package com.tvm.OnlineFishMart.OnlineFishMart.Model;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	 @ElementCollection
	 @OneToMany(mappedBy = "cartId", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	  private List<Category> category;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usersignupid", nullable = false)
    private UserSignUp usersignupid;
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	public UserSignUp getUsersignupid() {
		return usersignupid;
	}
	public void setUsersignupid(UserSignUp usersignupid) {
		this.usersignupid = usersignupid;
	}
	public Cart(Integer cartId, List<Category> category, UserSignUp usersignupid) {
		super();
		this.cartId = cartId;
		this.category = category;
		this.usersignupid = usersignupid;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
