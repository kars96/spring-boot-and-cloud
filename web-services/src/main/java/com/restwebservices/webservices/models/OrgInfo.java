package com.restwebservices.webservices.models;

public class OrgInfo {
	private String name;
	private String desc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public OrgInfo(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	
	public OrgInfo() {
		this.name = "ABC Inc";
		this.desc = "ABC Inc is based in India. It is established in 2020. Currently it has 1 employee";
	}
}
