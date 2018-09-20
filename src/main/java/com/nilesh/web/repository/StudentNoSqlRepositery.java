package com.nilesh.web.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import com.nilesh.web.DAO.StudentDAO;
import com.nilesh.web.model.Students;

import java.lang.String;
import java.lang.Long;




public interface StudentNoSqlRepositery extends MongoRepository<Students, String>{
		public List<Students> findByName(String name);
		public List<Students> findByMobile(Long mobile);
		public Students findById(String id);
		


}
