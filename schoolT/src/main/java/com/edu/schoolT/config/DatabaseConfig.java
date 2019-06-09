package com.edu.schoolT.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
	
		
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource createDataSource() {
		DataSource dataSource =DataSourceBuilder.create().build();		
		return dataSource;		
	}
	

}
