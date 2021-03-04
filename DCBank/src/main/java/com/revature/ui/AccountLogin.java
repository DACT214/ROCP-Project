package com.revature.ui;

import java.sql.SQLException;

import com.revature.exception.AccountNotFoundException;
import com.revature.model.Account;
import com.revature.service.AccountService;

public class AccountLogin implements UIInterface {
	
	
	AccountService accountService;
	DepositUI depositUI;
	WithdrawlUI withdrawlUI;
	TransferUI transferUI;
	
	public AccountLogin(){
		this.accountService = new AccountService();
		this.depositUI = new DepositUI();
		this.withdrawlUI = new WithdrawlUI();
		this.transferUI = new TransferUI();
	}

	public void displayUI(Account account) {
		int choice = 0;
		do {
			
			try {
				account = accountService.getSelectedAccountByUsername(account.getUsername());
			} catch (NullPointerException | AccountNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println("=================       " + account.getFirstName() + " " + account.getLastName() + "           =================");
			System.out.println("                  < 2. See Account Balance >");
			System.out.println("                  < 3. Deposite Money >");
			System.out.println("                  < 4. Withdrawl Money >");
			System.out.println("                  < 5. Transfer Money >");
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
				System.out.println("=================       " + account.getFirstName() + " " + account.getLastName() + "           =================");
				System.out.println("Account ID: " + account.getAccID());
				System.out.println("Current Balance: " + account.getBalance());
				System.out.println("============================================================");
				break;
			case 3:
				depositUI.displayUI(account);
				break;
			case 4:
				withdrawlUI.displayUI(account);
				break;
			case 5:
				transferUI.displayUI(account);
				break;
			default:
				System.out.println("                       Invalid Choice");
				break;
			}

		} while (choice != 1);
	}
	
	
}
