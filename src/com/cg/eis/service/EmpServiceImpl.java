package com.cg.eis.service;

import java.util.List;
import java.util.regex.Pattern;

import com.cg.eis.beans.Employee;
import com.cg.eis.dao.EmpDaoImpl;
import com.cg.eis.dao.IEmpDao;
import com.cg.eis.exception.EmployeeException;

public class EmpServiceImpl implements IEmpService 
{
	IEmpDao empDao = new EmpDaoImpl();

	@Override
	public int addEmployee(Employee emp) throws EmployeeException {
		
		return empDao.addEmployee(emp);
	}

	@Override
	public List<Employee> viewAllemployee() throws EmployeeException {
		// TODO Auto-generated method stub
		return empDao.viewAllemployee();
	}

	@Override
	public Employee searchEmployee(int id) {
		// TODO Auto-generated method stub
		return empDao.searchEmployee(id);
	}

	@Override
	public int updateEmployee(Employee emp , int empid ) {
		// TODO Auto-generated method stub
		return empDao.updateEmployee(emp, empid);
	}
	
	
	public static boolean validateEname(String pattern , String ename) throws EmployeeException
	{
		boolean validation = Pattern.matches(pattern , ename);
		while(!validation)
		{
		 throw new EmployeeException("First");
		}
		
		return validation;
		
	}
	
	

}
