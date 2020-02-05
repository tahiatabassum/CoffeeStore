
package com.cs.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "Coffee") //Created table and named it in SQL

public class Coffee {

	// Next we will create POJO ( Plain OLD Java Objects)
	// Class Objects 
	
	private long id;
	private String name;
	private float cost;
	private String discription;
	
	public Coffee() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param name
	 * @param cost
	 * @param discription
	 */
	
	// We will create Constructors, Getters and Setters 
	
	public Coffee(long id, String name, float cost, String discription) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.discription = discription;
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column (name = "Name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column (name = "Cost", nullable = false)
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	@Column (name = "Discription", nullable = false)
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " The Coffee that you selected: ID: " + id + ", Name: " + name + ", Cost: $" + cost + ", Discription: " + discription + ".";
	}
	

	

}
