package com.tvm.OnlineFishMart.OnlineFishMart.web;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException{

	private static final long serialVersionUID = -6208653503836517114L;

	public ValidationException(String message) {
		super(message);
	}

	
}
