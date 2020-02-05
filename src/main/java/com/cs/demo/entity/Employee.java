/**
 * 
 */
package com.cs.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "EmployeeInfo")
public class Employee {

	private long id;
	private String name;
	private String role;
	private float pay;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param name
	 * @param role
	 * @param pay
	 */
	public Employee(long id, String name, String role, float pay) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.pay = pay;
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column (name = "empName", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column (name = "empRole", nullable = false)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Column (name = "empPay", nullable = false)
	public float getPay() {
		return pay;
	}
	public void setPay(float pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "You have selected employee Id: " + id + ", Name: " + name +", Occupation: " + role +", Salary: $" + pay + ".";
	}
	
	

}
