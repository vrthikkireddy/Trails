package com.journaldev.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.journaldev.model.Employee;
import com.journaldev.spring.dao.EmployeeDaoImpl;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	EmployeeDaoImpl employeeDao;

	@Override
	public int saveEmployee(Employee emp) {
		logger.info("Saving Employee "+emp);
		return employeeDao.saveEmployee(emp);
	}

	@Override
	public List<Employee> findAllUsers() {
		List<Employee> employees = employeeDao.getEmployees();
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByPage(int pageId, int total) {
		List<Employee> employees= employeeDao.getEmployeesByPage(pageId, total);
		return employees;
	}

	@Override
	public int deleteEmployee(int empId) {
		logger.info("Deleting the Employee with empID"+empId);
		return employeeDao.deleteEmployee(empId);
	}

	@Override
	public int updateEmployee(Employee emp) {
		logger.info("Updating the Employee with empId"+emp.getId());
		return employeeDao.updateEmployee(emp);
	}

	@Override
	public Employee findById(long id) {
		Employee emp = employeeDao.getEmployeeById((int) id);
		return emp;
	}
	
	

}
