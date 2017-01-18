package com.cg.eis.beans;

import java.time.LocalDate;

public class Employee {

	private int empId;
	private String eName;
	private long empSalary;
	private LocalDate dateOfJoining;
	private String phoneNo;
	private String eMail;
	
	public Employee(String eName, long empSalary, LocalDate dateOfJoining, String phoneNo, String eMail) {
		super();
		this.empId = empId;
		this.eName = eName;
		this.empSalary = empSalary;
		this.dateOfJoining = dateOfJoining;
		this.phoneNo = phoneNo;
		this.eMail = eMail;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", eName=" + eName + ", empSalary=" + empSalary + ", dateOfJoining="
				+ dateOfJoining + ", phoneNo=" + phoneNo + ", eMail=" + eMail + "]";
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public long getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(long empSalary) {
		this.empSalary = empSalary;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	
}
