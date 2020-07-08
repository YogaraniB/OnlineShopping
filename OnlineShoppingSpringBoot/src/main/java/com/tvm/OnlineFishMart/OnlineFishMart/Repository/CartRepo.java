package com.tvm.OnlineFishMart.OnlineFishMart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tvm.OnlineFishMart.OnlineFishMart.Model.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>{

	@Query(value = "SELECT * FROM CART WHERE USERSIGNUPID=?1",nativeQuery = true)
	public List<Cart> getCartByUserId (Integer usersignupid);
}
