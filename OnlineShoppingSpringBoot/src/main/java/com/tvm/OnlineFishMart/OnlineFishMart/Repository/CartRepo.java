package com.tvm.OnlineFishMart.OnlineFishMart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvm.OnlineFishMart.OnlineFishMart.Model.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>{

}
