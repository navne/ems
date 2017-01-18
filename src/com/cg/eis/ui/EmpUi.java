package com.cg.eis.ui;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import com.cg.eis.beans.Employee;
import com.cg.eis.exception.EmployeeException;
import com.cg.eis.service.EmpServiceImpl;
import com.cg.eis.service.IEmpService;

public class EmpUi {
	public static void main(String[] args)
	{
		Employee emp = null;
		int choice = 0 ;
		int id = 0;
		IEmpService empService = new EmpServiceImpl();
		do {

			prinUi();
			System.out.println("Enter the choice");
			Scanner scr = new Scanner(System.in);
			choice = scr.nextInt();

			switch (choice) {
			case 1:
				String pattern = "[A-Z][a-z]{2,19}";
				System.out.println("Enter Employee Name");
				String ename  = scr.next();
				try {
					EmpServiceImpl.validateEname(pattern, ename);
				} catch (EmployeeException e1) {
					System.out.println(e1.getMessage());
					break;
					//					e1.printStackTrace();
				}


				System.out.println("Enter employee salary");
				long salary = scr.nextInt();

				System.out.println("Enter employee date of joining (yyyy-mm-dd)");
				String doj = scr.next();
				LocalDate dof = LocalDate.parse(doj);


				System.out.println("Enter employee Mobile number ");
				String phoneNo = scr.next();

				pattern = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)* @[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";
				System.out.println("Enter Employee email ");
				String email = scr.next();
				try {
					EmpServiceImpl.validateEname(pattern, email);
				} catch (EmployeeException e1) {
					System.out.println(e1.getMessage());
					//					e1.printStackTrace();
				}


				emp =new Employee( ename, salary, dof, phoneNo, email);
				int msg = 0;
				try {
					msg = empService.addEmployee(emp);
					System.out.println("employee added successfulyy " +msg );
				}
				catch (EmployeeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				break;

			case 2:
				List<Employee> myLis = null;
				try
				{
					myLis=  empService.viewAllemployee();
				}

				catch (EmployeeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (Employee emp1 : myLis) {
					System.out.println("id is" +emp1.getEmpId());
					System.out.println("name is" +emp1.geteName());
					System.out.println("salary is" +emp1.getEmpSalary());
					System.out.println("phonr is" +emp1.geteMail());
					System.out.println("id is" +emp1.getPhoneNo());
				}

				break;

			case 3:
				System.out.println("Enter an Employee Id ");
				id = scr.nextInt();
				emp = new Employee();

				try {
					emp = empService.searchEmployee(id);
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(emp.getEmpId());
				System.out.println(emp.geteName());
				System.out.println(emp.getEmpSalary());
				System.out.println(emp.getPhoneNo());
				System.out.println(emp.geteMail());
				break;



			case 4:
				System.out.println("enter the employee id");
				id = scr.nextInt();

				emp = new Employee();

				try {
					emp = empService.searchEmployee(id);
				} catch (EmployeeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(emp.getEmpId());
				System.out.println(emp.geteName());
				System.out.println(emp.getEmpSalary());
				System.out.println(emp.getPhoneNo());
				System.out.println(emp.geteMail());

			}
		     	System.out.println("do yo want to update empname (y/n)");
	      		int msg = 0;
     			char c = scr.next().charAt(0);
    			String name = null;
    			if(c == 'y')
     			{
    				System.out.println("enter name");
     				name = scr.next(); 
     				emp.seteName(name);

        			msg = empService.updateEmployee(emp  , id);
     			}
      			
	     		if (msg == 1){
	     			System.out.println("updated succesfully");
	       		}
	     		
	 
        

		









		} while (choice != 6);

	}

	public static void prinUi(){
		System.out.println("1) Add an employee");
		System.out.println("2) view all Emplyee");
		System.out.println("3) search an employee");
		System.out.println("4) update an employee");
		System.out.println("5) remove an employee");
		System.out.println("6) Exit Application");
	}

}
