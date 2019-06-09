package com.edu.schoolT.web;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
/*import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.edu.schoolT.dao.impl.StudentDao;
import com.edu.schoolT.login.dao.impl.UserDao;
import com.edu.schoolT.login.impl.User;
import com.edu.schoolT.model.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginController {
	
	@Autowired
	UserDao userDao;
	

	@Autowired
	StudentDao studentDao;
	
	@Autowired
	User user;
	

	@Autowired
	public UserLoginController(User user ){
		//this.userDao = userDao;
		this.user = user;
		//this.studentDao = studentDao;
	}
	
	
	@RequestMapping(value ="/login.htm", method = RequestMethod.GET)
	public String showValidatinForm(Map<String, User> model) {	
		model.put("user", this.user);
		return "userLogin";
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.POST)
	public String loginerror(ModelMap model) { 
		model.addAttribute("error", "true");
		return "userLogin"; 
	}
	
	@RequestMapping(value="/roleHome.htm", method = RequestMethod.POST)
	public View home(){
		
		log.debug("Inside the rolehome.htm");
		
		Set<String> roles = AuthorityUtils
        .authorityListToSet(SecurityContextHolder.getContext()
                .getAuthentication().getAuthorities());

		if (roles.contains("ROLE_admin")) {
            return new RedirectView("adminHome.htm");
        }
		if (roles.contains("ROLE_parent")) {
            return new RedirectView("parentHome.htm");
        }
		if (roles.contains("ROLE_teacher")) {
            return new RedirectView("teacherHome.htm");
        }
		return null;
		

		
	}
	
	/*@RequestMapping( method = RequestMethod.POST)
	public String processValidatinForm(User user,BindingResult result,
			Map<String, User> model) {
		if (result.hasErrors()) {
			return "enrollmentForm";
		}
		// Add the saved validationForm to the model
		 //parent = model.get("parent");
		//logger.debug(parent.getAdmissionNumber());
		model.put("user", user);
		User userTemp = userDao.findByUserId(user.getUserId());
			if(userTemp!=null){	
				if(user.getPassword().equals(userTemp.getPassword())){
				log.debug("user with "+user.getUserId()+"is validated");
				user = (User) userTemp;
				int logintimes = user.getLoginTimes();
				
				user.setLoginTimes(++logintimes);
				// parent.setUserid("vansha");
				userDao.saveAndFlush(user);
	
				// let's get the student of this parent
	
				//AdmittedStudent student = parentDao.getStudent(parent.getAdmissionNumber());
				//parent.setStudent(student);
				
	
				if (logintimes == 1) {
					// AdmittedStudent
					// s=studentDao.getStudent(student.getEnrollmentNumber());
	
					return "userChangePassword"; 
	
				}
				if(user.getUserType().equals("parent")){
					Student student = studentDao.findByUser(user);
					
					model.put("student", user);				
				}
				if(user.getUserType().equals("Teacher")){
					model.put("teacher", user);				
				}
			
				
				return (user.getUserType()+"Home");
				
				
			}
			System.out.println("validation failed");
		}

		return "userLogin";
	}
	*/
	


}

	