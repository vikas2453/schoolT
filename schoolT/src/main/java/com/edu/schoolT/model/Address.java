package com.edu.schoolT.model;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@XmlRootElement(name = "Address")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties({"pin","country"})
@Entity
public class Address {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	private long addressId;
	private String flatno;
	private String houseNo;
	private String street;
	private String sector;
	private String city;
	private String state;
	private String country;
	@ElementCollection
	private Collection<String>nearbyMarks;	
	private String pin;
	
	public Address(){
		
	}
	public Address(String flatno, String houseNo, String street, 
			String sector, String city, String state,String country, String pin,Collection<String>nearbyMarks){
		this.flatno = flatno;
		this.houseNo = houseNo;
		this.street= street;
		this.city= city;
		this.sector= sector;
		this.state= state;
		this.country = country;
		this.pin = pin;
		this.sector= sector;
		this.nearbyMarks = nearbyMarks;
		
		
	}
	public Address(String flatno, String houseNo, String street, 
			String sector, String city, String state,String country, String pin){
		this.flatno = flatno;
		this.houseNo = houseNo;
		this.street= street;
		this.city= city;
		this.sector= sector;
		this.state= state;
		this.country = country;
		this.pin = pin;
		this.sector= sector;		
	}
	
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getFlatno() {
		return this.flatno;
	}

	public void setFlatno(String aFlatno) {
		this.flatno = aFlatno;
	}

	public String getHouseNo() {
		return this.houseNo;
	}

	public void setHouseNo(String aHouseNo) {
		this.houseNo = aHouseNo;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String aStreet) {
		this.street = aStreet;
	}

	public String getSector() {
		return this.sector;
	}

	public void setSector(String aSector) {
		this.sector = aSector;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String aCity) {
		this.city = aCity;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String aState) {
		this.state = aState;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String aCountry) {
		this.country = aCountry;
	}
	
	public Collection<String> getNearbyMarks() {
		return nearbyMarks;
	}
	
	public void setNearbyMarks(Collection<String> nearbyMarks) {
		this.nearbyMarks = nearbyMarks;
		
	}
	public String toString() {
		return flatno+"\t"+
				 houseNo+"\t"+
				 street+"\t"+
				 sector+"\t"+
				 city+"\t"+
				 state+"\t"+
				 country;
		
	}
	
	

}