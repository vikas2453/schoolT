package com.edu.schoolT.web;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.edu.schoolT.dao.impl.StudentenrolledDao;
import com.edu.schoolT.model.School;
import com.edu.schoolT.model.Student;

public class StudentEnrollmentControllerTest {
	
	@InjectMocks
	StudentEnrollmentController studentEnrollmentController;
	
	@Mock
	private StudentenrolledDao studentEnrolledDao;
	
	@Mock
	private School school;
	
	@Mock
	private Student student;
	
	@Mock
	private BindingResult result;
	
	@Mock
	private Map<String, Student> model;
	
	
	private	MultipartFile photo;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
		
	
	/*@Test
	public  void TestEnrollStudent() {
		
		
		when(result.hasErrors()).thenReturn(false);
		studentEnrollmentController.enrollStudent( student, result, model);
		verify(studentEnrolledDao).save(student);
	}
*/
}
