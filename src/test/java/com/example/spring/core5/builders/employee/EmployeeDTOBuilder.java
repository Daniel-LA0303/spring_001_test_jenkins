package com.example.spring.core5.builders.employee;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.spring.core5.utils.dto.EmployeeDTO;

public class EmployeeDTOBuilder {
	
	private Long employeeId;
	
	private String name;
	
	private String email;
	
	private BigDecimal salary;
	
	private Boolean active;
	
	private LocalDateTime createdAt;

	public static EmployeeDTOBuilder withAllDummy() {
	    return new EmployeeDTOBuilder()
	            .setEmployeeId(1L)
	            .setName("Luis Martinez")
	            .setEmail("luis.martinez@example.com")
	            .setSalary(new BigDecimal("23000.30"))
	            .setActive(true)
	            .setCreatedAt(LocalDateTime.of(2025, 4, 22, 15, 10, 0));
	}

	
	public EmployeeDTO build() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setActive(active);
		employeeDTO.setCreatedAt(createdAt);
		employeeDTO.setEmail(email);
		employeeDTO.setEmployeeId(employeeId);
		employeeDTO.setName(name);
		employeeDTO.setSalary(salary);
		
		return employeeDTO;
	}
	
	/**
	 * @param employeeId the employeeId to set
	 */
	public EmployeeDTOBuilder setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
		return this;
	}

	/**
	 * @param name the name to set
	 */
	public EmployeeDTOBuilder setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @param email the email to set
	 */
	public EmployeeDTOBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	/**
	 * @param salary the salary to set
	 */
	public EmployeeDTOBuilder setSalary(BigDecimal salary) {
		this.salary = salary;
		return this;
	}

	/**
	 * @param active the active to set
	 */
	public EmployeeDTOBuilder setActive(Boolean active) {
		this.active = active;
		return this;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public EmployeeDTOBuilder setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
		return this;
	}
	
}
