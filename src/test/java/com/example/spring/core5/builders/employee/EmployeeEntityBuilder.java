package com.example.spring.core5.builders.employee;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.spring.core5.entity.EmployeesEntity;

public class EmployeeEntityBuilder {

	private Long employeeId;

	private String name;

	private String email;

	private BigDecimal salary;

	private String bio;

	private Boolean active;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
	
	public static EmployeeEntityBuilder withAllDummy() {
	    return new EmployeeEntityBuilder()
	            .setEmployeeId(null) // ID se deja null porque es autogenerado
	            .setName("Helen Cruz")
	            .setEmail("helen.cruz@example.com")
	            .setSalary(new BigDecimal("15500.00"))
	            .setBio("Technical support specialist focused on customer service and documentation.")
	            .setActive(true)
	            .setCreatedAt(LocalDateTime.parse("2025-05-01T09:45:00"))
	            .setUpdatedAt(LocalDateTime.parse("2025-05-01T09:45:00"));
	}


	public EmployeesEntity build() {
		EmployeesEntity employeesEntity = new EmployeesEntity();
		employeesEntity.setActive(active);
		employeesEntity.setBio(bio);
		employeesEntity.setCreatedAt(createdAt);
		employeesEntity.setEmail(email);
		employeesEntity.setEmployeeId(employeeId);
		employeesEntity.setName(name);
		employeesEntity.setSalary(salary);
		employeesEntity.setUpdatedAt(updatedAt);
		
		return employeesEntity;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public EmployeeEntityBuilder setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
		return this;
	}

	/**
	 * @param name the name to set
	 */
	public EmployeeEntityBuilder setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @param email the email to set
	 */
	public EmployeeEntityBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	/**
	 * @param salary the salary to set
	 */
	public EmployeeEntityBuilder setSalary(BigDecimal salary) {
		this.salary = salary;
		return this;
	}

	/**
	 * @param bio the bio to set
	 */
	public EmployeeEntityBuilder setBio(String bio) {
		this.bio = bio;
		return this;
	}

	/**
	 * @param active the active to set
	 */
	public EmployeeEntityBuilder setActive(Boolean active) {
		this.active = active;
		return this;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public EmployeeEntityBuilder setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public EmployeeEntityBuilder setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
		return this;
	}

}
