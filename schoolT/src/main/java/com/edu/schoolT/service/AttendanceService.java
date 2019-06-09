package com.edu.schoolT.service;

import java.util.List;

import com.edu.schoolT.model.Kaksha;
import com.edu.schoolT.model.Student;


public interface AttendanceService {
	 List<Student> getAllAbsent(Kaksha kaksha);
	 boolean markAttendence(List<Student> studentList);
	 

}
