package com.edu.schoolT.login.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.edu.schoolT.login.impl.User;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Repository
@Data
@Log4j
public class UserDetailsServiceImpl implements UserDetailsService {

	@ Autowired
	UserDao userDao;
	/*
	 * @Override public boolean updateUser(User user) { Session session =
	 * sessionFactory.getCurrentSession(); log.debug("updating user" + user);
	 * session.merge(user); return true; }
	 * 
	 * @Override public boolean userIdTaken(String userId) { Session session =
	 * sessionFactory.openSession(); Transaction tx = session.beginTransaction();
	 * Long count = (Long) session .createQuery(
	 * "select count(*) from User where userId = :userId") .setString("userId",
	 * userId).setMaxResults(1).uniqueResult(); tx.commit(); session.flush();
	 * session.close();
	 * 
	 * if (count == 0) return false; else return true; }
	 */
	// @Override
	public User loadUserByUsername(String userId) throws UsernameNotFoundException {
		log.info("loadUserByuserId");
		return userDao.findByUserId(userId);

	}

	public void updateLoginAttempt(String userId, Boolean success) {
		log.info("loadUserByuserId");
		User user=userDao.findByUserId(userId);		 
		if (success) {
			user.setLoginFailedAttempt(0);
		} else {
			user.setLoginFailedAttempt(user.getLoginFailedAttempt() + 1);
		}
	}
	
	public boolean userIdTaken(String userId) {
		return (userDao.getOne(userId)!=null);		
		
	}

}
