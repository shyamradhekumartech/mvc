package com.example.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IPersonDao;
import com.example.model.Person;
import com.example.service.IPersonService;

/**
 * This is Service Layer where, 
 * we can do business logic and transaction management
 * @author user
 * @since 20 JAN 2020
 */
@Service
public class PersonServiceImpl implements IPersonService {

	private static final Logger logger = LogManager.getLogger(PersonServiceImpl.class);
	
	@Autowired
	private IPersonDao personDao;
	
	@Override
	public String createPerson(Person person) {
		logger.info("< PersonServiceImpl started > at " + LocalDateTime.now().toString() + " with Person Data: " + person);
		String message = personDao.createPerson(person);
		if(message != null)
			logger.info("< PersonServiceImpl compeleted > at " + LocalDateTime.now().toString());
		return message;
	}

	@Override
	public String updatePerson(Person person) {
		return null;
	}

	@Override
	public Person getPersonById(Integer id) {
		return null;
	}

	@Override
	public List<Person> getAllPersons() {
		logger.info("< PersonServiceImpl started > with getAllPersons() method, at " + LocalDateTime.now().toString());
		List<Person> persons = personDao.getAllPersons();
		logger.info("< PersonServiceImpl completed > with getAllPersons() method, at " + LocalDateTime.now().toString() + " data: " + persons);
		if(persons != null)
			return persons;
		return null;
	}

}
