package com.onesolvent.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.onesolvent")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {
	
	@Autowired
	Environment env;
	
	@Bean
	public ViewResolver viewResolver(){
		
		InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("WEB-INF/view/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	@Bean
	public DataSource dataSource(){
		
		ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
		try {
			comboPooledDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		comboPooledDataSource.setUser(env.getProperty("jdbc.user"));
		comboPooledDataSource.setPassword(env.getProperty("jdbc.password"));
		comboPooledDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		comboPooledDataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
		comboPooledDataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));	
		comboPooledDataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));	
		comboPooledDataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));	
		return comboPooledDataSource;
	}

}
