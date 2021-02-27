package com.revature.ui;

import com.revature.model.Employee;

public class EmployeeLogin implements EIInterface{

	@Override
	public void display(Employee account) {
		int choice = 0;
		do {
			System.out.println("=================       " + account.getFirstName() + " " + account.getLastName() + "           =================");
			System.out.println("                  < 2. See Pending Accounts >");
			System.out.println("                  < 3. See Active Accounts >");
			System.out.println("                  < 4. See Transactions >");
			System.out.println("                  < 5. See Transactions >");
			System.out.println("                        < 1. Back >");
			System.out.println("============================================================");
			
		}while(choice != 1);
		
	}

}
