package com.revature.ui;

import java.sql.SQLException;
import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.revature.exception.AccountNotFoundException;
import com.revature.menu.Menu;
import com.revature.model.Account;
import com.revature.service.AccountService;

public class TransferUI implements UIInterface {
	private Logger log = Logger.getLogger(TransferUI.class);
	AccountService accountService;
	
	public TransferUI() {
		this.accountService = new AccountService();
	}

	@Override
	public void displayUI(Account account) {
		int choice = 0;
		do{
			System.out.println("=================       Transfer Menu       =================");
			System.out.println("                   < 2. Start a Transfer >");
			System.out.println("                        < 1. Cancel >");
			try {
				choice = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {}
			
			switch(choice){
			case 1:
				break;
			case 2:
				String username = account.getUsername();
				String username2 = getRecipiantUsername();
				double transfer = getNewTransfer(account);
				
				try {
					Account account2 = accountService.postTransaction(username, username2, transfer);
					
					log.info("user: "+ username +" ("+account.getFirstName()+" "+account.getLastName()+") TRANSFERED $"+transfer
							+" TO " + username2 +" ("+account2.getFirstName()+" "+account2.getLastName()+")");
					
				System.out.println("=================       " + account.getFirstName() + " " + account.getLastName() + "           =================");
				System.out.println("user: "+ username +" ("+account.getFirstName()+" "+account.getLastName()+") TRANSFERED $"+transfer
						+" TO " + username2 +" ("+account2.getFirstName()+" "+account2.getLastName()+")");
				System.out.println("============================================================");
				
				} catch (AccountNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				
				
				
				break;
			default:
				System.out.println("Invalid choice, try again.");
				break;
			}
			
			
		}while(choice != 1);
		
	}
	
	private String getRecipiantUsername() {
		System.out.println("Enter the username of the account you want to transfer to: ");
		String input = Menu.sc.nextLine().trim();

		return input;
	}
	
	private double getNewTransfer(Account account) {
		double input = 0;
		do {
		System.out.println("Enter how much you would like to Transfer: ");
		
		try {
		input = Menu.sc.nextDouble();
		Menu.sc.nextLine();
		}catch(InputMismatchException e) {
			System.out.println("Enter numbers and decimial point only");
		}
		if (input < 0) {
			System.out.println("Cannot process negative Transfer");
		} else if(account.getBalance()<input) {
			System.out.println("Cannot Transfer more money then you have in your account");
			input = -1;
		}
		}while(input < 0);

		return input;
	}

}
