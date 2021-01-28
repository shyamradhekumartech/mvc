package com.example.type.response;

/**
 * This is custom response
 * @author user
 *
 */
public class CustomResponse {

	private String message;
	private String status;
	private int statusCode;
	
	public CustomResponse() {
		super();
	}
	public CustomResponse(String message, String status, int statusCode) {
		super();
		this.message = message;
		this.status = status;
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return String.format("[message=%s, status=%s, statusCode=%s]", message, status, statusCode);
	}

}
