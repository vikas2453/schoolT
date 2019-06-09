package com.edu.schoolT.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;



@Component
public class StudentListForm {
	
	static int numberofCurrentInstances;
	static final Logger logger = Logger.getLogger(StudentListForm.class);
	private List<Student> studentList=new ArrayList<Student>();

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Student> getStudentList() {
		return studentList;
	}
	
	public StudentListForm(){
		logger.debug("numberofCurrentInstances  "+numberofCurrentInstances++);
	}
	
	

}
