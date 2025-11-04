package com.example.spring.core5.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.core5.entity.EmployeesEntity;
import com.example.spring.core5.entity.views.EmployeeView;
import com.example.spring.core5.service.EmployeeService;
import com.example.spring.core5.utils.dto.EmployeeDTO;
import com.example.spring.core5.utils.projections.EmployeeInfoSmallInfoDTO;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping()
	public List<EmployeeInfoSmallInfoDTO> getAllEmployeesSmallInfo(){
		return employeeService.getEmployeeInfoSmallInfoNativeQuery();
	}
	
	@GetMapping("/{id}")
	public EmployeesEntity getEmployeeById(@PathVariable Long id) {
		
		return employeeService.getEmployeeById(id);
	}

	@GetMapping("/get-by-email/{email}")
	public EmployeesEntity getEmployeeEmail(@PathVariable String email) {
		return employeeService.getEmployeeByEmail(email);
	}
	
	@GetMapping("/get-employee-small-info/{id}")
	public EmployeeDTO getEmployeeSmallInfo(@PathVariable Long id) {
		return employeeService.getEmployeeSmallInfoById(id);
	}
	
	
	@GetMapping("/get-employee-native-query/{id}")
	public EmployeesEntity getEmployeeNativeQuery(@PathVariable Long id) {
		return employeeService.getEmployeeByIdNativeQuery(id);
	}
	
	@GetMapping("/get-employee-by-email-native-query/{email}")
	public Object getEmployeeByEmailNativeQuery(@PathVariable String email) {
		return employeeService.getEmployeeByNameSmallInfo(email);
	}
	
	@GetMapping("/get-employee-by-procedure/{id}")
	public EmployeesEntity getEmployeeByProcedure(@PathVariable Long id) {
		return employeeService.getEmployeeByProcedure(id);
	}
	
	@GetMapping("/get-employee-by-procedure-v2/{id}")
	public EmployeesEntity getEmployeeByProcedureV2(@PathVariable Long id) {
		return employeeService.getEmployeeByProcedure(id);
	}
	
	@GetMapping("/get-employees-by-view")
	public ResponseEntity<List<EmployeeView>> getEmployeesByView(){
		
		List<EmployeeView> employeeView = employeeService.getAllEmployeesByView();
		
		
		return new ResponseEntity<List<EmployeeView>>(employeeView, HttpStatus.OK);
	}
}
