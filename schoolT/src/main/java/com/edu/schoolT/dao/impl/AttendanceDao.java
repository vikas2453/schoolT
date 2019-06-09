package com.edu.schoolT.dao.impl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.edu.schoolT.model.Attendance;
import com.edu.schoolT.model.StudentAttendance;


public interface AttendanceDao extends CrudRepository<Attendance, Integer>{
	
	//public Attendance findOne();
	public boolean save(List<StudentAttendance> attendanceList);

}
