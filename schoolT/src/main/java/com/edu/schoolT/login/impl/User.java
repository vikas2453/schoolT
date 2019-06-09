package com.edu.schoolT.login.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.edu.schoolT.model.Address;

import lombok.Data;
import lombok.ToString;
@Entity
@Component
@Data
@ToString
public class User implements UserDetails  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static final Logger logger = Logger.getLogger(User.class);
	
	@Id
	private String userId;
	public static final short maxLoginFailedAttempt = 3;
	private int loginFailedAttempt = 0;
	@NotEmpty
	private String password;

	private String confirmPassword;

	private String emailaddress;
	private String securityQuestion;
	private String securityAnswer;
	private Date lastLoggedIn;
	private int loginTimes;
	private Boolean enabled;

	@Autowired
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="addressId")
	private Address address;
	@OneToMany(mappedBy="user",cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	private List<Authority> authorityList = new ArrayList<>();

	
	private String userType;
	
	
	public User() {
		address = new Address();
	}

	public User(String userid, String password,  boolean enabled) {
		this.userId = userid;
		this.password = password;
		this.enabled = enabled;
	}
	
	public User(String userid, String password,  Address address) {
		this.userId = userid;
		this.password = password;
		this.address = address;
	}

	
	
	
	//@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	

	// @Override
	public String getUserId() {
		// TODO Auto-generated method stub
		return userId;
	}
	 
	 //@Override
	public void setUserId(String userId) {

		this.userId = userId;
	}

	// @Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	// @Override
	public boolean isAccountNonLocked() {
		logger.debug("maxLoginFailedAttempt" + maxLoginFailedAttempt);
		if (this.loginFailedAttempt >= maxLoginFailedAttempt) {
			return false;
		}
		return true;
	}

	// @Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	// @Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return (enabled == null ? true : enabled);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorityList;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	
	
}
