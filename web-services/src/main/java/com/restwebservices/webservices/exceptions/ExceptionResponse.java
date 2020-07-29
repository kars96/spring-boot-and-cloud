package com.restwebservices.webservices.exceptions;

import java.util.Date;

public class ExceptionResponse {
	private Date timestamp;
	private String desc;
	private String error;
	public ExceptionResponse(Date timestamp, String desc, String error) {
		super();
		this.timestamp = timestamp;
		this.desc = desc;
		this.error = error;
	}
	
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
}
