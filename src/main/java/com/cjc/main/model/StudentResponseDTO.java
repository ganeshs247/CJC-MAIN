package com.cjc.main.model;

import org.springframework.http.HttpStatus;

public class StudentResponseDTO {

	private Student student;
	private String successMessage;
	private String errorMessage;
	private HttpStatus httpStatus;
	public StudentResponseDTO(Student student, String successMessage, String errorMessage, HttpStatus httpStatus) {
		super();
		this.student = student;
		this.successMessage = successMessage;
		this.errorMessage = errorMessage;
		this.httpStatus = httpStatus;
	}
	public Student getStudent() {
		return student;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	
}
