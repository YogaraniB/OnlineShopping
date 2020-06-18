package com.tvm.OnlineFishMart.OnlineFishMart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tvm.OnlineFishMart.OnlineFishMart.Model.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

}
