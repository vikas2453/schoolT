package com.edu.schoolT.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Parent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long parentId;

	@NotEmpty
	@Size(min = 1, max = 30)
	private String fatherName;

	@NotEmpty
	@Size(min = 1, max = 30)
	private String motherName;

	@NotEmpty
	@Size(min = 10, max = 12)
	@NumberFormat
	private String motherContactNumber;

	@NotEmpty
	@Size(min = 10, max = 12)
	@NumberFormat
	private String fatherContactNumber;

	public Parent() {
		// default constructor
	}
	
	public Parent(String fatherName, String motherName, String motherContactNumber, String fatherContactNumber) {
		super();
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.motherContactNumber = motherContactNumber;
		this.fatherContactNumber = fatherContactNumber;
	}


	/*
	 * public AdmittedStudent getStudent() { return student; }
	 * 
	 * public void setStudent(AdmittedStudent student) { this.student = student; }
	 */

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherContactNumber() {
		return motherContactNumber;
	}

	public void setMotherContactNumber(String motherContactNumber) {
		this.motherContactNumber = motherContactNumber;
	}

	public String getFatherContactNumber() {
		return fatherContactNumber;
	}

	public void setFatherContactNumber(String fatherContactNumber) {
		this.fatherContactNumber = fatherContactNumber;
	}

	public String toString() {
		return "fatherName" + fatherName + "\tfatherContactNumber" + fatherContactNumber + "\tmotherName" + motherName
				+ "\tmotherContactNumber" + motherContactNumber;
	}

}
