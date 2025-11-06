package com.example.spring.core5.integration.employee;

import java.net.SocketTimeoutException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.example.spring.core5.builders.employee.EmployeeEntityBuilder;
import com.example.spring.core5.entity.EmployeesEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Sql(scripts = "/import.sql")
@ActiveProfiles("test")
public class EmployeeServiceTest {
	
	/**
	 * test rest template
	 */
	@Autowired
	private TestRestTemplate testRestTemplate;

	/**
	 * port
	 */
	@LocalServerPort
	private int port;

	/**
	 * headers
	 */
	HttpHeaders headers;
	
	/**
	 * entity
	 */
	EmployeesEntity employeesEntityBuilder;
	
	@BeforeEach
	void setUp() {

		employeesEntityBuilder = EmployeeEntityBuilder.withAllDummy().build();

		headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);

	}
	
	@Test
	@Order(1)
	void getEmployeeByIdSuccessTest() {
		
		// 10 id
		ResponseEntity<EmployeesEntity> response = testRestTemplate.exchange(
				"/employee/10", HttpMethod.GET, null,
				new ParameterizedTypeReference<EmployeesEntity>() {
				});
		
		System.out.println("*********** RESPONSE *************");
		EmployeesEntity employee = response.getBody();
		
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(200, response.getStatusCodeValue());
		
		assertNotNull(employee.getEmployeeId());
		assertEquals(employee.getName(), employeesEntityBuilder.getName());
		assertEquals(employee.getActive(), employeesEntityBuilder.getActive());
		assertEquals(employee.getEmail(), employeesEntityBuilder.getEmail());
		assertEquals(employee.getSalary(), employeesEntityBuilder.getSalary());
		assertEquals(employee.getBio(), employeesEntityBuilder.getBio());
		assertNotNull(employee.getCreatedAt());
		assertNotNull(employee.getUpdatedAt());
		
		System.out.println(employee.getName());
		
	}
	
	@Test
	@Order(2)
	void getEmployeeByEmailSuccessTest() {
		
		// 10 id
		ResponseEntity<EmployeesEntity> response = testRestTemplate.exchange(
				"/employee/get-by-email/helen.cruz@example.com", HttpMethod.GET, null,
				new ParameterizedTypeReference<EmployeesEntity>() {
				});
		
		System.out.println("*********** RESPONSE *************");
		EmployeesEntity employee = response.getBody();
		
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(200, response.getStatusCodeValue());
		
		assertNotNull(employee.getEmployeeId());
		assertEquals(employee.getName(), employeesEntityBuilder.getName());
		assertEquals(employee.getActive(), employeesEntityBuilder.getActive());
		assertEquals(employee.getEmail(), employeesEntityBuilder.getEmail());
		assertEquals(employee.getSalary(), employeesEntityBuilder.getSalary());
		assertEquals(employee.getBio(), employeesEntityBuilder.getBio());
		assertNotNull(employee.getCreatedAt());
		assertNotNull(employee.getUpdatedAt());
		
		System.out.println(employee.getName());
		
	}

	
	@Test
	@Order(3)
	void getEmployeeNativeQuerySuccessTest() {
		
		// 10 id
		ResponseEntity<EmployeesEntity> response = testRestTemplate.exchange(
				"/employee/get-employee-native-query/10", HttpMethod.GET, null,
				new ParameterizedTypeReference<EmployeesEntity>() {
				});
		
		System.out.println("*********** RESPONSE *************");
		EmployeesEntity employee = response.getBody();
		
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(200, response.getStatusCodeValue());
		
		assertNotNull(employee.getEmployeeId());
		assertEquals(employee.getName(), employeesEntityBuilder.getName());
		assertEquals(employee.getActive(), employeesEntityBuilder.getActive());
		assertEquals(employee.getEmail(), employeesEntityBuilder.getEmail());
		assertEquals(employee.getSalary(), employeesEntityBuilder.getSalary());
		assertEquals(employee.getBio(), employeesEntityBuilder.getBio());
		assertNotNull(employee.getCreatedAt());
		assertNotNull(employee.getUpdatedAt());
		
		System.out.println(employee.getName());
		
	}
	
	@Test
	@Order(4)
	void getEmployeeByIdByProcedureSuccessTest() {
		
		// 10 id
		ResponseEntity<EmployeesEntity> response = testRestTemplate.exchange(
				"/employee/get-employee-by-procedure/10", HttpMethod.GET, null,
				new ParameterizedTypeReference<EmployeesEntity>() {
				});
		
		System.out.println("*********** RESPONSE *************");
		EmployeesEntity employee = response.getBody();
		
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(200, response.getStatusCodeValue());
		
		assertNotNull(employee.getEmployeeId());
		assertEquals(employee.getName(), employeesEntityBuilder.getName());
		assertEquals(employee.getActive(), employeesEntityBuilder.getActive());
		assertEquals(employee.getEmail(), employeesEntityBuilder.getEmail());
		assertEquals(employee.getSalary(), employeesEntityBuilder.getSalary());
		assertEquals(employee.getBio(), employeesEntityBuilder.getBio());
		assertNotNull(employee.getCreatedAt());
		assertNotNull(employee.getUpdatedAt());
		
		System.out.println(employee.getName());
		
	}
	
	
	@Test
	@Order(4)
	void getEmployeeByIdByProcedureV2SuccessTest() {
		
		// 10 id
		ResponseEntity<EmployeesEntity> response = testRestTemplate.exchange(
				"/employee/get-employee-by-procedure-v2/10", HttpMethod.GET, null,
				new ParameterizedTypeReference<EmployeesEntity>() {
				});
		
		System.out.println("*********** RESPONSE *************");
		EmployeesEntity employee = response.getBody();
		
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(200, response.getStatusCodeValue());
		
		assertNotNull(employee.getEmployeeId());
		assertEquals(employee.getName(), employeesEntityBuilder.getName());
		assertEquals(employee.getActive(), employeesEntityBuilder.getActive());
		assertEquals(employee.getEmail(), employeesEntityBuilder.getEmail());
		assertEquals(employee.getSalary(), employeesEntityBuilder.getSalary());
		assertEquals(employee.getBio(), employeesEntityBuilder.getBio());
		assertNotNull(employee.getCreatedAt());
		assertNotNull(employee.getUpdatedAt());
		
		System.out.println(employee.getName());
		
	}

}
