package com.example.dao;

import java.util.List;

import com.example.model.Person;

public interface IPersonDao {

	public String createPerson(Person person);
	public String updatePerson(Person person);
	public Person getPersonById(Integer id);
	public List<Person> getAllPersons();
	
}
