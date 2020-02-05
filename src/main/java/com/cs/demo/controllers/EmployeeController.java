/**
 * 
 */
package com.cs.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.demo.entity.Employee;
import com.cs.demo.exceptions.ResourceNotFoundException;
import com.cs.demo.repository.EmployeeRepository;

@RestController
@RequestMapping ( "api/v1/emp")

public class EmployeeController {

@Autowired
private EmployeeRepository employeeRepository;

@PostMapping("/employee")
public Employee createEmployee(@Valid @RequestBody Employee employee) {
	return employeeRepository.save(employee);
}

@GetMapping("/employee") //http://localhost:8080//api/v1/emp/employee
public List<Employee> getAllEmployee() {
	return employeeRepository.findAll();
}

@GetMapping("/employee/{id}") //http://localhost 8080//api/v1/employee/{id}
public ResponseEntity<Employee> findById(@PathVariable(value = "id")Long Employeeid) 
throws ResourceNotFoundException{
	Employee employee = employeeRepository.findById(Employeeid)
			.orElseThrow(() -> new ResourceNotFoundException ("Employee not found"));
	return ResponseEntity.ok().body(employee);
}

@PutMapping("/emplyee/{id}")
public ResponseEntity<Employee> employeeUpdate(@PathVariable(value = "id")Long Employeeid,
		@Valid @RequestBody Employee employeeDetails) 
throws ResourceNotFoundException{
	Employee employee = employeeRepository.findById(Employeeid)
			.orElseThrow(() -> new ResourceNotFoundException ("Employee not found"));
	
	employee.setName(employeeDetails.getName());
	employee.setRole(employeeDetails.getRole());
	employee.setPay(employeeDetails.getPay());
	
	final Employee employeeUpdated = employeeRepository.save(employee);
	return ResponseEntity.ok().body(employeeUpdated);
}



@DeleteMapping("/employee/{id}") //http://localhost 808/api/v1/emp/{id}
public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long Employeeid)
		throws ResourceNotFoundException {
	Employee employee = employeeRepository.findById(Employeeid)
			.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

	employeeRepository.delete(employee);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return response;
}

}
