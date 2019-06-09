package com.edu.schoolT.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class TestResult {
	
	//private StudentTestId studentTestId;
	private int id;
	private int enrollment_number;

	@ManyToOne
	@JoinColumn(name="testId")
	private Test test;
	private int marksObtained;
	private String status;
	private String remarks;
	
	public int getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	/*public void setStudentTestId(StudentTestId studentTestId) {
		this.studentTestId = studentTestId;
	}
	public StudentTestId getStudentTestId() {
		return studentTestId;
	}*/
	
	public String toString(){
		return "testId : "+test.getTestId()+", enrollmentNumber: "+enrollment_number+", marksObtained :"+marksObtained;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public Test getTest() {
		return test;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setEnrollment_number(int enrollment_number) {
		this.enrollment_number = enrollment_number;
	}
	public int getEnrollment_number() {
		return enrollment_number;
	}


}
