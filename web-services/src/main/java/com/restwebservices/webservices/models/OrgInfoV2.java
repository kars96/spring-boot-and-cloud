package com.restwebservices.webservices.models;

import java.util.Date;

public class OrgInfoV2 {
	private String name;
	private Date estDate;
	private Integer employeeCount;
	private String location;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getEstDate() {
		return estDate;
	}
	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}
	public Integer getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(Integer employeeCount) {
		this.employeeCount = employeeCount;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public OrgInfoV2() {
		this.name = "ABC Inc";
		this.employeeCount = 1;
		this.estDate = new Date();
		this.location = "India";
	}
}

	