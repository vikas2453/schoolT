package com.edu.schoolT.dao.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.schoolT.model.Kaksha;
import com.edu.schoolT.model.Student;

public interface KakshaDao extends JpaRepository<Kaksha, Integer> {
	public List<Student> students(Kaksha kaksha);

}
