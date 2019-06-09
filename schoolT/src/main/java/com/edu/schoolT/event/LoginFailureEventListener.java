package com.edu.schoolT.event;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
//import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

import com.edu.schoolT.login.dao.impl.UserDao;
import com.edu.schoolT.login.dao.impl.UserDetailsServiceImpl;

import lombok.Data;

@Component
@Data
public class LoginFailureEventListener extends EventListener {
	
	static final Logger logger = Logger.getLogger(LoginFailureEventListener.class);
	
	private UserDao userDao;
	
	private UserDetailsServiceImpl userDetailsService;
	
	@Override
	public boolean canHandle(ApplicationEvent event) {
		//return event instanceof AuthenticationFailureBadCredentialsEvent
		return true ;
	}

	@Override
	public void handle(ApplicationEvent event) {
		// TODO Auto-generated method stub
		
		AuthenticationFailureBadCredentialsEvent loginFailureEvent =(AuthenticationFailureBadCredentialsEvent)event;
		String userName = (String)loginFailureEvent.getAuthentication().getPrincipal();
		logger.info("loginFailureEvent occurred");
		if(userName!=null){
			userDetailsService.updateLoginAttempt(userName,false);
		}
		

	}

}
