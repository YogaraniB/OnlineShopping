package com.tvm.OnlineFishMart.OnlineFishMart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tvm.OnlineFishMart.OnlineFishMart.Model.Category;
import com.tvm.OnlineFishMart.OnlineFishMart.Repository.CategoryRepo;
import com.tvm.OnlineFishMart.OnlineFishMart.web.ResourceNotFoundException;

@Service
public class CategoryService {


	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	com.tvm.OnlineFishMart.OnlineFishMart.Model.File.FileService fileRepository;
	// To save an EmployeeProfile
	public Category save(Category emp) {
		return categoryRepo.save(emp);
	}

	// search all EmployeeProfiles
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}

	// update an EmployeeProfile
	public Category update(Category emp) {
		Optional<Category> ob = categoryRepo.findById(emp.getId());

		if (ob.isPresent()) {
			Category newb = ob.get();
//			newb.setUserName(emp.getUserName());
//			newb.setPassword(emp.getPassword());
//			newb = categoryRepo.save(newb);
			return newb;
		} else {
			emp = categoryRepo.save(emp);
			return emp;
		}
	}

	// get an EmployeeProfile by id
	public Category findOne(Long empid) {
		Optional<Category> ob = categoryRepo.findById(empid);
		ob.orElseThrow(() -> new ResourceNotFoundException("No employee found with employee id " + empid));
		return categoryRepo.getOne(empid);
	}

	// delete an EmployeeProfile
	public void delete(Long empid) {
		categoryRepo.deleteById(empid);
	}
	
	





}
	
//	public List<Category> getbyemailAndPassword(String email, String password) {
//		List<Category> l = EmployeeProfileRepository.getbyEmailAndPassword(email, password);
//		return l;
//	}
	