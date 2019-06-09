package com.edu.schoolT.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;
@Component
@Entity
@XmlRootElement(name = "Kaksha")
@XmlAccessorType(XmlAccessType.FIELD)
public class Kaksha {
	@Id
	private int id;
	@OneToOne
	@JoinColumn(name="standardId")
	private Standard standard;
	private char section;
	private String location;	
	private String[] subject;
	@OneToMany
	@JoinColumn(name="studentId")
	private List<Student> students;	
	@OneToOne
	@JoinColumn(name="teacherId")
	private Teacher classTeacher;
	//private schedule with each subject, teacher
	
	
	public Kaksha(){
		
	}
	
	public String[] getSubject() {
		return subject;
	}

	public void setSubject(String[] subject) {
		this.subject = subject;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Teacher getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(Teacher classTeacher) {
		this.classTeacher = classTeacher;
	}

	
	public Standard getStandard() {
		return standard;
	}
	public void setStandard(Standard standard) {
		this.standard = standard;
	}
	public char getSection() {
		return section;
	}
	public void setSection(char section) {
		this.section = section;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	
	

}
