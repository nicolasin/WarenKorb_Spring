package es.wata.warenkorb.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import es.wata.warenkorb.exceptions.ServiceException;
import es.wata.warenkorb.helperClasses.ApiResponse;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)

	protected ResponseEntity<ApiResponse> genericHandler(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Error in the server: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
	}

	@ExceptionHandler(ServiceException.class)

	protected ResponseEntity<ApiResponse> serviceHandlerException(ServiceException e) {

		return ResponseEntity.status(e.getStatus()).body(e.getResponse());
	}
}
