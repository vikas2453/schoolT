package com.edu.schoolT.dao.impl;

import org.springframework.data.repository.CrudRepository;

import com.edu.schoolT.model.Query;

public interface QueryDao extends CrudRepository<Query, Integer>{
	public Query save(Query query);
	//public void updateQuery(Query query);
	//public List<Query>viewAllQuery(String userName);
	//List<Query> findByUser(User user);
	
	//List<Query>getAllTeacherQuery(Teacher teacher);
	public Query findByQueryId(int queryId);
	//public boolean updateResponse(RequestResponse requestResponse);

}
