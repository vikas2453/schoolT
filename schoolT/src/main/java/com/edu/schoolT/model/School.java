package com.edu.schoolT.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Component
@Entity
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="addressId")
	private Address address;
	
	//Private Management managment
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="school_id")
	private Set<Student> students;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="teacherId")
	private Set<Teacher> teachers;
	
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	public School() {
		
	}
	
	
	public School(String name, Address address) {
		this.name=name;
		this.address= address;
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public String toString() {
		return "\tschoolId:-->"+id+"\tname:-->"+name;
	}
	
	

}
