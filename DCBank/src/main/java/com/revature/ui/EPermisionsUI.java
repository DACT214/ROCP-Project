package com.revature.ui;

import java.sql.SQLException;

import com.revature.exception.AccountNotFoundException;
import com.revature.menu.Menu;
import com.revature.model.Account;
import com.revature.service.AccountService;

public class EPermisionsUI implements Menu{

	AccountService accountService;
	DenyAccountCheck denyAccountCheck;
	
	public EPermisionsUI() {
		this.accountService = new AccountService();
		this.denyAccountCheck = new DenyAccountCheck();
	}
	
	
	@Override
	public void display() {
		int choice = 0;
		do {
			System.out.println("=================       What would you like to do?         =================");
			System.out.println("                  < 2. Accept an Account Request? >");
			System.out.println("                  < 3. Deny an Account Request? >");
			System.out.println("                        < 1. Back >");
			System.out.println("============================================================");
			

			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
			}
			String id;
			switch (choice) {
			case 1:
				break;
			case 2: 
				 id = getIDInput();
				
				try {
					System.out.println(accountService.acceptPendingAccount(id));
				} catch (AccountNotFoundException | SQLException e) {
					e.fillInStackTrace();
				}
				break;
			case 3:
				 id = getIDInput();
				try {
					Account account = accountService.getSelectedAccountByID(id);
					System.out.println("====================== SELECTED ACCOUNT ========================");
					System.out.println("Account ID: " + account.getAccID());
					System.out.println("Account Username: " + account.getUsername());
					System.out.println("Account holder: " + account.getFirstName() + " " + account.getLastName());
					System.out.println("Current Balance: " + account.getBalance());
					System.out.println("============================================================");
					
					denyAccountCheck.displayUI(account);
					
				}catch (AccountNotFoundException | SQLException e) {
					e.fillInStackTrace();
				}
				break;
			default:
				System.out.println("Invalid choice");
			}
			
		}while(choice != 1);
		
	}
	private String getIDInput() {
		System.out.println("Enter an Account ID to accept their request");
		String input = sc.nextLine().trim();

		return input;
	}
}
