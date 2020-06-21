package com.tvm.OnlineFishMart.OnlineFishMart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tvm.OnlineFishMart.OnlineFishMart.Model.Product;
import com.tvm.OnlineFishMart.OnlineFishMart.Repository.ProductRepo;
import com.tvm.OnlineFishMart.OnlineFishMart.web.ResourceNotFoundException;

@Service
public class ProductService {


	@Autowired
	ProductRepo productRepo;

	@Autowired
	com.tvm.OnlineFishMart.OnlineFishMart.Model.File.FileService fileRepository;
	// To save an EmployeeProfile
	public Product save(Product emp) {
		return productRepo.save(emp);
	}

	// search all EmployeeProfiles
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	// update an EmployeeProfile
	public Product update(Product emp) {
		Optional<Product> ob = productRepo.findById(emp.getId());

		if (ob.isPresent()) {
			Product newb = ob.get();
//			newb.setUserName(emp.getUserName());
//			newb.setPassword(emp.getPassword());
//			newb = productRepo.save(newb);
			return newb;
		} else {
			emp = productRepo.save(emp);
			return emp;
		}
	}

	// get an EmployeeProfile by id
	public Product findOne(Long empid) {
		Optional<Product> ob = productRepo.findById(empid);
		ob.orElseThrow(() -> new ResourceNotFoundException("No Product found with  id " + empid));
		return productRepo.getOne(empid);
	}

	// delete an EmployeeProfile
	public void delete(Long empid) {
		productRepo.deleteById(empid);
	}
	
	





}
	
//	public List<Product> getbyemailAndPassword(String email, String password) {
//		List<Product> l = EmployeeProfileRepository.getbyEmailAndPassword(email, password);
//		return l;
//	}
	