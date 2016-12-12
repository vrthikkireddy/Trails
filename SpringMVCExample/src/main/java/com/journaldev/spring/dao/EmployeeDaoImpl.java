/**
 * 
 */
package com.journaldev.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.journaldev.model.Employee;

/**
 * @author vrtikkireddi
 *
 */
@Repository
public class EmployeeDaoImpl implements BaseDao {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * @see com.journaldev.spring.dao.BaseDao#saveEmployee(com.journaldev.spring.model.Employee)
	 */
	@Override
	public int saveEmployee(Employee e) {
		String query = "insert into mysql.employee values('" + e.getId() + "','" + e.getName() + "','" + e.getSalary() + "')";
		logger.info("Save Emplyee Query "+query);
		return jdbcTemplate.update(query);
	}

	/* (non-Javadoc)
	 * @see com.journaldev.spring.dao.BaseDao#updateEmployee(com.journaldev.spring.model.Employee)
	 */
	@Override
	public int updateEmployee(Employee e) {
		String query = "update mysql.employee set name='" + e.getName() + "',salary='" + e.getSalary() + "' where id='"
				+ e.getId() + "' ";
		return jdbcTemplate.update(query);
	}

	/* (non-Javadoc)
	 * @see com.journaldev.spring.dao.BaseDao#deleteEmployee(com.journaldev.spring.model.Employee)
	 */
	@Override
	public int deleteEmployee(int empID) {
		String query = "delete from mysql.employee where id='" + empID + "' ";
		return jdbcTemplate.update(query);
	}

	/* (non-Javadoc)
	 * @see com.journaldev.spring.dao.BaseDao#getEmployeeById(int)
	 */
	@Override
	public Employee getEmployeeById(int id) {
String query = "select id, name, salary from mysql.employee where id = ?";
		
		//using RowMapper anonymous class, we can create a separate RowMapper for reuse
		Employee emp = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Employee>(){

			public Employee mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getFloat("salary"));
				return emp;
			}});
		
		return emp;
	}

	/* (non-Javadoc)
	 * @see com.journaldev.spring.dao.BaseDao#getEmployees()
	 */
	@Override
	public List<Employee> getEmployees() {
		return jdbcTemplate.query("select * from mysql.employee",new ResultSetExtractor<List<Employee>>(){  
		    @Override  
		     public List<Employee> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Employee> list=(List<Employee>) new ArrayList<Employee>();  
		        while(rs.next()){  
		        Employee e=new Employee();  
		        e.setId(rs.getInt(1));  
		        e.setName(rs.getString(2));  
		        e.setSalary(rs.getInt(3));  
		        list.add(e);  
		        }  
		        return list;  
		        }  
		    }); 
	}
	
	
	public List<Employee> getEmployeesByPage(int pageid,int total){  
	    String sql="select * from mysql.employee limit "+(pageid-1)+","+total;  
	    logger.info("Get EmployeeBy Page "+sql);
	    return jdbcTemplate.query(sql,new RowMapper<Employee>(){  
	        public Employee mapRow(ResultSet rs, int row) throws SQLException {  
	            Employee e=new Employee();  
	            e.setId(rs.getInt(1));  
	            e.setName(rs.getString(2));  
	            e.setSalary(rs.getFloat(3));  
	            return e;  
	        }  
	    });  
	}  

}
