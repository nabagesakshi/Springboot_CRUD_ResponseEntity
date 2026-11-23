package com.CRUD.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.CRUD.response.ErrorResponse;


import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandller {
	
@ExceptionHandler(StudentNotFoundException.class)
public ResponseEntity<ErrorResponse>handleStudentNotFoundException(StudentNotFoundException ex,HttpServletRequest request){
	ErrorResponse errorResponse=new ErrorResponse(
			LocalDateTime.now(),
			HttpStatus.NOT_FOUND.value(),
			HttpStatus.NOT_FOUND.getReasonPhrase(),
			ex.getMessage(),
			request.getRequestURI()
			);
	return new ResponseEntity<>(
		errorResponse,HttpStatus.CONFLICT
	);
	
	//@ExceptionHandler(StudentNotFoundException.class)
	
}
}
