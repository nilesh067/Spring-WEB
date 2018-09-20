package com.nilesh.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nilesh.web.entity.Employee;
import com.nilesh.web.repository.EmployeeSQLRepository;

@Controller
@RequestMapping("/emp")
public class EmployeeSerivce {
	@Autowired
	EmployeeSQLRepository empRepository;
	
	@RequestMapping("/add")
	public String addEmployeeUI() {
		return "empAdd";
	}
	
	
	//http://localhost:8081/emp/add?name=Nilesh+Kumar&dept=operation&email=nilesh@email.com&mobile=9709700400
	@RequestMapping("/addEmp")
	@ResponseBody
	public Employee addEmployee(@RequestParam (name="name")String empName,
			@RequestParam (name="dept")String empDept,
			@RequestParam (name="email")String empEmail,
			@RequestParam (name="mobile")Long empMobile) {
		Employee e =new Employee(null, empName, empDept, empMobile, empEmail);
		return empRepository.save(e);
	}
	
	
	@RequestMapping("/findById")
	@ResponseBody
	public Employee findById(@RequestParam(name="id")Long id) {
		return empRepository.findById(id);
	}
	@RequestMapping("/findByName")
	@ResponseBody
	public List<Employee> findByName(@RequestParam(name="name")String name){
		return empRepository.findByName(name);
	}
	
	//http://localhost:8081/emp/findByMobile?eemail=nileshsingh067@gmail.com
	@RequestMapping("/findByMobile")
	@ResponseBody
	public List<Employee> findByMobile(@RequestParam(name="mobile")Long mobile){
		return empRepository.findByMobile(mobile);
	}
	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		return "Working";
	}
	
	
	
	

}
