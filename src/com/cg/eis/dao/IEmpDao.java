package com.cg.eis.dao;



import java.util.List;

import com.cg.eis.beans.Employee;
import com.cg.eis.exception.EmployeeException;

public interface IEmpDao
{
	public int addEmployee(Employee emp) throws EmployeeException;
	public List<Employee> viewAllemployee() throws EmployeeException;
	public Employee  searchEmployee(int id); 
	public int updateEmployee(Employee emp , int empid);

}
