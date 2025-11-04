package com.example.spring.core5.entity.views;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "view_employee_complex1")
public class EmployeeView {
	
	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "salary")
	private BigDecimal salary;	

	public EmployeeView() {
	}

	public EmployeeView(String email, String name, BigDecimal salary) {
		this.email = email;
		this.name = name;
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}
