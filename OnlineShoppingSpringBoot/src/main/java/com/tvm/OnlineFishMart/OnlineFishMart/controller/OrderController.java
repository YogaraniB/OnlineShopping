package com.tvm.OnlineFishMart.OnlineFishMart.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tvm.OnlineFishMart.OnlineFishMart.Model.Order;
import com.tvm.OnlineFishMart.OnlineFishMart.Service.OrderService;
import com.tvm.OnlineFishMart.OnlineFishMart.web.ResponseAPI;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
@EnableSwagger2
@CrossOrigin("*")
@Api(value = "Online Shopping", description = "REST Apis related to Order Entity!!!!")
@Validated
//use @Validated annotation on top of controller so it is applicable to all methods in it.
public class OrderController {

	@Autowired
	OrderService orderService;

	private static Logger logger = LoggerFactory.getLogger(OrderController.class);

	@GetMapping("/getOrderById/{empId}")
	public Order getById(@PathVariable(value = "empId") Integer empId) {
		logger.debug("Getting an Order " + empId);
		return orderService.findOne(empId);
	}

	@GetMapping("/Orders")
	public ResponseAPI getAll() {
		logger.debug("Getting all Orders");
		List<Order> Orders = orderService.findAll();
//		Collections.sort(Orders, Comparator.nullsLast(
//				Comparator.comparing(Order::getCreatedAt, Comparator.nullsLast(Comparator.reverseOrder()))));
		// Collections.sort(Orders, (o1, o2) ->
		// o1.getCreatedAt().compareTo(o2.getCreatedAt()));
		// Collections.reverse(Orders);
		// Comparator.nullsFirst(Comparator.comparing(Order::getCreatedAt,Comparator.nullsFirst(Comparator.reverseOrder())));
		ResponseAPI res1 = new ResponseAPI("Success", Boolean.TRUE, Orders, Orders.size());
		return res1;
	}

	@PostMapping("/Orders")
	public Order insert(@RequestBody Order i) {
		logger.debug("Posting an Order " + i.getOrderId());
		return orderService.save(i);
	}

//	@GetMapping("/OrdersByName1.8/{site}/{client}")
//	public List<Order> OrderByRange(@PathVariable(value = "site") String site,
//			@PathVariable(value = "client") String client) {
//		return orderService.findAll().stream()
//				.filter(x -> x.getSite().equalsIgnoreCase(site) && x.getClient().equalsIgnoreCase(client))
//				.collect(Collectors.toList());
//	}

//	@GetMapping("/OrdersByName1.8/{name}")
//	public List<Order> OrderAutocomplete(@PathVariable(value = "name") String name) {	
//		return orderService.findAll().stream().filter(x -> x.getFirstName().startsWith(name))
//				.collect(Collectors.toList());
//	}

	@PutMapping("/Order/{id}")
	public Order update(@PathVariable(value = "id") Integer id, @RequestBody Order emp) {
		logger.debug("Updating an Order " + id);
		orderService.findOne(id);
		return orderService.update(emp);
	}

	@DeleteMapping("/Order/{id}")
	public ResponseAPI delete(@PathVariable(value = "id") Integer id) {
		logger.debug("Deleting an Order " + id);
		orderService.findOne(id);
		orderService.delete(id);
		return new ResponseAPI("Order with id : " + id + " Deleted", Boolean.TRUE);

	}

}
