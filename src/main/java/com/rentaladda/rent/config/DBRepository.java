package com.rentaladda.rent.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@PropertySource(value = {"classpath:application.properties"})
public class DBRepository {

	@Autowired
	private Environment environment;
	
	public DBRepository(){
		//Empty constructor
	}
	
	@Bean
	public DataSource getMySQLDataSource(){
		
		DriverManagerDataSource myDS = new DriverManagerDataSource();
		myDS.setDriverClassName(environment.getRequiredProperty("jdbc.mysql.driverClassName"));
		myDS.setUrl("jdbc.mysql.url");
		myDS.setUsername("jdbc.mysql.username");
		myDS.setPassword("jdbc.mysql.password");
		return myDS;
	}
	
	@Bean
	public JdbcTemplate mySQLJdbcTemplate(DataSource getMySQLDataSource){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getMySQLDataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
	}
}

