package com.madhav.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;
public void getDataBaseConnection(String Url,String UserName,String Password) throws SQLException {
	/** register to database or load to database**/
	
	try {
	Driver driver= new Driver() ;
		DriverManager.registerDriver(driver);
	 conn = DriverManager.getConnection(Url, UserName, Password);
	}catch (Exception e) {
		// TODO: handle exception
	}
}
public void closeConnection() throws SQLException {
	try {
		conn.close();
	}catch (Exception e) {
		// TODO: handle exception
	}
	}
public ResultSet executeSelectQuery(String Query) throws SQLException {
	ResultSet result=null;
	try {
	Statement stat = conn.createStatement();
	result = stat.executeQuery(Query);
	}catch (Exception e) {
		// TODO: handle exception
	}
	return result;
}
public int executeNonSelectQuery(String Query) throws SQLException {
	int result=0;
	try {
	Statement stat = conn.createStatement();
	result=stat.executeUpdate(Query);
	}catch (Exception e) {
		// TODO: handle exception
	}
	return result;
}
}