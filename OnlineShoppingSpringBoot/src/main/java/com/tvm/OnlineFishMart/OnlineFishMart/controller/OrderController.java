package com.tvm.OnlineFishMart.OnlineFishMart.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.persistence.Lob;

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

import com.tvm.OnlineFishMart.OnlineFishMart.Email.SmtpMailSender;
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

	@Autowired
	private SmtpMailSender smtpMailSender;
	
	@Lob
	String Body="";
	String Subject="Order Invoice";
	
	
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
		ResponseAPI res1 = new ResponseAPI("Success", Boolean.TRUE, Orders, Orders.size());
		return res1;
	}

	@PostMapping("/Orders")
	public Order insert(@RequestBody Order i) throws MessagingException {
		logger.debug("Posting an Order " + i.getOrderId());
		orderService.save(i);
//		this.Body="Hai " +i.getCustomerId().getUserName()+", Your Order is Successfully Placed and your order ID is "
//		+i.getOrderId()
//		+" Thanks for Shopping with us!!   Happy Shopping!!!";
		this.Body="<html><body style='color:#2A6EBB'><h3><b>Hai "  +i.getCustomerId().getUserName() +",</b><br>"
				+"Your Order is Successfully Placed and your order ID is " +i.getOrderId() +",<br>"
				+" Thanks for Shopping with us!! <br>  Happy Shopping!!!<br>"
				+"</h3></body></html>";
		smtpMailSender.send(i.getCustomerId().getEmail(),this.Subject,this.Body);
		return orderService.save(i);
	}
	
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
