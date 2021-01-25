package com.example.dbconfig;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {
	
	private static final Logger logger = LogManager.getLogger(DBConfig.class);
	
	@Value("${database.driver}")
	private String driver;
	@Value("${database.url}")
	private String url;
	@Value("${database.username}")
	private String username;
	@Value("${database.password}")
	private String password;
	
	@Bean
	public DataSource getDataSource() {
		logger.debug("< Database Configuring... >");
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName(driver);
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(username);
		dataSourceBuilder.password(password);
		logger.info("< Database Configuration Done >");
		return dataSourceBuilder.build();
	}
	
	@Bean
	public Connection getConnection() {
		Connection con = null;
		logger.debug("< Getting Database Connection... >");
		try {
				con = this.getDataSource().getConnection();
				logger.info("< Database Connection Done... >");
		} catch (SQLException e) {
			logger.error("< Database Connection Failed >");
		}
		return con;
	}
}
