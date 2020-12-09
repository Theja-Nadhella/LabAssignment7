package com.cg.eis.pl;
import java.util.Scanner;

import com.cg.eis.service.EmployeeService;
import com.cg.eis.bean.Employee;
public class User {
	public static void showServiceMenu() {
		System.out.println("****Welcome to employee services****");
		System.out.println("1. Add an employee");
		System.out.println("2. Display employee details based on insurance scheme");
		System.out.println("3. Delete an employee");
		System.out.println("4.Exit");
	}

	public static Employee takeDetails(Scanner in) {

		System.out.print("Enter the id of the employee: ");
		long id = in.nextLong();
		in.nextLine();
		System.out.print("Enter the employee name: ");
		String name = in.nextLine();
		System.out.print("Enter the employee salary: ");
		Double salary = in.nextDouble();
		in.nextLine();
		System.out.print("Enter the employee designation: ");
		String designation = in.nextLine();
		Employee emp = new Employee(id, name, salary, designation);
		return emp;

	}

	public static void main(String[] args) {

		EmployeeService empService = new EmployeeService();

		Scanner input = new Scanner(System.in);
		int choice = 0;
		do {

			showServiceMenu();

			System.out.print("Enter your choice: ");
			choice = input.nextInt();
			input.nextLine();

			switch (choice) {

			case 1:

				Employee emp = takeDetails(input);

				String insuranceScheme = empService.findInsuranceScheme(emp);

				emp.setInsuranceScheme(insuranceScheme);

				empService.addEmployee(emp);
				break;

			case 2:

				System.out.println("Enter the insurance scheme: ");
				String scheme = input.nextLine();

				empService.displayEmployeeDetails(scheme);
				break;

			case 3:

				System.out.println("Enter the id of the employee: ");
				long employeeId = input.nextLong();
				input.nextLine();

				if (empService.deleteEmployee(employeeId)) {
					System.out.println("Employee successfully deleted");
				}

				else {
					System.out.println("Employee not present with given id");
				}
				break;
			}
		} while (choice != 4);
		input.close();
	}
}
