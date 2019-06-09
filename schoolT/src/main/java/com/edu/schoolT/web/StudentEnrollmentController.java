package com.edu.schoolT.web;

import java.sql.Blob;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.schoolT.dao.impl.SchoolDao;
import com.edu.schoolT.dao.impl.StudentDao;
import com.edu.schoolT.dao.impl.StudentenrolledDao;
import com.edu.schoolT.login.dao.impl.UserDao;
import com.edu.schoolT.login.impl.Authority;
import com.edu.schoolT.model.School;
import com.edu.schoolT.model.Student;
import com.edu.schoolT.validators.StudentEnrollmentValidator;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Controller
@Data
@Log4j
public class StudentEnrollmentController {



	@Autowired
	private StudentenrolledDao studentEnrolledDao;

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private SchoolDao schoolDao;

	@Autowired
	private UserDao userDao;
	private StudentEnrollmentValidator studentEnrollmentValidator;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	 
	@Autowired
	private Student student;

	
	@RequestMapping(value = "/enrollment.htm", method = RequestMethod.GET)
	public String showValidatinForm(Model model) {
		model.addAttribute(student);
		return "enrollmentForm";
	}

	@RequestMapping(value = "/enrollment.htm", method = RequestMethod.POST)
	// commenting schooldId url as we need to find way to pass schoolid from from. 
	//@RequestMapping(value = "/enrollment.htm/{schoolId}", method = RequestMethod.POST)
	public String enrollStudent(@Valid Student student, BindingResult result, Map<String, Student> model) {
		//,@RequestParam("photo") MultipartFile photo
		//, @RequestParam("schoolId") long schoolId
		log.info("in enrollStudent method ");
		//if (result.hasErrors()||schoolId==0) {
		if (result!=null && result.hasErrors()) {
			log.info("some errors in submitting the form");
			//return "enrollmentForm";
		}

		// get the student's photo

		// Blob blob = Hibernate.createBlob(photo.getInputStream());
		Blob blob = null;
		student.setStudent_photo(blob);
		School school=schoolDao.findById(1);
		if(school!=null)
		student.setSchool(school);

		// decode the password
		student.getUser().setPassword(passwordEncoder.encode(student.getUser().getPassword()));
		// save the enrolled student in the database.
		
		// As the student is getting added, let's give the authority to the parent
				student.getUser().getAuthorityList().add(new
				 Authority("ROLE_parent", student.getUser()));

		log.info(student);
		studentEnrolledDao.save(student);
		// Add the saved validationForm to the model
		model.put("student", student);
		return "EnrollmentSuccess";
	}

	@RequestMapping(value = "/admitStudentHome.htm", method = RequestMethod.GET)

	public String homeAdmitStudent(@RequestParam(value = "enrollmentNumber", required = false) Integer enrollmentNumber,
			Map<String, Student> model) {
		log.debug("/n/n in the homeAdmitStudent method");		
		if (enrollmentNumber != null) {
			student = studentEnrolledDao.findByEnrollmentNumber(enrollmentNumber);
			log.debug(student);
			model.put("student", student);
		} else {
			model.put("student", student);
		}

		return "admit";
	}

	@RequestMapping(value = "/admit.htm", method = RequestMethod.POST)
	@ModelAttribute("student")

	public Student admitStudent(Student student_enrolled) {
		log.debug("/n/n in the admitStudent method");
		// TO set the status of this student as admitted, we need to make it
		// persistence.
		Student db_student_enrolled = studentEnrolledDao.findByEnrollmentNumber(student_enrolled.getEnrollmentNumber());
		db_student_enrolled.setStatus("admitted");

		// As the user is getting added, let's give the authority to the parent
		// db_student_enrolled.getUser().getAuthorityList().add(new
		// Authority("ROLE_parent", db_student_enrolled.getUser().getUsername()));

		log.debug(db_student_enrolled);

		studentDao.save(db_student_enrolled);
		return db_student_enrolled;

	}

	// This method is being used in the ajax call to validate the userid
	@RequestMapping(value = "/validateUserId.htm", method = RequestMethod.GET)
	public @ResponseBody String valdiateUserId(@RequestParam(value = "userId", required = true) String userId) {
		if (userDao.findByUserId(userId)!=null)
			return userId + " userid is already taken";
		else
			return userId + " is ok";

	}

	public StudentEnrollmentController() {

	}

}
