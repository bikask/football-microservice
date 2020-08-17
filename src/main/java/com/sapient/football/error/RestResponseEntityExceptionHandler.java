package com.sapient.football.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sapient.football.exception.TeamNotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	public RestResponseEntityExceptionHandler() {
        super();
    }

	
 	@ExceptionHandler(value = { TeamNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(final TeamNotFoundException ex, final WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
 	
 	@ExceptionHandler(value = { Exception.class })
 	protected ResponseEntity<Object> handleAllException(final RuntimeException ex, final WebRequest request) {
 		final String bodyOfResponse = "internalserver error";
 		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
 	}
}
