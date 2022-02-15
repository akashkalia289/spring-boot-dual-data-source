package com.springboot.dualdatasource.config;



import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "com.springboot.dualdatasource.repo1",
					entityManagerFactoryRef = "entityManager1",
					transactionManagerRef = "hibernateTransactionManager1"
					)
public class MySQLConfig1 {
	
	public BasicDataSource dataSource1() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/dds");
		dataSource.setUsername("root");
        dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean
	@Primary
    public PlatformTransactionManager hibernateTransactionManager1() {
        JpaTransactionManager transactionManager
          = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager1().getObject());
        return transactionManager;
    }
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManager1() {
		LocalContainerEntityManagerFactoryBean entityManager = new 
				LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataSource1());
		entityManager.setPackagesToScan(
		          "com.springboot.dualdatasource.source1.entity");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManager.setJpaVendorAdapter(vendorAdapter);
		
		entityManager.setJpaProperties(hibernateProperties());
		return entityManager;
	}

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "hibernate.hbm2ddl.auto", "validate");
        hibernateProperties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        return hibernateProperties;
    }

}
