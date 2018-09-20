package com.nilesh.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.nilesh.web.entity.Employee;
import java.lang.String;
import java.util.List;
import java.lang.Long;


public interface EmployeeSQLRepository extends CrudRepository<Employee, String>{
	Employee findById(Long id);
	List<Employee> findByName(String name);
	List<Employee> findByMobile(Long mobile);
}
