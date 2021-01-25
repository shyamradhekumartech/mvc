package com.example.model;

/*@Entity
@Table(name="person_table")*/
public class Person {
	
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy=GenerationType.AUTO)
	 */
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
