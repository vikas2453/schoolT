package com.edu.schoolT.dao.impl;

import org.springframework.data.repository.CrudRepository;

import com.edu.schoolT.login.impl.User;
import com.edu.schoolT.model.Teacher;

public interface TeacherDao extends CrudRepository<Teacher, Integer>{
	public Teacher findByUser(User user);
	public Teacher findByTeacherId(int teacherId);
	public Teacher save(Teacher teacher);
	
	public void delete(Teacher teacher);

}
