package com.edu.schoolT.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.edu.schoolT.model.School;

@Component
public class SchoolValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return (arg0.equals(School.class));
	}

	@Override
	public void validate(Object command, Errors errors) {
		//AdmittedStudent student =(AdmittedStudent)command;
		ValidationUtils.rejectIfEmpty(errors, "name", "name is a required field");
		
	}
}
