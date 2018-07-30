package com.rentaladda.rent.config;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@PropertySource(value = {"classpath*:application.properties"})
public class DBRepositoryTest {

	@Autowired
	private Environment environment;
	
	
	@Before
	public void getMySQLDataSource(){
/*		
		DriverManagerDataSource myDS = new DriverManagerDataSource();
		myDS.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		myDS.setUrl("jdbc.url");
		myDS.setUsername("jdbc.username");
		myDS.setPassword("jdbc.password");*/
	}
	
	@Bean
	public JdbcTemplate mySQLJdbcTemplate(DataSource getMySQLDataSource){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getMySQLDataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
	}
	
	@Test
	public void testIfRepoIsEmpty() {
		
	}
}

