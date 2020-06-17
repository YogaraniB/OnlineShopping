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

import com.tvm.OnlineFishMart.OnlineFishMart.Model.Category;
import com.tvm.OnlineFishMart.OnlineFishMart.Model.Product;
import com.tvm.OnlineFishMart.OnlineFishMart.Model.File.FileModel;
import com.tvm.OnlineFishMart.OnlineFishMart.Service.CategoryService;
import com.tvm.OnlineFishMart.OnlineFishMart.web.ResponseAPI;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@RequestMapping("/api/v1")
@Api(value = "Category Controller", description = "REST Apis related to Category Entity!!!!")
@org.springframework.web.bind.annotation.RestController
@CrossOrigin("*")
@EnableSwagger2
@Validated
//use @Validated annotation on top of controller so it is applicable to all methods in it.
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	
	@Autowired
	com.tvm.OnlineFishMart.OnlineFishMart.Model.File.FileService fileRepository;

	private static Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@GetMapping("/getCategoryById/{categoryId}")
	public Category getById(@PathVariable(value = "categoryId") Long categoryId) throws IOException {
		logger.debug("Getting an Employee " + categoryId);
		Category li=categoryService.findOne(categoryId);
		getCategoryListWithImage(li.getId());
		return categoryService.findOne(categoryId);
	}
	
	@GetMapping("/Categories")
	public ResponseAPI getAll() {
		logger.debug("Getting all Employees");
		List<Category> employees = categoryService.findAll();
//		Collections.sort(employees, Comparator.nullsLast(
//				Comparator.comparing(EmployeeProfile::getCreatedAt, Comparator.nullsLast(Comparator.reverseOrder()))));
		// Collections.sort(employees, (o1, o2) ->
		// o1.getCreatedAt().compareTo(o2.getCreatedAt()));
		// Collections.reverse(employees);
		// Comparator.nullsFirst(Comparator.comparing(Employee::getCreatedAt,Comparator.nullsFirst(Comparator.reverseOrder())));
		ResponseAPI res1 = new ResponseAPI("Success", Boolean.TRUE, employees, employees.size());
		return res1;
	}
	
	@PostMapping(value="/SaveCategory", consumes = {"multipart/form-data"})
	public String uploadMultipartFilewithImage(@RequestParam("uploadfile") MultipartFile file,
			@RequestParam String categoryName,@RequestParam String categoryDescription,
			@RequestParam Integer quantity,@RequestParam BigDecimal price,@RequestParam Long productId) {
		try {
			Product p=new Product(productId);
			Category ca=new Category( categoryName,categoryDescription,file.getBytes(),quantity,price,p);
			categoryService.save(ca);
//			FileModel filemode = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
//			fileRepository.save(filemode);
			return "File Saved Successfully! -Id is " +ca.getId();

		} catch (Exception e) {
			e.printStackTrace();
			return "Failed";
		}
	}
	
	@GetMapping("/getSingleCategory/{fileId}")
	public ResponseEntity<Resource> getCategoryListWithImage(@PathVariable Long fileId) throws IOException {
		Category li=categoryService.findOne(fileId);
		logger.info("Getting image file");
//	      byte [] data = li.getImgid();
//	      ByteArrayInputStream bis = new ByteArrayInputStream(data);
//	      BufferedImage bImage2 = ImageIO.read(bis);
//	      ImageIO.write(bImage2, "jpg", new File("output.jpg") );
//	      System.out.println("image created");
	      return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/png"))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +li.getCategoryName() + "\"")
					.body(new ByteArrayResource(li.getImgid()));
	}
	
	
}
