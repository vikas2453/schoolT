package com.edu.schoolT.web;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.schoolT.dao.impl.TeacherDao;
import com.edu.schoolT.login.impl.User;
import com.edu.schoolT.model.Teacher;


@Controller
public class TeacherHomeController {
	static final Logger logger = Logger.getLogger(TeacherHomeController.class);
	@Autowired
	TeacherDao teacherDao;
	
	@RequestMapping(value="/teacherHome.htm", method=RequestMethod.GET)
	public String homeTeacher(final HttpSession session, Principal principal, Map<String, Teacher> model){
		User user=null;
		Teacher t =null;
		if((session).getAttribute("teacher")==null){
			
					
			        t =	teacherDao.findByUser(user);
			     
			
			
			if(t!=null){
				//t.setUser(user);
				//other customization related to that teacher.
				session.setAttribute("teacher", t);
				model.put("teacher", t);					
			}
		}
		else{
			model.put("teacher", (Teacher)session.getAttribute("teacher"));
		}
		

		return "Teacher/tHome";
		
	}


}
