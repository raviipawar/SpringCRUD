/**
 * 
 */
package com.ravi.learning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.learning.domain.Employee;
import com.ravi.learning.repository.EmployeeRepository;

/**
 * @author 004KDG744
 *
 */
@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public void addEmployee(Employee employee) {
		employeeRepository.insert(employee);
	}

	public Optional<Employee> getEmployeesById(String id) {
		return employeeRepository.findById(id);
	}

	public void deleteEmployeeById(String id) {
		employeeRepository.deleteById(id);
	}
}
