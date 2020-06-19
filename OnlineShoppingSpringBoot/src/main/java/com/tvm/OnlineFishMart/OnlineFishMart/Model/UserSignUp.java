package com.tvm.OnlineFishMart.OnlineFishMart.Model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class UserSignUp extends Audit{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	@Embedded
	private Address address;
	private Long phone;
	private String email;
	private String password;
	 @JsonIgnore
	 @ElementCollection
	 @OneToMany(mappedBy = "customerId", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	  private List<Order> order;
	 @JsonIgnore
	 @ElementCollection
	 @OneToMany(mappedBy = "usersignupid", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	  private List<Cart> cart;
	 
	
	
	public UserSignUp(Integer userId, String userName, Address address, Long phone, String email, String password,
			List<Order> order, List<Cart> cart) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.order = order;
		this.cart = cart;
	}
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	
	public UserSignUp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
