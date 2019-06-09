package com.edu.schoolT.config;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	public void addViewControllers(ViewControllerRegistry registry) {
		// this is to map a view to URL without any controller
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/enrollmentForm").setViewName("enrollmentForm");
	}
	
	 @Bean
	    public InternalResourceViewResolver viewResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/Representation/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	    }
	
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
	    return hemf.getSessionFactory();
	}

}
