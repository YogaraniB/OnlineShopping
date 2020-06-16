package com.tvm.OnlineFishMart.OnlineFishMart.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tvm.OnlineFishMart.OnlineFishMart.Model.Product;
import com.tvm.OnlineFishMart.OnlineFishMart.Model.File.FileModel;
import com.tvm.OnlineFishMart.OnlineFishMart.Service.CategoryService;
import com.tvm.OnlineFishMart.OnlineFishMart.Service.ProductService;
import com.tvm.OnlineFishMart.OnlineFishMart.web.ResponseAPI;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@RequestMapping("/api/v1")
@Api(value = "Product Controller", description = "REST Apis related to Product Entity!!!!")
@org.springframework.web.bind.annotation.RestController
@CrossOrigin("*")
@EnableSwagger2
@Validated
//use @Validated annotation on top of controller so it is applicable to all methods in it.
public class ProductController {

	@Autowired
	ProductService productService;
	
	
	@Autowired
	com.tvm.OnlineFishMart.OnlineFishMart.Model.File.FileService fileRepository;

	private static Logger logger = LoggerFactory.getLogger(ProductController.class);

	@GetMapping("/getProductById/{ProductId}")
	public Product getById(@PathVariable(value = "ProductId") Long ProductId) throws IOException {
		logger.debug("Getting an Employee " + ProductId);
		Product li=productService.findOne(ProductId);
		return productService.findOne(ProductId);
	}
	@PostMapping("/Products")
	public Product insert(@RequestBody Product i) {
		logger.debug("Posting an Categories " + i.getName());
		return productService.save(i);
	}
	@GetMapping("/Products")
	public ResponseAPI getAll() {
		logger.debug("Getting all Employees");
		List<Product> employees = productService.findAll();
//		Collections.sort(employees, Comparator.nullsLast(
//				Comparator.comparing(EmployeeProfile::getCreatedAt, Comparator.nullsLast(Comparator.reverseOrder()))));
		// Collections.sort(employees, (o1, o2) ->
		// o1.getCreatedAt().compareTo(o2.getCreatedAt()));
		// Collections.reverse(employees);
		// Comparator.nullsFirst(Comparator.comparing(Employee::getCreatedAt,Comparator.nullsFirst(Comparator.reverseOrder())));
		ResponseAPI res1 = new ResponseAPI("Success", Boolean.TRUE, employees, employees.size());
		return res1;
	}

	

	
	
	
}
