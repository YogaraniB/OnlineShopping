package com.tvm.OnlineFishMart.OnlineFishMart.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice // is working in aop way!
public class CustomExHandler extends ResponseEntityExceptionHandler {

	//i will not call this method spring call it internlly using aop
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(Exception ex, WebRequest req){
		List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
		ErrorMessage errorMessage=new ErrorMessage(new Date(), details, "yoga@lnt.com",
				req.getDescription(false));
		ResponseAPI error=new ResponseAPI(ex.getMessage(),Boolean.FALSE);
		return new ResponseEntity<Object>(errorMessage, HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@ExceptionHandler(ValidationException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValid
	(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
		ErrorMessage errorMessage=new ErrorMessage
				(new Date(), details, "yoga@lnt.com", 
						request.getDescription(false));
		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllUnclassifiedEx(Exception ex, WebRequest req){
		List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
		ErrorMessage errorMessage=new ErrorMessage(new Date(), details, "yoga@lnt.com",
				req.getDescription(false));
		return new ResponseEntity<Object>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}	
}





