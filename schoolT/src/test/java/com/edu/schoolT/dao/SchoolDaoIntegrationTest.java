package com.edu.schoolT.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.schoolT.dao.impl.SchoolDao;
import com.edu.schoolT.dao.impl.StudentenrolledDao;
import com.edu.schoolT.model.Address;
import com.edu.schoolT.model.Parent;
import com.edu.schoolT.model.School;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SchoolDaoIntegrationTest {
	
	@Autowired
	private SchoolDao schoolDao;
	
	@Test
	public void testSave() {
		Address address =new Address("120", "420", "Mandir wali Gali", 
				"2A", "Shamli", "UttarPradesh","India", "247776");
		
		School school=new School("SDRR", address);
		schoolDao.save(school);
	}

}
