package com.tvm.OnlineFishMart.OnlineFishMart.web;



import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		ErrorMessage errorMessage=new ErrorMessage(new Date(), ex.getMessage(), "yoga@lnt.com",
				req.getDescription(false));
		ResponseAPI error=new ResponseAPI(ex.getMessage(),Boolean.FALSE);
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid
	(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ErrorMessage errorMessage=new ErrorMessage
				(new Date(), "data is not valid please refer doc", "yoga@lnt.com", 
						request.getDescription(false));
		
		return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllUnclassifiedEx(Exception ex, WebRequest req){
		ErrorMessage errorMessage=new ErrorMessage(new Date(), ex.getMessage(), "yoga@lnt.com",
				req.getDescription(false));
		return new ResponseEntity<Object>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}	
	
	
}





