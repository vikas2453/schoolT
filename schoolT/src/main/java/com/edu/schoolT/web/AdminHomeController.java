package com.edu.schoolT.web;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.schoolT.model.Teacher;

@Controller
public class AdminHomeController {
	
	@RequestMapping(value = "/adminHome.htm", method = RequestMethod.GET)
	public String homeAdmin(final HttpSession session, Principal principal, Map<String, Teacher> model){
		return "adminHome";
		
	}

}
