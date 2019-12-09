package com.subbu.microservices.currencyserver.error;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {
	private HttpStatus status;
	
	
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;
//	private List<ApiSubError> subErrors;
	
	private ApiError() {
		
	}
}
