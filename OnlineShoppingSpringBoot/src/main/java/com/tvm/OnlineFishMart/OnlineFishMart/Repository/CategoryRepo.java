package com.tvm.OnlineFishMart.OnlineFishMart.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tvm.OnlineFishMart.OnlineFishMart.Model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{
	@Query(value = "SELECT * FROM CATEGORY WHERE PRODUCT_ID=?1",nativeQuery = true)
	public List<Category> findByProduct(Long productId);
}
