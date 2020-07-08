package com.tvm.OnlineFishMart.OnlineFishMart.controller;

import java.util.List;
import java.util.Optional;

import com.tvm.OnlineFishMart.OnlineFishMart.Model.Cart;
import com.tvm.OnlineFishMart.OnlineFishMart.Service.CartService;
import com.tvm.OnlineFishMart.OnlineFishMart.web.ResponseAPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@Api(value = "Online Shopping", description = "REST Apis related to Cart Entity!!!!")
@Validated
//use @Validated annotation on top of controller so it is applicable to all methods in it.
public class CartController {

	@Autowired
	CartService cartService;

	private static Logger logger = LoggerFactory.getLogger(CartController.class);

	@GetMapping("/getCartById/{empId}")
	public Cart getById(@PathVariable(value = "empId") Integer empId) {
		logger.debug("Getting an Cart " + empId);
		logger.info("Success!!!");
		return cartService.findOne(empId);
	}

	@GetMapping("/Carts")
	public ResponseAPI getAll() {
		logger.debug("Getting all Carts");
		List<Cart> Carts = cartService.findAll();
		ResponseAPI res1 = new ResponseAPI("Success", Boolean.TRUE, Carts, Carts.size());
		return res1;
	}

	@PostMapping("/Carts")
	public Cart insert(@RequestBody Cart i) {
		logger.debug("Posting an Cart " + i.getCartId());
		return cartService.save(i);
	}

	@PutMapping("/Cart/{id}")
	public Cart update(@PathVariable(value = "id") Integer id, @RequestBody Cart emp) {
		logger.debug("Updating an Cart " + id);
		cartService.findOne(id);
		return cartService.update(emp);
	}

	@DeleteMapping("/Cart/{id}")
	public ResponseAPI delete(@PathVariable(value = "id") Integer id) {
		logger.debug("Deleting an Cart " + id);
		cartService.findOne(id);
		cartService.delete(id);
		return new ResponseAPI("Cart with id : " + id + " Deleted", Boolean.TRUE);

	}
	@GetMapping("/getCartByUserId")
	public List<Cart> getCartByUserId (@RequestParam Integer usersignupid){
		List<Cart> l=cartService.getCartByUserId(usersignupid);
		return l;
	}
	
	@PutMapping("/Cart/{id}/")
	public Cart updateQuantity(@PathVariable(value = "id") Integer id, 
			@RequestBody Cart emp) {
		logger.debug("Updating an Cart " + id);
		cartService.findOne(id);
		return cartService.updateQuantity(emp);
	}
	
}
