package com.edu.schoolT.model;

import java.sql.Date;

import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
public class Leave {
	@Id
	private long leaveId;
	private Date to;
	private Date from;
	private String reason;
	
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	

}
