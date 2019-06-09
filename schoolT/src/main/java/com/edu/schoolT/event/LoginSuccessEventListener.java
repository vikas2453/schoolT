package com.edu.schoolT.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
//import org.springframework.security.access.event.AuthorizedEvent;
//import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import com.edu.schoolT.login.dao.impl.UserDao;
import com.edu.schoolT.login.dao.impl.UserDetailsServiceImpl;
import com.edu.schoolT.login.impl.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Component
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class LoginSuccessEventListener extends EventListener {
	
	private UserDao userDao;

	private UserDetailsServiceImpl userDetailsService;	

	@Override
	public boolean canHandle(ApplicationEvent event) {		
		//return (event instanceof AuthenticationSuccessEvent);
		return true;
	}

	@Override
	public void handle(ApplicationEvent event) {
		AuthenticationSuccessEvent authenticationSuccessEvent =(AuthenticationSuccessEvent)event;
		User  user = (User)authenticationSuccessEvent.getAuthentication().getPrincipal();		
		
		if(user.getLoginFailedAttempt()>0){
			userDetailsService.updateLoginAttempt(user.getUsername(), true);
		}     
            

	}
	

}
