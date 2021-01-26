package com.example.model;

/**
 * <p>
 * 	It is an Person Object is used as persisting object
 * in database and retrieve the object from database
 * </p>
 * <p>
 * 	It has two fields like id and name
 * </p>
 * 
 * @since 20 JAN 2021
 * @author user
 * @version 1.0
 */
public class Person {
	
	private int id;
	private String name;

	public Person() {
		super();
	}
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
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
	@Override
	public String toString() {
		return String.format("Person [id=%s, name=%s]", id, name);
	}

}
