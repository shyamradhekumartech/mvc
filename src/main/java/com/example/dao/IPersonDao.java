package com.example.dao;

import java.util.List;

import com.example.model.Person;

/**
 * This is Data Access Layer Interface,
 * where we can perform select and non-select operation
 * @author SANDEEP RAWAT
 * @version 1.0
 * @since 20 JAN 2020
 */
public interface IPersonDao {

	/**
	 * This method takes a Person object as JSON format and persist in database
	 * @param person an object parameter passing
	 * @return returns String type
	 */
	public String createPerson(Person person);
	public String updatePerson(Person person);
	public Person getPersonById(Integer id);
	public List<Person> getAllPersons();
	
}
