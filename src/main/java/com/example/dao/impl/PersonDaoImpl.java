package com.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.IPersonDao;
import com.example.dbconfig.DBConfig;
import com.example.model.Person;

/**
 * This is Data Access Layer Implementation
 * we can perform select and non-select operation
 * @author user
 * @since 20 JAN 2020
 */
@Repository
public class PersonDaoImpl implements IPersonDao {

	private static final Logger logger = LogManager.getLogger(PersonDaoImpl.class);

	@Autowired
	private DBConfig dbConfig;

	@Override
	public String createPerson(Person person) {
		logger.info("< PersonDaoImpl started > at " + LocalDateTime.now().toString());
		String message;
		try(Connection conn = dbConfig.getDataSource().getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?)");
			pstmt.setInt(1, person.getId());
			pstmt.setString(2, person.getName());
			
			pstmt.execute();
			message = "Inserted";
			logger.info("< PersonDaoImpl completed > at " + LocalDateTime.now().toString()
					+ " with Person Data: " + person.toString());	
			
		} catch (SQLException e) {
			logger.error("< PersonDaoImpl Failed (Problem in DB) > with " + e.getMessage() + " at " + LocalDateTime.now().toString());
			message = e.getMessage();
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
		logger.info("< PersonDaoImpl started > with getAllPersons() method, at " + LocalDateTime.now().toString());

		List<Person> persons = new ArrayList<>(0);
		try(Connection conn = dbConfig.getDataSource().getConnection()) {
			try {
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM EMPLOYEE");
				pstmt.execute();
				ResultSet rs = pstmt.getResultSet();
				while(rs.next()) {
					persons.add(new Person(rs.getInt(1), rs.getString(2)));
				}
			} catch (SQLException e) {
				logger.error("< PersonDaoImpl > Failed from fetching due to empty");
			}
		} catch (SQLException e) {
			logger.error("<PersonDaoImpl > Failed due to DB Connection");
		}
		logger.info("< PersonDaoImpl completed > with getAllPersons() method, at " + LocalDateTime.now().toString() + " data: " + persons);

		return persons;
	}

}
