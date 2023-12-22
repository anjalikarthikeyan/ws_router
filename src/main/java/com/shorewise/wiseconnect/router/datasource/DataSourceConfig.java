package com.shorewise.wiseconnect.router.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres"); // Updated as per your properties
        dataSource.setUsername("postgres"); // Updated as per your properties
        dataSource.setPassword("admin"); // Updated as per your properties
        return dataSource;
    }
    
	/*
	 * @Bean(name = "dataSource") public DataSource dataSource() {
	 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 * dataSource.setDriverClassName("org.postgresql.Driver"); dataSource.setUrl(
	 * "jdbc:postgresql://database-18.cgogv0s5ltc7.ap-northeast-1.rds.amazonaws.com:5432/wiseconnectdb"
	 * ); // Updated as per your properties dataSource.setUsername("postgres"); //
	 * Updated as per your properties dataSource.setPassword("password"); // Updated
	 * as per your properties return dataSource; }
	 */
}