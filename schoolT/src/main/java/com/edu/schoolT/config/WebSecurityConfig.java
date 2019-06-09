package com.edu.schoolT.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.edu.schoolT.login.dao.impl.UserDetailsServiceImpl;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig  {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().antMatchers("/","/home").permitAll()
		.antMatchers("/enrollment.htm").permitAll()
		.antMatchers("/adminHome/**").hasAnyRole("ROLE_admin")
		.antMatchers("/css/**", "/index").permitAll()	
		.antMatchers("/parentHome/**", "/parent/*", "/query.htm*").hasAnyRole("ROLE_parent")
		// add any pattern as string and role her
		.antMatchers("/teacher/*", "/teacherHome/*" ).hasAnyRole("ROLE_teacher")
		.antMatchers("/fetchQueryDetails.htm").fullyAuthenticated()
		.and().formLogin().successForwardUrl("/roleHome.htm").failureForwardUrl("/loginfailed.htm")
		.and().formLogin().loginPage("/login").permitAll()
		.and().logout().logoutSuccessUrl("/login");
	}
	
	//@Override
	protected void configure(AuthenticationManagerBuilder auth)
	  throws Exception {
	    auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder(11);
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		// Spring boot will detect the class implementing userDetails and will set it automatically, no need for the below line
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}
	
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	    }
	


}
