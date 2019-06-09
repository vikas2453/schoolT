package com.edu.schoolT.model;

import java.sql.Blob;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edu.schoolT.login.impl.User;

@Entity
@Component
public class Teacher {
	@Id
	private int teacherId;
	private String name;
	@Autowired
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	private String primarySubject;
	private String secondaySubject;
	private String highestQualification;

	private Blob teacher_photo;
	private Date joiningDate;
	private Date lastDate;
	private int monthsOfExperience;
	private String contactNumber;
	private String gender;
//	private Set<Query>queries;

	// private TimeTable currentTimeTable;
	// private Complains[] parentsComplain;
	// private Appreciation[] parentAppreciation;
	// private Remarks[] parentRemarks;
	// something to check all previous results related to teacher

	/*public Set<Query> getQueries() {
		return queries;
	}

	public void setQueries(Set<Query> queries) {
		this.queries = queries;
	}*/

	public Teacher() {		
		/*this.user = new User();*/
	}


	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherID) {
		this.teacherId = teacherID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	

	public void setTeacher_photo(Blob teacher_photo) {
		this.teacher_photo = teacher_photo;
	}

	public Blob getTeacher_photo() {
		return teacher_photo;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setMonthsOfExperience(int monthsOfExperience) {
		this.monthsOfExperience = monthsOfExperience;
	}

	public int getMonthsOfExperience() {
		return monthsOfExperience;
	}

	public void setPrimarySubject(String primarySubject) {
		this.primarySubject = primarySubject;
	}

	public String getPrimarySubject() {
		return primarySubject;
	}

	public void setSecondaySubject(String secondaySubject) {
		this.secondaySubject = secondaySubject;
	}

	public String getSecondaySubject() {
		return secondaySubject;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactNumber() {
		return contactNumber;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	

}
