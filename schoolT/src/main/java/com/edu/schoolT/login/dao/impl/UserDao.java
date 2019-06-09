package com.edu.schoolT.login.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.schoolT.login.impl.User;


	
public interface UserDao extends  JpaRepository<User, String>{
	public User findByUserId(String userId);
	/*public boolean updateUser(User user);*/
	
}
