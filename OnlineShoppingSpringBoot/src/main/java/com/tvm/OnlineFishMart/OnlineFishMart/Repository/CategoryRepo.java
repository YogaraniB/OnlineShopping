package com.tvm.OnlineFishMart.OnlineFishMart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tvm.OnlineFishMart.OnlineFishMart.Model.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
