package com.edu.schoolT;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.edu.schoolT.web.HomeController;

/**
 * Unit test for simple App.
 */


public class AppTest {
	
	@Autowired
	HomeController homeController;
	
	@Test
    public void testApp() {
    	HomeController homeController=new HomeController();
    	
        assertEquals( "SchoolT home", homeController.blank() );
    }
}
