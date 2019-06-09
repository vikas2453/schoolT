package com.edu.schoolT.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//standard mean a class with section like 10th A, 12th B.
@Entity
public class Standard {
	@Id
	private int standardId;
	private String standard;
	private int maxSeats;

	public int getMaxSeats() {
		return maxSeats;
	}

	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public void setStandardId(int standardId) {
		this.standardId = standardId;
	}

	public int getStandardId() {
		return standardId;
	}

	public String toString() {
		return standard;
	}

}