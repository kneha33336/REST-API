package com.example.restService;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	private final long id;
	
	//@JsonProperty("name")
	private final String name;
	
	private final String address;
	private final String dob;
	private final String city;
	private final String pinCode;
	
	public User(long id, String name, String address, String dob, String city, String pinCode) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.city = city;
		this.pinCode = pinCode;
	}
	
	public User(String name, String address) {
		this.id = 1;
		this.name = name;
		this.address = address;
		this.dob = "";
		this.city = "";
		this.pinCode = "812001";
	}
	
	public long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getDob() {
		return this.dob;
	}
	
	public String getCty() {
		return this.city;
	}
	
	public String getPinCode() {
		return this.pinCode;
	}
	
	public String toString(){
		return getId() + ", "+getName()+", "+getAddress()+", "+getDob()+", "+getCty()+", "+getPinCode();
	}
	
}
