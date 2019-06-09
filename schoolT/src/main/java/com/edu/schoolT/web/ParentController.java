package com.edu.schoolT.web;

import java.security.Principal;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.schoolT.dao.impl.StudentenrolledDao;
import com.edu.schoolT.login.impl.User;
import com.edu.schoolT.model.Student;
import com.edu.schoolT.model.TestResult;

@Controller
public class ParentController {
	
	static final Logger logger = Logger.getLogger(StudentEnrollmentController.class);
	
	@Autowired
	StudentenrolledDao studentDao;
	
	@RequestMapping(value="/parentHome.htm", method=RequestMethod.GET)
	public String homeParent(final HttpSession session, Principal principal, Map<String, Student> model){
		User user=null;
		if((session).getAttribute("student")==null){
			
			Student s =	studentDao.findByUser(user);			
			if(s!=null){
				//s.getStudent_enrolled().setUser(user);
				//Set<TestResult> testResult = s.getTestResults();				
				session.setAttribute("student", s);
				model.put("student", s);					
			}
		}
		else{
			model.put("student", (Student)session.getAttribute("student"));
		}
		
		logger.debug(principal.getName());
		return "parentHome";
		
	}
	
	
	@RequestMapping(value = "/fetchTestResults.htm", method = RequestMethod.GET)
	@ResponseBody	
	public Set<TestResult> fetchTestResults(final HttpSession session, HttpServletResponse response, Principal principal){	
		logger.debug("fetchTestResults called");
		//AdmittedStudent s =(AdmittedStudent)session.getAttribute("student");
		
		response.setContentType("Application/JSON");
		//AdmittedStudent s =	studentDao.findByUser(principal.getName());	
		//TO-DO
		//Student s =	studentDao.findByUser(new User());
		Set<TestResult> testResult = null;
				
				//s.getTestResults();
		if(testResult!=null){
			for(TestResult t:testResult){
				logger.debug(t);					
			}
		}
		
		return testResult;		 
	}



}
