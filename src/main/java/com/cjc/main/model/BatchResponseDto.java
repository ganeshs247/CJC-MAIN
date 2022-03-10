package com.cjc.main.model;

import org.springframework.http.HttpStatus;


public class BatchResponseDto {

	private Batch batch;
	private String successMsg;
	private String errorMsg;
	private HttpStatus httpStatus;
	public Batch getBatch() {
		return batch;
	}
	public String getSuccessMsg() {
		return successMsg;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public BatchResponseDto(Batch batch, String successMsg, String errorMsg, HttpStatus httpStatus) {
		super();
		this.batch = batch;
		this.successMsg = successMsg;
		this.errorMsg = errorMsg;
		this.httpStatus = httpStatus;
	}
	
	
	
}
