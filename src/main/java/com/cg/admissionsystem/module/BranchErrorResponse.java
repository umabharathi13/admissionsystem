package com.cg.admissionsystem.module;

import org.springframework.http.HttpStatus;

public class BranchErrorResponse {

	private int status;
	private String message;
	private long timeStamp;

	public BranchErrorResponse() {
	}

	public BranchErrorResponse(int status, String message, long timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public void setStatus(HttpStatus notFound) {
	}

	public void setStatus(int value) {
	}
}
