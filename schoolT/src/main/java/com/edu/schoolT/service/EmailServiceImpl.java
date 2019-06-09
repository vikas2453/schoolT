package com.edu.schoolT.service;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.BindingResult;

import com.edu.schoolT.model.Student;

public class EmailServiceImpl {
	
	private JavaMailSender javaMailSender;
	static final Logger logger = Logger.getLogger(EmailServiceImpl.class);
	
	public void sendRegistrationMail(Student student, BindingResult result, Map<String, Student> model) {
		
		logger.debug("sending email for "+student); 
		//sending email, for this funtionality just uncomment the code.
		SimpleMailMessage message = new SimpleMailMessage();
		
 
		message.setFrom("Sanvalley");
		message.setTo(student.getUser().getEmailaddress());
		message.setSubject("You have been selected");
		message.setText("you will be proud one day");
		
		
		javaMailSender.send(message);
		
		logger.debug("emails sent "+student);
	}

}
