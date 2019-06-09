package com.edu.schoolT.web;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.edu.schoolT.login.impl.User;
import com.edu.schoolT.model.Address;
import com.edu.schoolT.model.Parent;
import com.edu.schoolT.model.School;
import com.edu.schoolT.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentEnrollmentControllerIntegrationTest {
	
	@Autowired
	private StudentEnrollmentController studentEnrollmentController;

	@Test
	public  void TestEnrollStudent() {
		
	
		Address address =new Address("120", "420", "Mandir wali Gali", 
				"2A", "Shamli", "UttarPradesh","India", "247776");
		Parent parent= new Parent("Rishipal", "Kamal", "9759760830", "79534598345");
		User user=new User("userid"+LocalDateTime.now(), "password", address);
		School school=new School();
		
		Student student=new Student("Vikas", "Male", school, "10", parent,
				 user, "enrolled");
		
		
		student.getUser().setAddress(address);
		
		
		BindingResult result= null;
		
	 Map<String, Student> model= new HashMap<String,Student >();
		
			MultipartFile photo=null;
		
		
		
		//when(result.hasErrors()).thenReturn(false);
		studentEnrollmentController.enrollStudent(student, result, model);
		
	}
}
