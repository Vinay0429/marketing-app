package com.marketingapp.exception;


import java.util.Date;

import org.apache.jasper.compiler.JavacErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.marketingapp.dto.ErrorDetail;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetail>handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest webRequest){
		
		ErrorDetail errorDetails=new ErrorDetail(new Date(),exception.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> globalException(
			Exception e,
			WebRequest webRequest
			){
		
		
		ErrorDetail error=new ErrorDetail(new Date(), e.getMessage(), webRequest.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.OK);
		
		
}
}
