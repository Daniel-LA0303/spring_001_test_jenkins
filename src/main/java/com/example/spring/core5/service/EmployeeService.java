package com.example.spring.core5.service;

import java.util.List;

import com.example.spring.core5.entity.EmployeesEntity;
import com.example.spring.core5.entity.views.EmployeeView;
import com.example.spring.core5.utils.dto.EmployeeDTO;
import com.example.spring.core5.utils.projections.EmployeeInfoSmallInfoDTO;

public interface EmployeeService {
	
	public EmployeesEntity getEmployeeById(Long id);
	
	public EmployeesEntity getEmployeeByEmail(String email);
	
	public EmployeeDTO getEmployeeSmallInfoById(Long id);
	
	public EmployeesEntity getEmployeeByIdNativeQuery(Long id);
	
	public List<EmployeeInfoSmallInfoDTO> getEmployeeInfoSmallInfoNativeQuery();
	
	public Object getEmployeeByNameSmallInfo(String email);
	
	public EmployeesEntity getEmployeeByProcedure(Long id);
	
	public EmployeesEntity getEmployeeByProcedureV2(Long id);
	
	public List<EmployeeView> getAllEmployeesByView();

}
