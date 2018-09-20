package com.nilesh.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



@Entity
public class Employee {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String name;
	String dept;
	Long mobile;
	String email;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Long id, String name, String dept, Long mobile, String emial) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.mobile = mobile;
		this.email = emial;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String emial) {
		this.email = emial;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", mobile=" + mobile + ", emial=" + email
				+ "]";
	}
	
	
}
