package com.edu.schoolT.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.edu.schoolT.login.impl.User;
@Component
@Entity
public class Activity {
	@Id
	private long activityId;
	private String activityName;
	private String description;
	private Date createdDate;
	@DateTimeFormat(pattern="dd-mm-yyyy")
	private Date performDate;
	@OneToOne
	@JoinColumn(name="userId")
	private User createdby;
	private String level;
	private String location;
	
	public Activity(){
		performDate=new Date();
	}

	public long getActivityId() {
		return activityId;
	}

	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getPerformDate() {
		return performDate;
	}

	public void setPerformDate(Date performDate) {
		this.performDate = performDate;
	}

	public User getCreatedby() {
		return createdby;
	}

	public void setCreatedby(User user) {
		this.createdby = user;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	

}
