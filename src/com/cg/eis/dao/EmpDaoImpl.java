package com.cg.eis.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cg.eis.beans.Employee;
import com.cg.eis.exception.EmployeeException;
import com.cg.eis.util.DbUtil;

public class EmpDaoImpl implements IEmpDao
{
	static PreparedStatement pstm = null;
	static Connection con = null;
	
	List<Employee> myList = null;
	

	@Override
	public int addEmployee(Employee emp) throws EmployeeException
	{
		int status = 0;
		int idReturn = 0;
		
		 try {
			con = DbUtil.getConnection();
			
			
			int empId = getEmpId();
			LocalDate localdate = emp.getDateOfJoining();
			Date date = Date.valueOf(localdate);
			
			String query = "INSERT INTO EMPLOYEEDB VALUES (?,?,?,?,?,?)";
			pstm = con.prepareStatement(query);
			pstm.setInt(1, empId);
			pstm.setString(2, emp.geteName());
			pstm.setLong(3, emp.getEmpSalary());
			pstm.setDate(4, date);
			pstm.setString(5, emp.getPhoneNo());
			pstm.setString(6, emp.geteMail());
			
			status = pstm.executeUpdate();
			if ( status == 1)
			{
				 idReturn = empId ;
			}
			
		} catch (EmployeeException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EmployeeException("problem in addition");
		}
		 finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 return idReturn;
		 
		}
	
	@Override
	public List<Employee> viewAllemployee() throws EmployeeException {
		myList  = new ArrayList<Employee>();
		
		con = DbUtil.getConnection();
		
		String querythree = "select empid , ename , salary ,   phonenumber , email from employeedb";
		try
		{
			pstm = con.prepareStatement(querythree);
			
			
		     ResultSet resOne = pstm.executeQuery();
		     
		     while (resOne.next())
		     {
		    	 Employee emp = new Employee();
		    	 emp.setEmpId(resOne.getInt(1));
		    	 emp.seteName(resOne.getString(2));
		    	 emp.setEmpSalary(resOne.getLong(3));
//		    	 emp.setDate((LocalDate.resOne.getDate(4)));
		    	 emp.setPhoneNo(resOne.getString(4));
		    	 emp.seteMail(resOne.getString(5));
		    	 
		    	 myList.add(emp);
				
			}
			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("problem in view");
		}
		
		finally {
			try {
				pstm.close();
				con.close();
			}
			catch (SQLException e) {
				System.out.println("not able to close the connection");
				e.printStackTrace();
			}
		}
		
		return myList;
	}
		
	@Override
	public Employee searchEmployee(int id) {
		Employee emp = null;
		try 
		{
			con = DbUtil.getConnection();
		} 
		catch (EmployeeException e) 
		{
			System.out.println("Something went wrong please try again");
			e.printStackTrace();
		}
		String queryfour = "Select empid , ename,salary , phonenumber , email from employeedb where empid =? ";
				try 
				{
					pstm = con.prepareStatement(queryfour);
					pstm.setInt(1, id);
					ResultSet res4 = pstm.executeQuery();
				while(res4.next()){	
					emp = new Employee();
//					emp.setEmpId(res4.getInt(1));
			    	 emp.setEmpId(res4.getInt(1));
			    	 emp.seteName(res4.getString(2));
			    	 emp.setEmpSalary(res4.getLong(3));
//			    	 emp.setDateOfJoining(resOne.getString(4));
			    	 emp.setPhoneNo(res4.getString(4));
			    	 emp.seteMail(res4.getString(5));
				 } 
				}
				catch (SQLException e) {
					System.out.println("Emp id not found ...please try again");
					e.printStackTrace();
				}
				
				finally {
					try {
						pstm.close();
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				return emp;
		
	}
	
		
		
	

	public static int  getEmpId() {
		int empId= 0 ;
	   try {
		con = DbUtil.getConnection();
			String querytwo = "select emp_id.nextval from dual";
			pstm = con.prepareStatement(querytwo);
			ResultSet res = pstm.executeQuery();
			while(res.next())
			{
				empId = res.getInt(1);
			}
	} catch (EmployeeException | SQLException e) {
		System.out.println("problem in generating id");
		e.printStackTrace();
	}
	   return empId;
	
	}

	@Override
	public int updateEmployee(Employee emp, int empid) {
		int status = 0;
		try {
			con = DbUtil.getConnection();
			String Queryfive = "update  employeedb set ename = ? where empid = ? ";
			pstm = con.prepareStatement(Queryfive);
			pstm.setString(1, emp.geteName());
			pstm.setInt(2  , empid);
			
			 status = pstm.executeUpdate();
			
		} 
		catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}

	





	
	
	

}
