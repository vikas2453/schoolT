package com.edu.schoolT.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Component
@Entity
@XmlRootElement(name = "requestResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties({"query"})
public class RequestResponse {
	
	@ManyToOne
	@JoinColumn(name="queryId")
	private Query query;
	@Id
	private int requestResponseId;
	private Timestamp requestTime;
	private Timestamp responsetime;
	private String requestText;
	private String responsText;
	private String requester;
	
	/*public boolean equals(Object o){
		if(!(o instanceof RequestResponse))
		return false;
		if(this == o)return true;
		else{
			RequestResponse rr=(RequestResponse)o;	
		return (requestResponseId != 0)? (requestResponseId==rr.getRequestResponseId()): 
			(this.requestTime.equals(rr.getRequestTime())&&(this.requestText.equals(rr.getRequestText())));
		}
		
		
		
	}*/
	public int getRequestResponseId() {
		return requestResponseId;
	}
	public void setRequestResponseId(int requestResponseId) {
		this.requestResponseId = requestResponseId;
	}
	public Timestamp getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	}
	public Timestamp getResponsetime() {
		return responsetime;
	}
	public void setResponsetime(Timestamp responsetime) {
		this.responsetime = responsetime;
	}
	public String getRequestText() {
		return requestText;
	}
	public void setRequestText(String requestText) {
		this.requestText = requestText;
	}
	public String getResponsText() {
		return responsText;
	}
	public void setResponsText(String responsText) {
		this.responsText = responsText;
	}
	public String getRequester() {
		return requester;
	}
	public void setRequester(String requester) {
		this.requester = requester;
	}

	public int hashCode(){
		return 22;
		/*return (requestResponseId != 0)? requestResponseId: 
			(this.requestText.hashCode());*/
	}
	
	public String toString(){
		return requestText;
	}
	
	public Query getQuery() {
		return query;
	}
	public void setQuery(Query query) {
		this.query = query;
	}
	
	/*public int getQueryId() {
		return queryId;
	}
	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}
*/
}
