package com.tvm.OnlineFishMart.OnlineFishMart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tvm.OnlineFishMart.OnlineFishMart.Model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
