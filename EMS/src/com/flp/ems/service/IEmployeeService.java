package com.flp.ems.service;

import java.sql.SQLException;
import java.util.HashMap;

import com.flp.ems.domain.Employee;

public interface IEmployeeService {
	public void addEmployee(HashMap<String, Object> hashmap) throws SQLException;
   
    public void modifyEmployee(int id,HashMap<String,Object> hashmap) throws CloneNotSupportedException;
   
    public void removeEmplyee(int id)throws SQLException;
  
    
    public Boolean searchEmployee(int id) throws SQLException;
   
    public void showAllEmployee() throws SQLException;
    
}
