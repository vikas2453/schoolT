package com.edu.schoolT.web;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Date;
import java.util.Calendar;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.edu.schoolT.dao.impl.TeacherDao;
import com.edu.schoolT.model.Teacher;

@Controller
public class TeacherController {
	static final Logger logger = Logger.getLogger(TeacherController.class);
	
	@Autowired
	private TeacherDao teacherDao;
	/*@Autowired
	private PasswordEncoder passwordEncoder;*/
	@Autowired
	private Teacher teacher;
	@RequestMapping(value="/FormNewTeacher.htm", method=RequestMethod.GET)
	public String showformNewTeacher(Model model){
		model.addAttribute(teacher);
		return "Teacher/addNewTeacher";
		
	}
	
	@RequestMapping(value="/FormNewTeacher.htm", method=RequestMethod.POST)
	public String addNewTeacher(Teacher teacher, @RequestParam("photo") MultipartFile photo){
	
			//Blob blob = Hibernate.createBlob(photo.getInputStream());
			Blob blob=null;
			teacher.setTeacher_photo(blob);
		
		//decode the password
		teacher.setJoiningDate(new Date(Calendar.getInstance().getTimeInMillis()));
		//teacher.getUser().setPassword(passwordEncoder.encode(teacher.getUser().getPassword()));
		
		teacherDao.save(teacher);
		logger.debug(teacher);
		return "Teacher/candiateThanks";
		
	}
	
	
	
}
