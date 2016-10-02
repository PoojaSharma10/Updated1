package com.flp.ems.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

public class DbConnection
{
	Properties props;
	FileInputStream fln;
	Connection dbConnection;
	public DbConnection() throws  SQLException, IOException {
		props = new Properties();
		fln = new FileInputStream("dbDetails.properties");
		
		// TODO LOAD JDBC PROPERTIES FROM FILE SYSYTEM
		props.load(fln);

		// TODO load and register 'JDBC driver'
		String driver = props.getProperty("jdbc.driver");
		
		// REQUIRED IF JDBC 3 OR BELOW
		// Class.forName(driver);

		// TODO get databse connection using jdbc url
		String url = props.getProperty("jdbc.url");
		dbConnection = DriverManager.getConnection(url);
		System.out.println("Connection Successful?" + (dbConnection != null));
	}
	public void insertEmployee(String Name,String KinId,String EmailId,int PhoneNo,Date DateOfBirth,Date DateOfjoining,String Address,int DepartmentId,int ProjectId,
          int RolesId) throws SQLException {
		String insertQuery = props.getProperty("jdbc.employee.query.insert");
		java.sql.Date sqlDateOfBirth = new java.sql.Date(DateOfBirth.getTime());
		java.sql.Date sqlDateOfjoining = new java.sql.Date(DateOfjoining.getTime());
		try (PreparedStatement insertStatement = dbConnection.prepareStatement(insertQuery)) {
			insertStatement.setInt(1,201);
			insertStatement.setString(2, Name);
			insertStatement.setString(3, KinId);
			insertStatement.setString(4, EmailId);
			insertStatement.setInt(5, PhoneNo);
			insertStatement.setDate(6,sqlDateOfBirth);
			insertStatement.setDate(7,sqlDateOfjoining);
			insertStatement.setString(8, Address);
			insertStatement.setInt(9, DepartmentId);
			insertStatement.setInt(10, ProjectId);
			insertStatement.setInt(11, RolesId);
			insertStatement.executeUpdate();
		}
	}
	public void displayEmployee() throws SQLException  {
		try (Statement selectStatement = dbConnection.createStatement()) {
			String selectQuery = props.getProperty("jdbc.employee.query.selectAll");
			ResultSet result = selectStatement.executeQuery(selectQuery);
			while (result.next()) {
				String message = result.getInt(1)+"   "+result.getString(2)+"   "+result.getString(3)
				+result.getString(4)+"   "+result.getInt(5)+"   "+result.getDate(6)+"   "+result.getDate(7)+"   "
			    +result.getString(8)+"   "+result.getInt(9)+"   "+result.getInt(10)+"   "+result.getInt(11);
				System.out.println(message);
			}
		}
	}
	public boolean searchEmployee(int employeeId) throws SQLException {
		String selectQuery = props.getProperty("jdbc.employee.query.select");
		try (PreparedStatement selectStatement = dbConnection.prepareStatement(selectQuery)) {
			selectStatement.setInt(1,employeeId);
			ResultSet result = selectStatement.executeQuery();
			if (result.next()) {
				String message = result.getInt(1)+"   "+result.getString(2)+"   "+result.getString(3)
				+result.getString(4)+"   "+result.getInt(5)+"   "+result.getDate(6)+"   "+result.getDate(7)+"   "
			    +result.getString(8)+"   "+result.getInt(9)+"   "+result.getInt(10)+"   "+result.getInt(11);
				System.out.println(message);
				return true;
			}
		}
		return false;
	}
	public boolean removeEmployee(int employeeId) throws SQLException {
		String selectQuery = props.getProperty("jdbc.employee.query.delete");
		try (PreparedStatement selectStatement = dbConnection.prepareStatement(selectQuery)) {
			selectStatement.setInt(1,employeeId);
			int result = selectStatement.executeUpdate();
			System.out.println(result+"deletion is performed");
		}
		return true;
	}

}
