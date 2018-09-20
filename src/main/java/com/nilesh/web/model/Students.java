  package com.nilesh.web.model;

import javax.persistence.Entity;


public class Students {

	
	@org.springframework.data.annotation.Id
	String id;
	String name;
	String roll_no;
	Long mobile;
	String email;
	
	
	
	
	public Students(String id, String name, String roll_no, Long mobile, String emial) {
		super();
		this.id = id;
		this.name = name;
		this.roll_no = roll_no;
		this.mobile = mobile;
		this.email = emial;
	}
	public Students() {
	
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getEmial() {
		return email;
	}
	public void setEmial(String emial) {
		this.email = emial;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", roll_no=" + roll_no + ", mobile=" + mobile + ", emial="
				+ email + "]";
	}
	
	
	
}
