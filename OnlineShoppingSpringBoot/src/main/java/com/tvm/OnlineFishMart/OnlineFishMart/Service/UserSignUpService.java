package com.tvm.OnlineFishMart.OnlineFishMart.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvm.OnlineFishMart.OnlineFishMart.Model.UserSignUp;
import com.tvm.OnlineFishMart.OnlineFishMart.Repository.UserSignUpRepo;
import com.tvm.OnlineFishMart.OnlineFishMart.web.ResourceNotFoundException;


@Service
public class UserSignUpService {


	@Autowired
	UserSignUpRepo userSignUpRepo;

	// To save an EmployeeProfile
	public UserSignUp save(UserSignUp emp) {
		return userSignUpRepo.save(emp);
	}

	// search all EmployeeProfiles
	public List<UserSignUp> findAll() {
		return userSignUpRepo.findAll();
	}

	// update an EmployeeProfile
	public UserSignUp update(UserSignUp emp) {
		Optional<UserSignUp> ob = userSignUpRepo.findById(emp.getUserId());

		if (ob.isPresent()) {
			UserSignUp newb = ob.get();
			newb.setAddress(emp.getAddress());
			newb.setEmail(emp.getEmail());
			newb.setModifiedAt(new Date());
			newb.setPhone(emp.getPhone());
			newb.setUserName(emp.getUserName());
			newb.setPassword(emp.getPassword());
			newb = userSignUpRepo.save(newb);
			return newb;
		} else {
			emp = userSignUpRepo.save(emp);
			return emp;
		}
	}

	// get an EmployeeProfile by id
	public UserSignUp findOne(Integer empid) {
		Optional<UserSignUp> ob = userSignUpRepo.findById(empid);
		ob.orElseThrow(() -> new ResourceNotFoundException("No employee found with employee id " + empid));
		return userSignUpRepo.getOne(empid);
	}

	// delete an EmployeeProfile
	public void delete(Integer empid) {
		userSignUpRepo.deleteById(empid);
	}}
	
//	public List<UserSignUp> getbyemailAndPassword(String email, String password) {
//		List<UserSignUp> l = EmployeeProfileRepository.getbyEmailAndPassword(email, password);
//		return l;
//	}
	