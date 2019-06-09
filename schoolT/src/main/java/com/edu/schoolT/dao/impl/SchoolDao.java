package com.edu.schoolT.dao.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.schoolT.model.School;

@Repository
public interface SchoolDao extends CrudRepository<School, Integer> {
	public School findById(long l);
	public School save(School s);

}
