package com.niit.collaboration.model;

import javax.persistence.Transient;

public class BaseDomain {

	@Transient //not to show in the db
	private String errorCode;
	
	@Transient 
	private String errorMessage;
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	

}
