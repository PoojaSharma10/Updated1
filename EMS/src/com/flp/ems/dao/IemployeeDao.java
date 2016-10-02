package com.flp.ems.dao;

import java.sql.SQLException;

import com.flp.ems.domain.Employee;

public interface IemployeeDao {
	public void addEmployee(Employee employee) throws SQLException;
	   
    public void modifyEmployee(int id,Employee employee);
   
    public void removeEmployee(int employeeid)throws SQLException;
  
    
    public Boolean searchEmployee(int id) throws SQLException;
   
    public void showAllEmployee() throws SQLException;
}
