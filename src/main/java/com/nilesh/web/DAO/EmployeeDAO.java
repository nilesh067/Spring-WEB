package com.nilesh.web.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nilesh.web.entity.Employee;
import com.nilesh.web.repository.EmployeeSQLRepository;


@Component
public class EmployeeDAO {
	@Autowired
	EmployeeSQLRepository empRepository;
	public Employee addEmployee(Employee emp) {
		return empRepository.save(emp);
	}
	public Employee findById(Long id) {
		return empRepository.findById(id);
	}
	public List<Employee> findByName(String name){
		return empRepository.findByName(name);
	}
	public List<Employee> findByMobile(Long mobile){
		return empRepository.findByMobile(mobile);
	}
	

}
