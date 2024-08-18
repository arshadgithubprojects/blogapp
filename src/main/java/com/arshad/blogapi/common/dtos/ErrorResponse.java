package com.arshad.blogapi.common.dtos;

import lombok.Data;

@Data
public class ErrorResponse {
    public ErrorResponse() {
	}

	public ErrorResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;
}
