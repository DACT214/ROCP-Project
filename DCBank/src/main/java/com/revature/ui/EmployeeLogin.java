package com.revature.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import com.revature.model.Employee;
import com.revature.service.AccountService;

public class EmployeeLogin implements EIInterface{

	AccountService accountService;
	EPermisionsUI ePermisionUI;
	
	public EmployeeLogin() {
		accountService = new AccountService();
		ePermisionUI = new EPermisionsUI();
	}
	
	
	@Override
	public void display(Employee account) {
		int choice = 0;
		do {
			System.out.println("=================       " + account.getFirstName() + " " + account.getLastName() + "           =================");
			System.out.println("                  < 2. See Pending Accounts >");
			System.out.println("                  < 3. See Accepted Accounts >");
			System.out.println("                  < 4. See All Accounts >");
			System.out.println("                  < 5. See All Transactions >");
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
				try {
					System.out.println("=============================================================================================");
					accountService.getAllPendingAccounts().forEach(t -> System.out.println(t));
					System.out.println("=============================================================================================");
					ePermisionUI.display();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					System.out.println("=============================================================================================");
					accountService.getAllAcceptedAccounts().forEach(t -> System.out.println(t));
					System.out.println("=============================================================================================");
					ePermisionUI.display();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					System.out.println("=============================================================================================");
					accountService.getAllAccounts().forEach(t -> System.out.println(t));
					System.out.println("=============================================================================================");
					ePermisionUI.display();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				System.out.println("=============================================================================================");
				try (BufferedReader br = new BufferedReader(new FileReader("application.log"))) {
					   String line;
					   while ((line = br.readLine()) != null) {
					       System.out.println(line);
					   }
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				System.out.println("=============================================================================================");
				break;
			default:
				System.out.println("Invalid choice");
			}
			
		}while(choice != 1);
		
	}


	

}
