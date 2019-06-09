package com.edu.schoolT.dao.impl;

import org.springframework.data.repository.CrudRepository;

import com.edu.schoolT.model.Activity;

public interface ActivityDao extends CrudRepository<Activity, Integer> {
	 public Activity save(Activity activity);

}
