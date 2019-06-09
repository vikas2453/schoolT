package com.edu.schoolT.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.schoolT.login.impl.User;
import com.edu.schoolT.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {
	public Student save(Student s);
	public Student findByEnrollmentNumber(Integer i);
	public Student findByUser(User user);

}
