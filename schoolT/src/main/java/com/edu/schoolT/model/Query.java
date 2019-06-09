package com.edu.schoolT.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.edu.schoolT.login.impl.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@XmlRootElement(name = "query")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties({ "user", "requestResponseList" })
public class Query {
	@Id
	private int queryId;
	private String initiator;
	private String subject;
	private String severity;
	private String status;
	private String nature;
	private Timestamp dateStarted;
	private Timestamp dateEnded;
	@ElementCollection
	private List<RequestResponse> requestResponseList;
	@ManyToOne
	@JoinColumn(name="userId")
	public User user;

	public Query() {

	}

	public Query(int queryId, String initiator, String severity, String status, String subject) {
		this.queryId = queryId;
		this.initiator = initiator;
		this.severity = severity;
		this.status = status;
		this.subject = subject;

	}

	public int getQueryId() {
		return queryId;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(Timestamp dateStarted) {
		this.dateStarted = dateStarted;
	}

	public Timestamp getDateEnded() {
		return dateEnded;
	}

	public void setDateEnded(Timestamp dateEnded) {
		this.dateEnded = dateEnded;
	}

	public List<RequestResponse> getRequestResponseList() {
		return requestResponseList;
	}

	public void setRequestResponseList(List<RequestResponse> requestResponseList) {
		this.requestResponseList = requestResponseList;
	}

	public void addRequestResponse(RequestResponse requestResponse) {

		if (requestResponseList == null) {
			requestResponseList = new ArrayList<RequestResponse>();

		}
		// requestResponse.setQueryId(queryId);
		requestResponseList.add(requestResponse);
		// requestResponse.setQuery(this);

	}

	public void updateRequestResponse() {

		for (RequestResponse rr : requestResponseList) {
			rr.setQuery(this);

		}
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getNature() {
		return nature;
	}

	public String toString() {
		return this.queryId + this.subject + this.severity + this.initiator;
	}

	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}

	public String getInitiator() {
		return initiator;
	}

}
