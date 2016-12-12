package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.model.Employee;

public interface EmployeeService {
	
	
	Employee findById(long id);
//	
//	User findByName(String name);
	
	int saveEmployee(Employee emp);
	
	int updateEmployee(Employee emp);
	
//	void updateUser(User user);
//	
//	void deleteUserById(long id);
//
	List<Employee> findAllUsers(); 
	
	List<Employee> getEmployeesByPage(int pageId,int total);
	
	int deleteEmployee(int empId);
//	
//	void deleteAllUsers();
//	
//	public boolean isUserExist(User user);
	
}
