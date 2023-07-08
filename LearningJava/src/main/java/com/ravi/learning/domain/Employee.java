/**
 * 
 */
package com.ravi.learning.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author 004KDG744
 *
 */
@Document("employees")
public class Employee {

	@Id
	private String id;
	private String name;
	private int age;
	private String designation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Employee(String id, String name, int age, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", designation=" + designation + "]";
	}

}
