package com.ish.dc.exception.global;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ish.dc.exception.CaseDetailsNotFoundException;
import com.ish.dc.exception.CitizenNotFoundException;

@RestControllerAdvice
public class DcExceptionHandlerController {

	@ExceptionHandler(CitizenNotFoundException.class)
	public ResponseEntity<?> citizenNotFoundExceptinHandler(CitizenNotFoundException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CaseDetailsNotFoundException.class)
	public ResponseEntity<?> caseDetailsNotFoundExceptionHandler(CaseDetailsNotFoundException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
