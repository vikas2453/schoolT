package com.edu.schoolT.web;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.schoolT.dao.impl.KakshaDao;
import com.edu.schoolT.model.Student;
import com.edu.schoolT.model.Teacher;

@Controller
public class KakshaController {
	
	static final Logger logger = Logger.getLogger(KakshaController.class);
	@Autowired
	KakshaDao KakshaDao;
	
	@RequestMapping(value = "/KakshaDetails.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> getKakshaStudents(HttpSession session,Principal principal){
		logger.debug("getKakshaStudents is called");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		if(teacher !=null){
			List<Student> StudentList = null;
					//KakshaDao.students(teacher.getKaksha());
			logger.debug("StudentList: "+StudentList);
			return StudentList;			
		}
		return null;
		
	}
	
	/*@RequestMapping(value = "/attendence.htm", method = RequestMethod.GET)
	
	public String getKakshaStudents(HttpSession session, Map<String,StudentAttendance> studentAttendence){
		Kaksha sa=new Kaksha();
		logger.debug("getKakshaStudents is called");
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		if(teacher !=null){
			Set<AdmittedStudent> StudentList = KakshaDao.getKakshaStudents(teacher.getKaksha());
			logger.debug("StudentList: "+StudentList);
			sa.setAllKakshaStudent(StudentList);
			studentAttendence.put("studentAttendence", sa);
			return "Teacher/Attendance";
		}
		return null;
		
	}
	*/
/*@RequestMapping(value = "/attendence.htm", method = RequestMethod.POST)
	
	public String getKakshaStudentsAttendence(StudentAttendance studentAttendence){
	for(int s: studentAttendence.getAbsentStudent()){
		logger.debug("stundet absent is "+s);
	}
		return "Teacher/tHome";
		
		
	}
*/	
	

}
