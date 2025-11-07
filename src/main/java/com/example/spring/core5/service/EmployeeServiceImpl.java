package com.example.spring.core5.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.core5.entity.EmployeesEntity;
import com.example.spring.core5.entity.views.EmployeeView;
import com.example.spring.core5.repository.EmployeeRepository;
import com.example.spring.core5.repository.views.EmployeeViewRepository;
import com.example.spring.core5.utils.dto.EmployeeDTO;
import com.example.spring.core5.utils.dto.EmployeeInfoSmallInfoResponseDTO;
import com.example.spring.core5.utils.projections.EmployeeInfoSmallInfoDTO;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	private EmployeeViewRepository employeeViewRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeViewRepository employeeViewRepository) {
		this.employeeRepository = employeeRepository;
		this.employeeViewRepository = employeeViewRepository;
	}

	@Override
	public EmployeesEntity getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public EmployeesEntity getEmployeeByEmail(String email) {
		return employeeRepository.getEmployeeByEmail(email);
	}

	@Override
	public EmployeeDTO getEmployeeSmallInfoById(Long id) {
		return employeeRepository.getEmployeeSmallInfoById(id);
	}

	@Override
	public EmployeesEntity getEmployeeByIdNativeQuery(Long id) {
		return employeeRepository.getEmployeeByIdNativeQuery(id);
	}

	@Override
	public List<EmployeeInfoSmallInfoResponseDTO> getEmployeeInfoSmallInfoNativeQuery() {
		 List<EmployeeInfoSmallInfoDTO> projections = employeeRepository.getAllEmployeesSmallInfo();
		    
		    return projections.stream()
		        .map(p -> new EmployeeInfoSmallInfoResponseDTO(p.getId(), p.getName(), p.getEmail(), p.getSalary()))
		        .toList();
	}

	@Override
	public Object getEmployeeByNameSmallInfo(String email) {

		return employeeRepository.getEmployeeByNameSmallInfo(email);
	}

	@Override
    @Transactional
	public EmployeesEntity getEmployeeByProcedure(Long id) {

		return employeeRepository.getEmployeeByProcedureV1(id);
	}
	
	/*@Override
    @Transactional
	public EmployeesEntity getEmployeeByProcedureV2(Long id) {

		return employeeRepository.getEmployeeByProcedureV2(id);
	}*/

	@Override
	public List<EmployeeView> getAllEmployeesByView() {
		return employeeViewRepository.findAll();
	}

}
