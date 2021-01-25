package com.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.IPersonDao;
import com.example.dbconfig.DBConfig;
import com.example.model.Person;

@Repository
public class PersonDaoImpl implements IPersonDao {

	private static final Logger logger = LogManager.getLogger(PersonDaoImpl.class);

	@Autowired
	private DBConfig dbConfig;

	@Override
	public String createPerson(Person person) {
		LocalDateTime dateTime = LocalDateTime.now();
		logger.info("< PersonDaoImpl started > at Date and Time: " + dateTime.toString());
		String message = "failed";
		try(Connection conn = dbConfig.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?)");
			pstmt.setInt(1, person.getId());
			pstmt.setString(2, person.getName());
			
			ResultSet resultSet = pstmt.getResultSet(); 
			
			if(person.getId() == resultSet.getInt(1)) 
				return message = "person is already there"; 
			else {
				if(pstmt.execute()) 
					return message = "inserted";
			}
			
			LocalDateTime dateTimeAfterCompeletion = LocalDateTime.now();
			logger.info("< PersonDaoImpl Completed > at Date and Time: " + dateTimeAfterCompeletion.toString());
		} catch (SQLException e) {
			logger.error("< PersonDaoImpl Failed (Problem in DB) > " + e.getMessage());
		}
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
		return null;
	}

}