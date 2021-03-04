package com.revature.ui;

import java.sql.SQLException;
import java.util.InputMismatchException;

import org.apache.log4j.Logger;

import com.revature.menu.Menu;
import com.revature.model.Account;
import com.revature.service.AccountService;

public class WithdrawlUI implements UIInterface {

	private Logger log = Logger.getLogger(WithdrawlUI.class);
	AccountService accountService;
	
public WithdrawlUI() {
	this.accountService = new AccountService();
}
	
	@Override
	public void displayUI(Account account) {
		int choice = 0;
		do{
			System.out.println("=================       Withdrawl Menu       =================");
			System.out.println("                   < 2. Start a Withdrwal >");
			System.out.println("                        < 1. Cancel >");
			try {
				choice = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {}
			
			switch(choice){
			case 1:
				break;
			case 2:
				String username = account.getUsername();
				double deposit = getNewWithdrawl(account);
				
				try {
					account = accountService.postTransaction(username, deposit);
					log.info("user: "+ username +" ("+account.getFirstName()+" "+account.getLastName()+") WITHDRAWLED $"+(-deposit)+" from their account.");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("=================       " + account.getFirstName() + " " + account.getLastName() + "           =================");
				System.out.println("Account ID: " + account.getAccID());
				System.out.println("New Balance: " + account.getBalance());
				System.out.println("============================================================");
				
				
				break;
			default:
				System.out.println("Invalid choice, try again.");
				break;
			}
			
			
		}while(choice != 1);
		
	}
	
	private double getNewWithdrawl(Account account) {
		double input = 0;
		do {
		System.out.println("Enter how much you would like to Withdrawl: ");
		
		try {
		input = Menu.sc.nextDouble();
		Menu.sc.nextLine();
		}catch(InputMismatchException e) {
			System.out.println("Enter numbers and decimial point only");
		}
		if (input < 0) {
			System.out.println("Cannot process negative Withdrawl");
		} else if(account.getBalance()<input) {
			System.out.println("Cannot Withdrawl more money then you have in your account");
			input = -1;
		}
		}while(input < 0);

		return -input;
	}

	}


