package com.yaromac.mybatistemplate.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties (prefix="spring.datasource")
@EnableTransactionManagement
public class DataSourceConfig {
	
	private String jdbcUrl;
	private String username;
	private String password;
	private String driverClassName;
	private int maxActive;
	private int minIdle;
	
	 @Bean (name="DataSource")
	 public DataSource dataSource () {
		 HikariConfig config = new HikariConfig();
	     config.setJdbcUrl(jdbcUrl);
	     config.setDriverClassName(driverClassName);
	     config.setUsername(username);
	     config.setPassword(password);
	     config.setMinimumIdle(minIdle);
	     config.setMaximumPoolSize(maxActive);
	     config.setConnectionTimeout(1500);
	     config.setAutoCommit(false);
	     return new HikariDataSource(config);
	 }
	  
	 @Bean(name = "TransactionManager")
	 public DataSourceTransactionManager transactionManager(@Qualifier("DataSource") DataSource dataSource) {
	    return new DataSourceTransactionManager(dataSource);
	 }

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public int getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}
	 
}
