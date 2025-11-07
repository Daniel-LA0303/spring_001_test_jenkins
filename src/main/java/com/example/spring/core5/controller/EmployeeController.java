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
import com.example.spring.core5.utils.dto.EmployeeInfoSmallInfoResponseDTO;
import com.example.spring.core5.utils.projections.EmployeeInfoSmallInfoDTO;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping()
	public ResponseEntity<List<EmployeeInfoSmallInfoResponseDTO>> getAllEmployeesSmallInfo(){
		
		return new ResponseEntity<>(employeeService.getEmployeeInfoSmallInfoNativeQuery(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeesEntity> getEmployeeById(@PathVariable Long id) {
	    EmployeesEntity employee = employeeService.getEmployeeById(id);
	    return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/get-by-email/{email}")
	public ResponseEntity<EmployeesEntity> getEmployeeEmail(@PathVariable String email) {
	    EmployeesEntity employee = employeeService.getEmployeeByEmail(email);
	    return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/get-employee-small-info/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeSmallInfo(@PathVariable Long id) {
	    EmployeeDTO dto = employeeService.getEmployeeSmallInfoById(id);
	    return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@GetMapping("/get-employee-native-query/{id}")
	public ResponseEntity<EmployeesEntity> getEmployeeNativeQuery(@PathVariable Long id) {
	    EmployeesEntity employee = employeeService.getEmployeeByIdNativeQuery(id);
	    return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/get-employee-by-email-native-query/{email}")
	public ResponseEntity<Object> getEmployeeByEmailNativeQuery(@PathVariable String email) {
	    Object employee = employeeService.getEmployeeByNameSmallInfo(email);
	    return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/get-employee-by-procedure/{id}")
	public ResponseEntity<EmployeesEntity> getEmployeeByProcedure(@PathVariable Long id) {
	    EmployeesEntity employee = employeeService.getEmployeeByProcedure(id);
	    return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/get-employee-by-procedure-v2/{id}")
	public ResponseEntity<EmployeesEntity> getEmployeeByProcedureV2(@PathVariable Long id) {
	    EmployeesEntity employee = employeeService.getEmployeeByProcedure(id);
	    return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	
	@GetMapping("/get-employees-by-view")
	public ResponseEntity<List<EmployeeView>> getEmployeesByView(){
		
		List<EmployeeView> employeeView = employeeService.getAllEmployeesByView();
		return new ResponseEntity<List<EmployeeView>>(employeeView, HttpStatus.OK);
	}
}
