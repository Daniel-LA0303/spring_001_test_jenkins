package com.example.spring.core5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.example.spring.core5.entity.EmployeesEntity;
import com.example.spring.core5.utils.dto.EmployeeDTO;
import com.example.spring.core5.utils.projections.EmployeeInfoSmallInfoDTO;

public interface EmployeeRepository extends JpaRepository<EmployeesEntity, Long>{
	
	
	// 1. consulta automatica
	public EmployeesEntity getEmployeeByEmail(String email);
	
	// 2. consulta JPQL con entidad
	
	
	
	// 2. consulta JPQL con dto
	@Query("select new com.example.spring.core5.utils.dto.EmployeeDTO(e.employeeId, e.name, e.email, e.salary, e.active, e.createdAt) " +  
			 "from EmployeesEntity e where e.employeeId = :id")
	public EmployeeDTO getEmployeeSmallInfoById(@Param("id") Long id);
	
	/* 4. Query nativo - SELECT simple con entidad
    * No requiere mapear la entidad, una vez hecha la conexion conoce las tablas que estan en la db
    * Eso se hace en casos especificos
    */
	@Query(value = "SELECT * FROM employees where id = :employeeId", nativeQuery = true)
	public EmployeesEntity getEmployeeByIdNativeQuery(@Param("employeeId") Long employeeId);
	
	/**
	 * 5. query nativo con proyeccion de interfaz
	 */
	@Query(value = "select id, name, email, salary from employees", nativeQuery = true)
	public List<EmployeeInfoSmallInfoDTO> getAllEmployeesSmallInfo();
	
	/**
	 * 6. query nativo con respuesta de objeto generico
	 * resultado:
	 * 1,
	 * "name",
	 * "email",
	 * 10.00
	 */
	@Query(value = "select id, name, email, salary from employees where email = :email ", nativeQuery = true)
	public Object getEmployeeByNameSmallInfo(@Param("email") String email);
	
	// procedimeintos 
	/**
	 * 1. usando @procedure
	 */
    @Procedure(name = "GetEmployeeById", procedureName = "GetEmployeeById")
    EmployeesEntity getEmployeeByProcedureV1(@Param("EmployeeID") Long id);
    
    /**
     * 2. usando un native query
     */
    @Query(value = "call GetEmployeeById(:EmployeeID)", nativeQuery = true)
    EmployeesEntity getEmployeeByProcedureV2(@Param("EmployeeID") Long id);
    
    

}
