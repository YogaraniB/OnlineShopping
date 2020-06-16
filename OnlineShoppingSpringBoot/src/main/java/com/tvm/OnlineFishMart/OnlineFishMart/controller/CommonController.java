package com.tvm.OnlineFishMart.OnlineFishMart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Api(value = "Online Shopping Controller", description = "REST Apis related to Online Shopping Entity!!!!")
@org.springframework.web.bind.annotation.RestController
@CrossOrigin("*")
@EnableSwagger2
@Validated
//use @Validated annotation on top of controller so it is applicable to all methods in it.
public class CommonController {


	private static Logger logger = LoggerFactory.getLogger(CommonController.class);

	@RequestMapping("/api/v1")
	public String index() {
		logger.trace("Welcome to Online Shopping");
		return "Welcome to Online Shopping!!! 8019";
	}

	

}
