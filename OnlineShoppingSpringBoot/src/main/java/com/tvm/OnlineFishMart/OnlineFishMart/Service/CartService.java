package com.tvm.OnlineFishMart.OnlineFishMart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvm.OnlineFishMart.OnlineFishMart.Model.Cart;
import com.tvm.OnlineFishMart.OnlineFishMart.Repository.CartRepo;
import com.tvm.OnlineFishMart.OnlineFishMart.web.ResourceNotFoundException;


@Service
public class CartService {


	@Autowired
	CartRepo cartRepo;

	// To save an EmployeeProfile
	public Cart save(Cart emp) {
		return cartRepo.save(emp);
	}

	// search all EmployeeProfiles
	public List<Cart> findAll() {
		return cartRepo.findAll();
	}

	// update an EmployeeProfile
	public Cart update(Cart emp) {
		Optional<Cart> ob = cartRepo.findById(emp.getCartId());

		if (ob.isPresent()) {
			Cart newb = ob.get();
//			newb.setUserName(emp.getUserName());
//			newb.setPassword(emp.getPassword());
			newb = cartRepo.save(newb);
			return newb;
		} else {
			emp = cartRepo.save(emp);
			return emp;
		}
	}

	// get an EmployeeProfile by id
	public Cart findOne(Integer empid) {
		Optional<Cart> ob = cartRepo.findById(empid);
		ob.orElseThrow(() -> new ResourceNotFoundException("No Cart found with  id " + empid));
		return cartRepo.getOne(empid);
	}

	// delete an EmployeeProfile
	public void delete(Integer empid) {
		cartRepo.deleteById(empid);
	}
	
	public List<Cart> getCartByUserId (Integer usersignupid){
		return cartRepo.getCartByUserId(usersignupid);
	}




}
	
//	public List<Cart> getbyemailAndPassword(String email, String password) {
//		List<Cart> l = EmployeeProfileRepository.getbyEmailAndPassword(email, password);
//		return l;
//	}
	