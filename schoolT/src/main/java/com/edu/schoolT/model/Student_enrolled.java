package com.edu.schoolT.model;


import java.sql.Blob;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edu.schoolT.login.impl.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@XmlRootElement(name = "student_enrolled")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties({"user","student_photo","standardSeekingAdmission","parent"})
public class Student_enrolled {

	private int enrollmentNumber;

	@NotEmpty
	@Size(min = 1, max = 30)
	private String name;
	@NotEmpty
	private String gender;

	@NotEmpty
	private String standardSeekingAdmission;
	@Autowired	
	private Parent parent;
	@Autowired
	private User user;
		
	private String status;
	private Blob student_photo;

	// Default constructor
	
	/*public Student_enrolled() {		
		this.parent =new parent();
		this.user=new user();

	}
	
*/
	@Autowired
	public Student_enrolled(Parent parent, User user){
		this.parent = parent;
		this.user=user;
				
	}

	public String getStandardSeekingAdmission() {
		return standardSeekingAdmission;
	}

	public void setStandardSeekingAdmission(String standardSeekingAdmission) {
		this.standardSeekingAdmission = standardSeekingAdmission;
	}

	public Parent getParent() {
		return parent;
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public void setParent(Parent parent) {
		this.parent = parent;
	}



	public void setEnrollmentNumber(int enrollmentNumber) {
		this.enrollmentNumber = enrollmentNumber;
	}

	public int getEnrollmentNumber() {
		return this.enrollmentNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	
	public String getStatus() {
		return status;
	}


	public Blob getStudent_photo() {
		return student_photo;
	}


	public void setStudent_photo(Blob student_photo) {
		this.student_photo = student_photo;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String toString(){
		return "name: "+name+" enrollmentNumber: "+enrollmentNumber;
		
	}

}