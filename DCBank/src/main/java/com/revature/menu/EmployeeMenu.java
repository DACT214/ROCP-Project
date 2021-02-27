package com.revature.menu;

import java.sql.SQLException;

import com.revature.exception.AccountNotFoundException;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class EmployeeMenu implements Menu {

	public EmployeeService employeeService;
	
	public EmployeeMenu () {
		this.employeeService = new EmployeeService();
	}
	
	@Override
	public void display() {
		int choice = 0;
		do {
			System.out.println("=================       Employee Menu       =================");
			System.out.println("                    	< 2. Login >");
			System.out.println("                        < 3. Sign Up >");
			System.out.println("                        < 1. Back >");
			System.out.println("============================================================");

			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
			}
			switch (choice) {
			case 1:
				break;

			case 2:
				String emC = getEmCInput();
				String pw = getPasswordInput();

				try {

					Employee account = employeeService.getEmployeeByCode(emC, pw);

					System.out.println("============================================================");
					System.out.println("Account ID: " + account.getEmID());
					System.out.println("Account Username: " + account.getEmC());
					System.out.println("Account holder: " + account.getFirstName() + " " + account.getLastName());
					System.out.println("============================================================");

				} catch (SQLException | NullPointerException | AccountNotFoundException e) {
					System.out.println();
					System.out.println("             Try again or create an account.");
					System.out.println();
				}

				break;

			default:
				System.out.println("                       Invalid Choice");
				break;
			}
		} while (choice != 1);

	}

	private String getEmCInput() {
		System.out.println("Enter your Employee Code: ");
		String input = Menu.sc.nextLine().trim();

		return input;
	}

	private String getPasswordInput() {
		System.out.println("Enter your password: ");
		String input = Menu.sc.nextLine().trim();

		return input;
	}

}