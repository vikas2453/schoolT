package com.edu.schoolT.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Attendance {
	@Id
	private int attendanceId;
	private Date attendance_day;
	private String status;
	
	public int getAttendanceId() {
		return attendanceId;
	}
	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}
	public Date getAttendance_day() {
		return attendance_day;
	}
	public void setAttendance_day(Date attendance_day) {
		this.attendance_day = attendance_day;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
