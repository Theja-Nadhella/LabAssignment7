package com.cg.eis.service;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.cg.eis.bean.Employee;
public class EmployeeService implements IEmployeeService {
	private Map<Long, Employee> employeeRepository;

	/**
	 * Create a new service.
	 */
	public EmployeeService() {
		employeeRepository = new HashMap<Long, Employee>();
	}

	@Override
	public void addEmployee(Employee emp) {
		employeeRepository.put(emp.getId(), emp);
		System.out.println("Employee successfully added.");

	}

	@Override
	public String findInsuranceScheme(Employee emp) {
		if (emp.getSalary() > 5000 && emp.getSalary() < 20000 && emp.getDesignation().equals("System Associate")) {
			return "Scheme C";
		} else if (emp.getSalary() >= 20000 && emp.getSalary() < 40000 && emp.getDesignation().equals("Programmer")) {
			return "Scheme B";
		} else if (emp.getSalary() >= 40000 && emp.getDesignation().equals("Manager")) {
			return "Scheme A";
		} else if (emp.getSalary() < 5000 && emp.getDesignation().equals("Clerk")) {
			return "No Scheme";
		}
		return "No Scheme";

	}

	@Override
	public void displayEmployeeDetails(String insuranceScheme) {
		employeeRepository.forEach((Long id, Employee e) -> {
			if (e.getInsuranceScheme().equals(insuranceScheme)) {
				System.out.println(e);
			}
		});

	}

	@Override
	public boolean deleteEmployee(long employeeId) {
		Set<Long> employeeIds = employeeRepository.keySet();
		for (Long l : employeeIds) {
			if (l == employeeId) {
				employeeRepository.remove(l);
				return true;
			}
		}
		return false;
	}
}
