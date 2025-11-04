package com.example.spring.core5.utils.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EmployeeDTO {
	
	private Long employeeId;
	
	private String name;
	
	private String email;
	
	private BigDecimal salary;
	
	private Boolean active;
	
	private LocalDateTime createdAt;
	
	public EmployeeDTO() {
	}
	
	public EmployeeDTO(Long employeeId, String name, String email, BigDecimal salary, Boolean active,
			LocalDateTime createdAt) {
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.active = active;
		this.createdAt = createdAt;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public Boolean getActive() {
		return active;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
