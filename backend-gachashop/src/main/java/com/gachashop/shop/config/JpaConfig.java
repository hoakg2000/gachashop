//package com.gachashop.shop.config;
//
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//
//@Configuration
//public class JpaConfig {
//
//    @Autowired
//    private Environment env;
//
//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        factory.setPackagesToScan("gachashop.shop.model");
////        factory.setDataSource(dataSource());
//        factory.afterPropertiesSet();
//
//        return factory.getObject();
//    }
//
////    @Bean
////    public DataSource dataSource() {
////        DriverManagerDataSource d = new DriverManagerDataSource();
////        d.setDriverClassName(env.getProperty("hibernate.connection.driverClass"));
////        d.setUrl(env.getProperty("hibernate.connection.url"));
////        d.setUsername(env.getProperty("hibernate.connection.username"));
////        d.setPassword(env.getProperty("hibernate.connection.password"));
////
////        return d;
////    }
//
//
//}
//
