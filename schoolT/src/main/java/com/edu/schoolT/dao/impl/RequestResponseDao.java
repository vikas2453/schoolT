package com.edu.schoolT.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.schoolT.model.RequestResponse;

@Repository
public interface RequestResponseDao extends JpaRepository<RequestResponse, Integer> {

}
