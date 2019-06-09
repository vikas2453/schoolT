package com.edu.schoolT.model;

import java.sql.Blob;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import com.edu.schoolT.login.impl.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@XmlRootElement(name = "student_enrolled")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties({ "user", "student_photo", "standardSeekingAdmission", "parent" })
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int enrollmentNumber;

	@NotEmpty
	@Size(min = 1, max = 30)
	private String name;
	@NotEmpty
	private String gender;

	@Autowired @NotNull
	@ManyToOne( fetch = FetchType.EAGER) // I am not sure if detach is correct
	private School school;

	@NotEmpty
	private String standardSeekingAdmission;
	@Autowired
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "parentId")
	private Parent parent;

	@Autowired
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "userId")
	private User user;
	
	// Status like Enrolled, Admitted, Active, Expelled, Ex etc. 
	private String status;
	private Blob student_photo;
	
	@ManyToOne
	private Kaksha kaksha;

	@OneToMany(mappedBy="student", fetch=FetchType.LAZY, cascade=CascadeType.DETACH)
	private List<StudentAttendance> attendance;

	// Default constructor

	public Student() {
		this.parent = new Parent();
		this.user = new User();

	}

	@Autowired
	public Student(Parent parent, User user) {
		this.parent = parent;
		this.user = user;
	}
	
	public Student(String name, String gender, School school, String standardSeekingAdmission, Parent parent,
			User user, String status, Blob student_photo) {
		super();
		this.name = name;
		this.gender = gender;
		this.school = school;
		this.standardSeekingAdmission = standardSeekingAdmission;
		this.parent = parent;
		this.user = user;
		this.status = status;
		this.student_photo = student_photo;
	}
	
	public Student(String name, String gender, School school, String standardSeekingAdmission, Parent parent,
			User user, String status) {
		super();
		this.name = name;
		this.gender = gender;
		this.school = school;
		this.standardSeekingAdmission = standardSeekingAdmission;
		this.parent = parent;
		this.user = user;
		this.status = status;
	}
	
	public Student(String name, String gender,  String standardSeekingAdmission, Parent parent,
			User user, String status) {
		super();
		this.name = name;
		this.gender = gender;
		this.standardSeekingAdmission = standardSeekingAdmission;
		this.parent = parent;
		this.user = user;
		this.status = status;
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
	
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Kaksha getKaksha() {
		return kaksha;
	}

	public void setKaksha(Kaksha kaksha) {
		this.kaksha = kaksha;
	}

	public List<StudentAttendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<StudentAttendance> attendance) {
		this.attendance = attendance;
	}

	public boolean equals(Object o) {
		if (!(o instanceof Student))
		return false;
		else {
			Student s=(Student)o;
			if(this.enrollmentNumber==s.getEnrollmentNumber() )
				return true;
			else
				return false;			
		}
		
	}

	public String toString() {
		return "name: " + name + " enrollmentNumber: " + enrollmentNumber + " user--> " + user + " parent--> " + parent
				+ " Status--> " + status + " school--> " + school +"standardSeekingAdmission--> " + standardSeekingAdmission;

	}

}