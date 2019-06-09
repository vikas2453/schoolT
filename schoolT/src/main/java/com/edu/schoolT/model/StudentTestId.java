package com.edu.schoolT.model;

import java.io.Serializable;

public class StudentTestId implements Serializable{
	
	private int testId;
	private int enrollment_number;
	
	
	public StudentTestId(){
		
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getTestId() {
		return testId;
	}
	public void setEnrollment_number(int enrollment_number) {
		this.enrollment_number = enrollment_number;
	}
	public int getEnrollment_number() {
		return enrollment_number;
	}
	
	@Override
	public boolean equals(Object arg0) {
	if(arg0 == null) return false;
	if(! (arg0 instanceof StudentTestId))return false;
	StudentTestId arg1=(StudentTestId)arg0;
	return (this.testId == arg1.testId && this.enrollment_number == arg1.enrollment_number);
	}
	
	public int hashcode(){
		return (testId+enrollment_number);
	}


}
