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

import com.tvm.OnlineFishMart.OnlineFishMart.Model.UserSignUp;
import com.tvm.OnlineFishMart.OnlineFishMart.Service.UserSignUpService;
import com.tvm.OnlineFishMart.OnlineFishMart.web.ResponseAPI;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
@EnableSwagger2
@CrossOrigin("*")
@Api(value = "Online Shopping", description = "REST Apis related to User Sign up Entity!!!!")
@Validated
//use @Validated annotation on top of controller so it is applicable to all methods in it.
public class UserSignUpController {

	@Autowired
	UserSignUpService userSignUpService;

	private static Logger logger = LoggerFactory.getLogger(UserSignUpController.class);

	@GetMapping("/getUserSignUpById/{empId}")
	public UserSignUp getById(@PathVariable(value = "empId") Integer empId) {
		logger.debug("Getting an UserSignUp " + empId);
		return userSignUpService.findOne(empId);
	}

	@GetMapping("/UserSignUps")
	public ResponseAPI getAll() {
		logger.debug("Getting all UserSignUps");
		List<UserSignUp> UserSignUps = userSignUpService.findAll();
//		Collections.sort(UserSignUps, Comparator.nullsLast(
//				Comparator.comparing(UserSignUp::getCreatedAt, Comparator.nullsLast(Comparator.reverseOrder()))));
		// Collections.sort(UserSignUps, (o1, o2) ->
		// o1.getCreatedAt().compareTo(o2.getCreatedAt()));
		// Collections.reverse(UserSignUps);
		// Comparator.nullsFirst(Comparator.comparing(UserSignUp::getCreatedAt,Comparator.nullsFirst(Comparator.reverseOrder())));
		ResponseAPI res1 = new ResponseAPI("Success", Boolean.TRUE, UserSignUps, UserSignUps.size());
		return res1;
	}

	@PostMapping("/UserSignUps")
	public UserSignUp insert(@RequestBody UserSignUp i) {
		logger.debug("Posting an UserSignUp " + i.getUserName());

		return userSignUpService.save(i);
	}

//	@GetMapping("/UserSignUpsByName1.8/{site}/{client}")
//	public List<UserSignUp> UserSignUpByRange(@PathVariable(value = "site") String site,
//			@PathVariable(value = "client") String client) {
//		return userSignUpService.findAll().stream()
//				.filter(x -> x.getSite().equalsIgnoreCase(site) && x.getClient().equalsIgnoreCase(client))
//				.collect(Collectors.toList());
//	}

//	@GetMapping("/UserSignUpsByName1.8/{name}")
//	public List<UserSignUp> UserSignUpAutocomplete(@PathVariable(value = "name") String name) {	
//		return userSignUpService.findAll().stream().filter(x -> x.getFirstName().startsWith(name))
//				.collect(Collectors.toList());
//	}

	@PutMapping("/UserSignUp/{id}")
	public UserSignUp update(@PathVariable(value = "id") Integer id, @RequestBody UserSignUp emp) {
		logger.debug("Updating an UserSignUp " + id);
		userSignUpService.findOne(id);
		return userSignUpService.update(emp);
	}

	@DeleteMapping("/UserSignUp/{id}")
	public ResponseAPI delete(@PathVariable(value = "id") Integer id) {
		logger.debug("Deleting an UserSignUp " + id);

		userSignUpService.findOne(id);

		userSignUpService.delete(id);

		return new ResponseAPI("UserSignUp with id : " + id + " Deleted", Boolean.TRUE);

	}

}
