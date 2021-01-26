package com.example.dao;

import java.util.List;

import com.example.model.Person;

/**
 * 
 * @author SANDEEP RAWAT
 * @version 1.0
 * @since 20 JAN 2021
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
