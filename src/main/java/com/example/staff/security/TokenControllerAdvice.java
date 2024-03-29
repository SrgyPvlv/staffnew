package com.example.staff.security;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.staff.exception.TokenRefreshException;

import java.util.Date;

import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class TokenControllerAdvice {

	@ExceptionHandler(value = TokenRefreshException.class)
	  @ResponseStatus(HttpStatus.FORBIDDEN)
	  public ErrorMessage handleTokenRefreshException(TokenRefreshException ex, WebRequest request) {
	    return new ErrorMessage(
	        HttpStatus.FORBIDDEN.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	  }
}
