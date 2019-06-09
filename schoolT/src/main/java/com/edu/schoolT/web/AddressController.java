package com.edu.schoolT.web;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.schoolT.login.dao.impl.UserDao;
import com.edu.schoolT.login.impl.User;
import com.edu.schoolT.model.Activity;
import com.edu.schoolT.model.Address;
import com.edu.schoolT.model.Teacher;


@Controller
//@Interceptor
public class AddressController {
	static final Logger logger = Logger.getLogger(AddressController.class);
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "/updateDetails.htm", method = RequestMethod.GET)
	public String showAddressDetails(Map<String, Object> model) {
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {			
			User user =(User) auth.getPrincipal();
			logger.debug("returning address for"+user);
			model.put("user", user);			
			return "Include/address";		
		}*/
		return null;
	        
		
	}

	@RequestMapping(value = "/updateDetails.htm", method = RequestMethod.POST)
	public String updateAddressDetails(User user,Map<String, User> model ) {
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			User userSession =(User) auth.getPrincipal();
			userSession.setAddress(user.getAddress());
			userDao.updateUser(userSession);
			logger.debug(userSession.getAddress().getCountry());
			model.put("user", user);			
			return "Include/address";	
		}*/
			
			return null;
				
		
	    
	}

	

	
	

}
