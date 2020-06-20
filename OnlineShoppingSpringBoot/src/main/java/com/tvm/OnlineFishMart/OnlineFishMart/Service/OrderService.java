package com.tvm.OnlineFishMart.OnlineFishMart.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvm.OnlineFishMart.OnlineFishMart.Model.Order;
import com.tvm.OnlineFishMart.OnlineFishMart.Repository.OrderRepo;
import com.tvm.OnlineFishMart.OnlineFishMart.web.ResourceNotFoundException;


@Service
public class OrderService {


	@Autowired
	OrderRepo orderRepo;

	// To save an EmployeeProfile
	public Order save(Order emp) {
		return orderRepo.save(emp);
	}

	// search all EmployeeProfiles
	public List<Order> findAll() {
		return orderRepo.findAll();
	}

	// update an EmployeeProfile
	public Order update(Order emp) {
		Optional<Order> ob = orderRepo.findById(emp.getOrderId());

		if (ob.isPresent()) {
			Order newb = ob.get();
//			newb.setUserName(emp.getUserName());
//			newb.setPassword(emp.getPassword());
			newb = orderRepo.save(newb);
			return newb;
		} else {
			emp = orderRepo.save(emp);
			return emp;
		}
	}

	// get an EmployeeProfile by id
	public Order findOne(Integer empid) {
		Optional<Order> ob = orderRepo.findById(empid);
		ob.orElseThrow(() -> new ResourceNotFoundException("No order found with  id " + empid));
		return orderRepo.getOne(empid);
	}

	// delete an EmployeeProfile
	public void delete(Integer empid) {
		orderRepo.deleteById(empid);
	}}
	
//	public List<Order> getbyemailAndPassword(String email, String password) {
//		List<Order> l = EmployeeProfileRepository.getbyEmailAndPassword(email, password);
//		return l;
//	}
	