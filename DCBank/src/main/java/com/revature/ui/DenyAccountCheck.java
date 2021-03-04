package com.revature.ui;

import java.sql.SQLException;

import com.revature.exception.AccountNotFoundException;
import com.revature.model.Account;
import com.revature.service.AccountService;

public class DenyAccountCheck implements UIInterface{
AccountService accountService;

DenyAccountCheck(){
	this.accountService = new AccountService();
}

	@Override
	public void displayUI(Account account) {
		int choice = 0;
		do {
			System.out.println("=================  WARNING! denying an account request  =================");
			System.out.println("================= deletes the account from the database =================");
			System.out.println("=================             permenantly.              =================");
			System.out.println("                  < 2. Confirm deny Account Request >");
			System.out.println("                              < 1. Cancel >");
			System.out.println("============================================================");
			

			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
			}
			
			switch (choice) {
			case 1:
				break;
			case 2: 
				String id = account.getAccID();
				try {
					accountService.denyPendingAccount(id);
				}catch (AccountNotFoundException | SQLException e) {
					e.fillInStackTrace();
				}
				break;
			default:
				System.out.println("Invalid choice");
			}
			
		}while(choice != 1);
		
	}
	
}
