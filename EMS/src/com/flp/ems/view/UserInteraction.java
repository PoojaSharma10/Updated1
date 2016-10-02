package com.flp.ems.view;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import com.flp.ems.domain.Employee;
import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.util.Validate;

public class UserInteraction {
	// private static final Object "GS_100" = null;
	private Scanner sc;
	private EmployeeServiceImpl employeeServiceImpl;
	SimpleDateFormat dateFormat;
	private HashMap<String, Object> hashmap;
	private int EmployeeId, PhoneNo, DepartmentId, ProjectId, RolesId;
	private String Name, KinId = "GS_100", EmailId = "xyz@gmail.com", Address, date;
	private Date DateOfBirth, DateOfjoining;

	public UserInteraction() throws SQLException, IOException {
		sc = new Scanner(System.in);
		hashmap = new HashMap<String, Object>();
		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		employeeServiceImpl=new EmployeeServiceImpl();
	}

	public void addEmployee() throws SQLException {
		hashmap.put("EmployeeId",201);
		hashmap.put("EmailId", EmailId);
		hashmap.put("KinId", KinId);
		hashmap.put("DepartmentId", 11);
		hashmap.put("RolesId", 21);
		hashmap.put("ProjectId", 1);
		System.out.println("Enter Name :");
		Name = sc.next();
		hashmap.put("Name", Name);
		System.out.println("Enter Phone No:");
		PhoneNo = sc.nextInt();
		hashmap.put("PhoneNo", PhoneNo);
		System.out.println("Enter Address:");
		Address = sc.next();
		hashmap.put("Address", Address);
		System.out.println("Enter Date of birth:");
		date = sc.next();
		try {
			// Parsing the String
			if (Validate.isThisDateValid(date, "dd-MM-yyyy"))
				DateOfBirth = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		hashmap.put("DateOfBirth", DateOfBirth);
		System.out.println("Enter Date of joining:");
		date = sc.next();
		try {
			// Parsing the String
			if (Validate.isThisDateValid(date, "dd-MM-yyyy"))
				DateOfjoining = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		hashmap.put("DateOfjoining", DateOfjoining);
		
	//	System.out.println("service layer called");
		employeeServiceImpl.addEmployee(hashmap);
		
	}

	public void modifyEmployee() throws CloneNotSupportedException {
	/*	System.out.println("Enter the employee Id of employee	");
		int employeeId=sc.nextInt();
		Employee employee=employeeServiceImpl.searchEmployee(employeeId);
		if(employee==null)
		{
			System.out.println("employee does not exist");
             return;
		}
		/*System.out.println("Enter Name :");
		Name = sc.next();
		hashmap.put("Name", Name);*/
	/*	System.out.println("Enter Phone No:");
		PhoneNo = sc.nextInt();
		System.out.println("Enter Department Id:");
		DepartmentId = sc.nextInt();
		hashmap.put("DepartmentId", DepartmentId);
		System.out.println("Enter Project Id:");
		ProjectId = sc.nextInt();
		hashmap.put("ProjectId", ProjectId);
		System.out.println("Enter Roles Id:");
		RolesId = sc.nextInt();
		hashmap.put("RolesId", RolesId);
		System.out.println("Enter Address:");
		Address = sc.next();
		hashmap.put("Address", Address);
		System.out.println("Enter Date of birth:");
		date = sc.next();
		try {
			// Parsing the String
			if (Validate.isThisDateValid(date, "dd-MM-yyyy"))
				DateOfBirth = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		employeeServiceImpl.modifyEmployee(employeeId,hashmap);*/

	}

	public void removeEmplyee() throws SQLException {
		System.out.println("Enter employeeId to be Removed");
      int employeeId=sc.nextInt();
      employeeServiceImpl.removeEmplyee(employeeId);
	}

	public boolean searchEmployee() throws SQLException {
		
		System.out.println("Enter employeeId to be searched");
	      int employeeId=sc.nextInt();
	      Boolean b=employeeServiceImpl.searchEmployee(employeeId);
	      if(b==true){
	    	  System.out.println("Employee found");
	    	  return true;}
	      else
	    	  System.out.println("something went wrong at userInteraction");
	      return false;
	}

	public void showAllEmployee() throws SQLException
	{
		employeeServiceImpl.showAllEmployee();
	}

}
