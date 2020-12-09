package com.cg.eis.service;
import com.cg.eis.bean.Employee;
public interface IEmployeeService {
	public void addEmployee(Employee emp);

	public String findInsuranceScheme(Employee emp);

	public void displayEmployeeDetails(String insuranceScheme);

	public boolean deleteEmployee(long employeeId);
}
