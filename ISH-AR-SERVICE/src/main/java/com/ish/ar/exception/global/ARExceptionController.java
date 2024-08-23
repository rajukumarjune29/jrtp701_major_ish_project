package com.ish.ar.exception.global;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ish.ar.exception.CitizenNotFoundException;

@RestControllerAdvice
public class ARExceptionController {

	@ExceptionHandler(CitizenNotFoundException.class)
	public ResponseEntity<?> citizenNotFoundHandler(CitizenNotFoundException e){
		return new ResponseEntity<String> (e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
