package com.edu.schoolT.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;
@Component
@Entity
public class StudentAttendance implements Serializable {
	
	
	@Id
	private int studentAttendanceId;
	private String status="present";
	// Below lines are required for hibernate to define the mapping between AdmittedStudent and attendencce
	// so in one to many mapping side many side needs to have join cloum
	// for onetoone it is easy, which ever table we want the column, we can define the joincolum we can define on that class. 
	// for manytoone, joincolumn can be defined on either side but column will be created on entity having 'many' relationship. 
	@ManyToOne
	@JoinColumn(name="studentId")
	private Student student;
	
/*	@ManyToOne
	@JoinColumn(name="studentId")
	private AdmittedStudent student;
	*/
	public int getAttendanceId() {
		return studentAttendanceId;
	}
	public void setAttendanceId(int attendanceId) {
		this.studentAttendanceId = attendanceId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}




	/*public int hashCode(){
		return studentAttendanceId;		
	}
	
	
	public boolean equals(Object o){
		if(o ==this){
			return true;
		}
		else if(o instanceof StudentAttendance){
			if(((StudentAttendance) o).admissionNumber==this.admissionNumber && ((StudentAttendance) o).studentAttendanceId==this.studentAttendanceId){
				return true;
			}
			else return false;
		}
	else 
		return false;
	}*/
}
