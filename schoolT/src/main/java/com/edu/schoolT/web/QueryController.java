package com.edu.schoolT.web;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
//import javax.ws.rs.core.GenericEntity;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.schoolT.dao.impl.QueryDao;
import com.edu.schoolT.dao.impl.RequestResponseDao;
import com.edu.schoolT.dao.impl.TeacherDao;
import com.edu.schoolT.model.Query;
import com.edu.schoolT.model.RequestResponse;
import com.edu.schoolT.model.Student;
import com.edu.schoolT.model.Teacher;

@Controller
public class QueryController {
	

	static final Logger logger = Logger.getLogger(QueryController.class);
	@Autowired
	QueryDao queryDao;
	
	@Autowired
	RequestResponseDao requestResponseDao;
	
	@Autowired
	TeacherDao	teacherDao;
	@Autowired
	Query query;
	
		
	@RequestMapping(value = "/query.htm", method = RequestMethod.GET)
	public String showQueryForm(Map model) {
		
		//this needs to be removed from here as there is not user specific code below and 
		//is very generic which will be same for every user and needs to be done only once.
		
		model.put("query", query);
		Map<String,String> severity = new LinkedHashMap<String,String>();
		severity.put("Simple", "Simple");
		severity.put("Medium", "Medium");
		severity.put("High", "High");
		severity.put("Urgent", "Urgent");
		model.put("severityList", severity);
		
		Map<String,String> natureQuery = new LinkedHashMap<String,String>();
		natureQuery.put("SimpleQuery", "SimpleQuery");
		natureQuery.put("Suggestion", "Suggestion");
		natureQuery.put("Complain", "Complain");
		model.put("natureQuery", natureQuery);
		
		return "parent/query";
	}
	
	@RequestMapping(value = "/query.htm", method = RequestMethod.POST)
	public String submitQueryForm(Query query, HttpSession session, Principal principal) {
		Student student = (Student) session.getAttribute("student");			
		query.setInitiator(principal.getName());
		query.setDateStarted(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		query.setStatus("open");	
		query.updateRequestResponse();		
		queryDao.save(query);				
		return "parent/query";
	}	
	

	@RequestMapping(value = "/parent/pendingQuery.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<Query> parentPendingQuery(HttpSession session,Principal principal){
		logger.debug("parentPendingQuery is called");
		Student student = (Student) session.getAttribute("student");
		if(student !=null){
			//TO-DO
			//List<Query> queryList = queryDao.findByUser(student);
			List<Query> queryList=null;
			
			return queryList;			
		}
		return null;
		
	}
	
	@RequestMapping(value = "/teacher/pendingQuery.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<Query> teacherPendingQuery(HttpSession session){		
		if((session).getAttribute("teacher")!=null){
			Teacher teacher =(Teacher)session.getAttribute("teacher");
			//TO-DO
			//List<Query> queryList = queryDao.getAllTeacherQuery(teacher);
			List<Query> queryList=null;
			
			
			return queryList;			
		
		}
		return null;
		
	}
	
	
	@RequestMapping(value = "/fetchQueryDetails.htm", method = RequestMethod.GET, headers ="Content-Type=Application/JSON")
	@ResponseBody	
	public List<RequestResponse> fetchQueryDetails(@RequestParam(value="queryId", required=true) int queryId, Principal principal){	
		logger.debug("fetchQueryDetails called");
		Query query =queryDao.findByQueryId(queryId);
		
		//if(query.getInitiator().equalsIgnoreCase(principal.getName())){
			List<RequestResponse> requestRepsonseList =query.getRequestResponseList();				
			return 	requestRepsonseList;
		//}
		//return null;	 
	}
	
	
	@RequestMapping(value = "teacher/response.htm", method = RequestMethod.POST)
	@ResponseBody	
	public String submitTeacherResponse(@RequestParam(value="response")String response,@RequestParam(value="repsonseId")int responseId){
		RequestResponse rr = new RequestResponse();
		rr.setRequestResponseId(responseId);
		rr.setResponsText(response);
		requestResponseDao.save(rr);		
		return "ok";
		
	}
}
