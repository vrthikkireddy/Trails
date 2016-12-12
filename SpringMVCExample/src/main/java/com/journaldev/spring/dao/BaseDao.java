package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.model.Employee;

public interface BaseDao {
	public int saveEmployee(Employee emp);
	public int updateEmployee(Employee emp);
	public int deleteEmployee(int empID);
	public Employee getEmployeeById(int id);
	public List<Employee> getEmployees();
}
