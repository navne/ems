package com.cg.eis.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.eis.exception.EmployeeException;
//import org.apache.log4j.Logger;

//import com.cg.pms.exception.ProductException;

public class DbUtil
{
//private static final Logger mylogger = Logger.getLogger(DbUtil.class);
static Connection conn = null;
public static Connection getConnection() throws EmployeeException
{
try {
FileInputStream fileRead = new FileInputStream("oracle.properties");
Properties pros = new Properties();
pros.load(fileRead); // load properties file

		String driver = pros.getProperty("oracle.driver");
		String url = pros.getProperty("oracle.url");
		String uname = pros.getProperty("oracle.username");
		String upass = pros.getProperty("oracle.password");
		//load the driver
		
		Class.forName(driver);
		//making connection
		conn = DriverManager.getConnection(url,uname,upass);
		System.out.println("Connection estabhlished...");
		
	}
	catch (IOException | SQLException | ClassNotFoundException e) 
	{
		e.printStackTrace();
//		mylogger.info("connection not estabhlished" + e);
		throw new EmployeeException("Connection not Estabhlished..");
	}
	
	return conn;
}	
}
