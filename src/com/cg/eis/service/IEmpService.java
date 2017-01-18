package com.cg.eis.service;

import java.util.List;

import com.cg.eis.beans.Employee;
import com.cg.eis.exception.EmployeeException;

public interface IEmpService
{
	public int addEmployee(Employee emp ) throws EmployeeException;
	public List<Employee> viewAllemployee() throws EmployeeException;
	public Employee searchEmployee(int id) throws EmployeeException; 
	public int updateEmployee(Employee emp , int empid);
		
	

	

}
