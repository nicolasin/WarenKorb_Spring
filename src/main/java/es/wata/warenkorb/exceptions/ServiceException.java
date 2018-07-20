package es.wata.warenkorb.exceptions;

import org.springframework.http.HttpStatus;

import es.wata.warenkorb.helperClasses.ApiResponse;

public class ServiceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3252563469737057893L;
	private ApiResponse apiResponse;
	HttpStatus status;

	public ServiceException(ApiResponse apiResponse) {
		super(apiResponse.getMessage());
		this.apiResponse = apiResponse;
		this.status = apiResponse.getStatus();
		
	}

	public HttpStatus getStatus() {
		return status;
	}
	public ApiResponse getResponse() {
		return this.apiResponse;
	}
	public String getMessage() {
		return apiResponse.getMessage();
	}

}
