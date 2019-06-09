package com.edu.schoolT.web;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.schoolT.dao.impl.ActivityDao;
import com.edu.schoolT.model.Activity;
import com.edu.schoolT.model.Teacher;

@Controller
public class ActivityController {
	
	static final Logger logger = Logger.getLogger(ActivityController.class);
	@Autowired
	private Activity activity;
	@Autowired
	private ActivityDao activityDao;

	@RequestMapping(value = "/createActivity.htm", method = RequestMethod.POST)
	public void createActivity(final HttpSession session, Activity activity) {
		logger.debug(activity.getActivityName());
		
		activity.setCreatedby(((Teacher)session.getAttribute("teacher")).getUser());
		activity.setCreatedDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		activityDao.save(activity);		
		
	}

	@RequestMapping(value = "/createActivity.htm", method = RequestMethod.GET)
	public String showActivityForm(Map<String, Activity> model) {
		model.put("activity", activity);
		return "Activity/activityForm";
	}

}
