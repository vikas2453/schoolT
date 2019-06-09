package com.edu.schoolT.login.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.schoolT.login.impl.User;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserDetailsServiceTest {
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	@Test
	public void testLoadUserByUsername() {
		User user =(User)userDetailsService.loadUserByUsername("a");
		assertNotNull(user);
		log.info("User: "+user);	
		
	}
	
	@Test
	public void testUserIdTaken() {
		assertTrue(userDetailsService.userIdTaken("a"));
		
	}

}
