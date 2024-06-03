package com.zetta.bank.accounts.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.zetta.bank.accounts.dto.ErrorResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomerexistsException(CustomerAlreadyExistsException exception,
			                                                              WebRequest webRequest){
		ErrorResponseDto errRes = new ErrorResponseDto();
		errRes.setApiPath(webRequest.getDescription(false));
		errRes.setErrorCode(HttpStatus.BAD_REQUEST);
		errRes.setErrorMsg(exception.getMessage());
		errRes.setErrorTime(LocalDateTime.now());
		return new ResponseEntity<ErrorResponseDto>(errRes,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception,
			WebRequest webRequest){
		ErrorResponseDto errRes = new ErrorResponseDto();
		errRes.setApiPath(webRequest.getDescription(false));
		errRes.setErrorCode(HttpStatus.BAD_REQUEST);
		errRes.setErrorMsg(exception.getMessage());
		errRes.setErrorTime(LocalDateTime.now());
		return new ResponseEntity<ErrorResponseDto>(errRes,HttpStatus.BAD_REQUEST);
	}
	

}
