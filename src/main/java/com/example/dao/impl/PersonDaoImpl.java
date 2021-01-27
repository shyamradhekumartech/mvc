package com.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		logger.info("< PersonDaoImpl started > at " + LocalDateTime.now().toString());
		String message = "failed";
		try(Connection conn = dbConfig.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?)");
			pstmt.setInt(1, person.getId());
			pstmt.setString(2, person.getName());

			if(pstmt.execute()) {
				logger.info("< PersonDaoImpl Completed > at " + LocalDateTime.now().toString());
				return message = "inserted";
			}
			else {
				logger.info("< PersonDaoImpl Failed > at " + LocalDateTime.now().toString());
				return message = "person is already there"; 
			}
			
		} catch (SQLException e) {
			logger.error("< PersonDaoImpl Failed (Problem in DB) > with " + e.getMessage() + " at " + LocalDateTime.now().toString());
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
