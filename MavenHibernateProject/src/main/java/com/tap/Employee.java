package com.tap;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//This annotation means it is equivalent to certain table in database.....
@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "ename")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "salary")
	private int salary;

	public Employee(){
		
	}

	public Employee(int id, String name, String email, String department, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.salary = salary;
	}

	private int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department + ", salary="
				+ salary + "]";
	}

	
}
