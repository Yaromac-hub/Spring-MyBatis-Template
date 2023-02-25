package com.yaromac.mybatistemplate.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.yaromac.mybatistemplate.model")
public class MapperConfig {
	
	@Bean
	public SqlSessionFactory sessionFactory(@Qualifier("DataSource") DataSource dataSource) throws Exception  {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
	    factoryBean.setDataSource(dataSource);
	    return factoryBean.getObject();
	}

}
