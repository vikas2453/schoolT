package com.edu.schoolT.dao.impl;
import org.springframework.data.repository.CrudRepository;

import com.edu.schoolT.login.impl.User;
import com.edu.schoolT.model.Student;

public interface StudentenrolledDao extends CrudRepository<Student, Integer>{
	public Student save(Student s);
	
	public Student findByEnrollmentNumber(int enrollmenNumber);
	//public Student getStudentWithUser(int enrollmenNumber);
	//public Set<TestResult>getTestResults(AdmittedStudent student);
	
	public Student findByUser(User user);
	
	//boolean save(Student Student);
	//for making a new entry in the student table.

	//public boolean seatCheck(int std);

}
