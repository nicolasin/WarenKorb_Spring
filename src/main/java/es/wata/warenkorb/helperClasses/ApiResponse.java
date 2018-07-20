package es.wata.warenkorb.helperClasses;

import org.springframework.http.HttpStatus;

public class ApiResponse {
	final private String message;
	final private HttpStatus status;
	public ApiResponse(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	

}
