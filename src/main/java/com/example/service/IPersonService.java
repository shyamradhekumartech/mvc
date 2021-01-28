package com.example.service;

import java.util.List;

import com.example.model.Person;

/**
 * This is Service Layer Interface
 * where we can do business logic and transaction management
 * @author user
 * @since 20 JAN 2020
 */
public interface IPersonService {

	public String createPerson(Person person);
	public String updatePerson(Person person);
	public Person getPersonById(Integer id);
	public List<Person> getAllPersons();
	
}
