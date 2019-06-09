package com.edu.schoolT.dao;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.hibernate.type.descriptor.java.CalendarDateTypeDescriptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.schoolT.dao.impl.SchoolDao;
import com.edu.schoolT.dao.impl.StudentenrolledDao;
import com.edu.schoolT.login.impl.User;
import com.edu.schoolT.model.Address;
import com.edu.schoolT.model.Parent;
import com.edu.schoolT.model.School;
import com.edu.schoolT.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentEnrolledDaoIntegrationTest {
	
	private static final Logger log= Logger.getLogger(StudentEnrolledDaoIntegrationTest.class);

	@Autowired
	private StudentenrolledDao studentenrolledDao;
	@Autowired
	private SchoolDao schoolDao;
	Student student;

	@Test
	public void testSave() {
		Address address = new Address("120", "420", "Mandir wali Gali", "2A", "Shamli", "UttarPradesh", "India",
				"247776");
		Parent parent = new Parent("Rishipal", "Kamal", "9759760830", "79534598345");
		User user = new User("userid"+LocalDateTime.now(), "password", address);
		School school = schoolDao.findById(1);
		
		if(school==null) {
			Address schoolAddress = new Address("120", "420", "Mandir wali Gali", "2A", "Shamli", "UttarPradesh", "India",
					"247776");
			 school=new School("SDRR", schoolAddress);
			 school.setCreatedDate(Calendar.getInstance().getTime());
			schoolDao.save(school);
		}
		
	
		
		student = new Student("Vikas", "Male", school, "10", parent, user, "enrolled");
		

		student.getUser().setAddress(address);
		log.info("saving  student " +student);
		studentenrolledDao.save(student);
		Student student2=studentenrolledDao.findByEnrollmentNumber(student.getEnrollmentNumber());
		log.info("Retrieved AdmittedStudent is" +student2);
		assertThat(student2.equals(student));
		assertTrue(student2.getUser().getAuthorityList()!=null);
		assertThat(!student2.getUser().getAuthorityList().isEmpty());
		
		

	}
	
	/*@Test
	public void testFindByEnrollmentNumber() {
		Student student2=studentenrolledDao.findByEnrollmentNumber(student.getEnrollmentNumber());
		log.info("Retrieved AdmittedStudent is" +student2);
		assertThat(student2.equals(student));
		
		
	}*/

}
