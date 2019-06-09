package com.edu.schoolT.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.schoolT.dao.impl.AttendanceDao;
import com.edu.schoolT.model.Attendance;
import com.edu.schoolT.model.Kaksha;
import com.edu.schoolT.model.Student;
import com.edu.schoolT.model.StudentAttendance;
import com.edu.schoolT.web.AttendenceConroller;
@Service

public class AttendanceServiceImpl implements AttendanceService {
	static final Logger logger = Logger.getLogger(AttendenceConroller.class);	
	@Autowired	AttendanceDao attendanceDao;

	@Override
	public List<Student> getAllAbsent(Kaksha kaksha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean markAttendence(List<Student> studentList) {
		
		// TODO Auto-generated method stub
		Attendance attendance =attendanceDao.findOne(null);
		List<StudentAttendance> kashaAttendence= new ArrayList<StudentAttendance>();
		/*for(AdmittedStudent s: studentList){
			s.getTodayAttendance().setAttendanceId(attendance.getAttendanceId());
			//s.getTodayAttendance().setAdmissionNumber(s.getAdmissionNumber());
			kashaAttendence.add(s.getTodayAttendance());			
			logger.debug(s.getStudent_enrolled().getName()+s.getAdmissionNumber()+" "+"     "+s.getTodayAttendance().getAttendanceId());
			logger.debug(s.getTodayAttendance().getStatus());
		}*/
		attendanceDao.save(kashaAttendence);

		// TODO Auto-generated method stub
		return false;
	}

}
