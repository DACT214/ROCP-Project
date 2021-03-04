package com.revature.ui;

import java.sql.SQLException;
import java.util.InputMismatchException;

import com.revature.exception.AccountNotFoundException;
import com.revature.menu.Menu;
import com.revature.service.AccountService;

public class AccountSignUp implements Menu {

	AccountService accountService;
	
	public AccountSignUp() {
		this.accountService = new AccountService();
	}
	
	@Override
	public void display() {
		
		String username = null;
		String password = null;
		String firstName = null;
		String lastName = null;
		double balance = 0;
		
		
		try {
			username = getNewUsername();
		} catch (NullPointerException | AccountNotFoundException | SQLException e) {}
	
		 password = getNewPassword();
		firstName = getNewFirst();
		lastName = getNewLast();
		balance = getNewBalance();
		
		
		try {
			accountService.createNewAccount(username, password, firstName, lastName, balance);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	private String getNewUsername() throws NullPointerException, AccountNotFoundException, SQLException {

		String input;
		boolean b = false;

		do {
			System.out.println("Enter a username you would like (20 characters MAX): ");
			input = Menu.sc.nextLine().trim();

			if (accountService.getSelectedAccountByUsername(input) == null) {
				b = true;

			} else {
				System.out.println("That username already exist. Try again");
			}

		} while (b == false);

		return input;
	}
	private String getNewPassword() {
		System.out.println("Enter a secure password (20 characters MAX):  ");
		String input = Menu.sc.nextLine().trim();

		return input;
	}
	private String getNewFirst() {
		System.out.println("Enter your First Name: ");
		String input = Menu.sc.nextLine().trim();

		return input;
	}
	private String getNewLast() {
		System.out.println("Enter your Last Name: ");
		String input = Menu.sc.nextLine().trim();

		return input;
	}
	private double getNewBalance() {
		System.out.println("Enter a starting Balance: ");
		
		double input = 0;
		try {
		input = Menu.sc.nextDouble();
		Menu.sc.nextLine();
		}catch(InputMismatchException e) {
			System.out.println("Enter numbers and decimial point only");
		}

		return input;
	}

}
