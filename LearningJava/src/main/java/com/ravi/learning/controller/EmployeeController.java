/**
 * 
 */
package com.ravi.learning.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.learning.domain.Employee;
import com.ravi.learning.service.EmployeeService;

/**
 * @author 004KDG744
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/all")
	public List<Employee> getEmployee() {
		return employeeService.getEmployees();
	}

	@GetMapping("/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable String id) {
		return employeeService.getEmployeesById(id);
	}

	@PostMapping("/add")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable String id) {
		employeeService.deleteEmployeeById(id);
		return "Employee with " + id + "  is deleted";
	}

	@GetMapping("/maxAge")
	public Employee getEmployeeHavingmaxAge() {
		List<Employee> emp = employeeService.getEmployees();
		Employee empl = emp.stream().max(Comparator.comparing(Employee::getAge)).get();
		return empl;
	}

	@GetMapping("/sortByAge")
	public List<Employee> getEmployeeSortedByAge() {
		List<Employee> emp = employeeService.getEmployees();
		Comparator<Employee> comparator = Comparator.comparing(Employee::getAge);
		List<Employee> emp1 = emp.stream().min(comparator).stream().collect(Collectors.toList());
		emp1.forEach(System.out::println);
		return emp1;
	}
	
	@GetMapping("/getCount")
	public Long getTotalEmployee() {
		List<Employee> emp = employeeService.getEmployees();
		long count = emp.stream().count();
		return count;
	}
}
