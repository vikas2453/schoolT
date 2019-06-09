package com.edu.schoolT.login.impl;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name="roleauthority")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Authority  implements GrantedAuthority {

	private String authority;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	public Authority(String authority, User user) {
		super();
		this.authority = authority;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Authority [authority=" + authority + "]";
	}

	

	
}
