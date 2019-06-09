package com.edu.schoolT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

/**
 * Hello world!
 *
 */
@SpringBootApplication
// Import resource can be used to fetch dependencies defined through XML in Spring boot
//@ImportResource("dispatcher-servlet.xml" )
public class SchoolWeb extends SpringBootServletInitializer
{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
		return app.sources(SchoolWeb.class);
	}
	
	
    public static void main( String[] args )
    {
        SpringApplication.run(SchoolWeb.class, args);
    }
}
