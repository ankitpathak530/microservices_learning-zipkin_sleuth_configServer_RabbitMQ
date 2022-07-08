package com.demo.exception;

import java.util.LinkedHashMap;
import java.util.Map;
import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ExchangeNotFoundException.class)
	public ResponseEntity<Object> handleAllException(ExchangeNotFoundException e, WebRequest request) {
		
		Map<String, Object> body = new LinkedHashMap<>();
		  body.put("timestamp", LocalDate.now());
		  body.put("message", "Exchange Not Found");

		  return ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body(body);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception e, WebRequest request) {
		
		Map<String, Object> body = new LinkedHashMap<>();
		  body.put("timestamp", LocalDate.now());
		  body.put("message", "Something went wrong check 'from' and 'to' and try again.");

		  return ResponseEntity.status(org.springframework.http.HttpStatus.NOT_FOUND).body(body);
	}
}
