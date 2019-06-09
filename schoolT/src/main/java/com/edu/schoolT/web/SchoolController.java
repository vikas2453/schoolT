package com.edu.schoolT.web;

import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.schoolT.dao.impl.SchoolDao;
import com.edu.schoolT.login.dao.impl.UserDao;
import com.edu.schoolT.model.School;
import com.edu.schoolT.validators.SchoolValidator;

@Controller
public class SchoolController {
	
	static final Logger logger = Logger.getLogger(SchoolController.class);
	
	//@Autowired
	private SchoolDao schoolDao;
	
	//@Autowired
	private SchoolValidator schoolValidator;
	// I get rid of autowired by providing a constructor
	//@Autowired
	private School school;
	
	public SchoolController(School school, SchoolValidator schoolValidator, SchoolDao schoolDao) {
		this.school=school;
		this.schoolValidator=schoolValidator;
		this.schoolDao=schoolDao;
	}
	
	
	@RequestMapping(value = "/schoolReg.htm", method = RequestMethod.GET)
	public String showValidatinForm(Model model) {
		model.addAttribute(school);
		return "schoolAdmin/addSchool";
	}
	
	@RequestMapping(value = "/schoolReg.htm", method = RequestMethod.POST)
	public String addSchool(@Valid School school, BindingResult result, Map<String, School> model) {
		
		if (result.hasErrors()) {
			logger.debug("some errors in submitting the form");
			return "enrollmentForm";
		}
		schoolDao.save(school);
		model.put("school", school);
		return "schoolAdmin/addSchoolSucess";		
	}
	
	public SchoolDao getSchoolDao() {
		return schoolDao;
	}

	public void setSchoolDao(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}

	
	public SchoolValidator getSchoolValidator() {
		return schoolValidator;
	}

	public void setSchoolValidator(SchoolValidator schoolValidator) {
		schoolValidator = schoolValidator;
	}



}
