package com.example.spring.core5.utils.dto;

public class EmployeeInfoSmallInfoResponseDTO {
	
    private Long id;
    
    private String name;
    
    private String email;
    
    private Double salary;

    public EmployeeInfoSmallInfoResponseDTO(Long id, String name, String email, Double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}    

}
