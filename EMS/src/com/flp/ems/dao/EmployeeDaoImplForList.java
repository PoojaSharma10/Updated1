package com.flp.ems.dao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flp.ems.domain.Employee;
import com.flp.ems.util.DbConnection;

import javafx.scene.control.TableCellBuilder;
public class EmployeeDaoImplForList implements IemployeeDao {
	private ArrayList<Employee> employeelist;
	private DbConnection database;
	public EmployeeDaoImplForList() throws SQLException, IOException {
		super();
		employeelist=new ArrayList<Employee>();
		database=new DbConnection();
	}
	public void addEmployee(Employee employee) throws SQLException
    {
    	//employeelist.add(employee);
		database.insertEmployee(employee.getName(),employee.getKinId(),employee.generateEmailId(),employee.getPhoneNo(),
				                employee.getDateOfBirth(),employee.getDateOfjoining(),employee.getAddress(),employee.getDepartmentId(),employee.getProjectId(),employee.getRolesId());
    	/*System.out.println("employee added successfully :");
    	System.out.println("EmployeeId       EmailId       Name       RolesId      DepartmentId     ProjectId\n");
    	for(Employee e:employeelist)
    	{  System.out.println("working");
    		System.out.println(e.getEmployeeId()+"  "+e.getEmailId()+"  "+e.getName()+"  "+e.getRolesId()+"  "+e.getDepartmentId()+"  "+e.getProjectId());
    	}*/
    }
    public Employee getCloneObject(int employeeId) throws CloneNotSupportedException
    {
    	Employee employee=null;
        for(Employee e:employeelist)
    	{
    		if(e.getEmployeeId()==employeeId)
    			employee=(Employee)e.clone();
    	}
        
        return employee;
    }
	public void modifyEmployee(int employeeId,Employee employee)
    { int index=0;
      Employee temp;
		for(;index<employeelist.size();index++)
		{
			temp=employeelist.get(index);
			if(temp.getEmployeeId()==employeeId)
			{ employeelist.set(index, employee);
			  System.out.println("employee modified");
			  break;
				
			}
		}
    	
    }
    public void removeEmployee(int employeeId) throws SQLException
    {
    	/*boolean b=employeelist.remove(employee);
    	if(b)
    		System.out.println("Employee successfully removed");
    	else
    		System.out.println("something went wrong in Dao Layer");*/
    	boolean b=database.removeEmployee(employeeId);
    
    }
    
    public Boolean searchEmployee(int employeeId) throws SQLException
    {    /*Employee employee=null;
      System.out.println("in Dao");
    for(Employee e:employeelist)
	{   
		if(e.getEmployeeId()==employeeId)
		{	employee=e;System.out.println("found");break;}
	}
    	return employee;*/
    	Boolean b=database.searchEmployee(employeeId);
    	return b;
    }
    public void showAllEmployee() throws SQLException
    {    System.out.println("Employee List :\n");
         database.displayEmployee();
         //TableBuilder 
        /* System.out.println("EmployeeId      EmailId       Name       RolesId      DepartmentId     ProjectId\n");
    	for(Employee e:employeelist)
    	{  System.out.println("working");
    		System.out.println(e.getEmployeeId()+"  "+e.getEmailId()+"  "+e.getName()+"  "+e.getRolesId()+"  "+e.getDepartmentId()+"  "+e.getProjectId());
    	}*/
    }
	
	
}
