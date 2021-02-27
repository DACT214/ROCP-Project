package com.revature.menu;

import java.sql.SQLException;

import com.revature.exception.AccountNotFoundException;
import com.revature.model.Account;
import com.revature.service.AccountService;
import com.revature.ui.AccountLogin;

public class AccountsMenu implements Menu {

	public AccountService accountService;
	public AccountLogin accountLogin;

	public AccountsMenu() {
		this.accountService = new AccountService();
		this.accountLogin = new AccountLogin();
	}

	@Override
	public void display() {

		int choice = 0;
		do {
			System.out.println("=================       Account Menu       =================");
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
				String un = getUsernameInput();
				String pw = getPasswordInput();

				try {
					Account account = accountService.getAccountByUsername(un, pw);

					System.out.println("============================================================");
//					System.out.println("Account ID: " + account.getAccID());
//					System.out.println("Account Username: " + account.getUsername());
//					System.out.println("Account holder: " + account.getFirstName() + " " + account.getLastName());
//					System.out.println("Current Balance: " + account.getBalance());
					System.out.println("============================================================");

					accountLogin.display(account);

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

	private String getUsernameInput() {
		System.out.println("Enter your username: ");
		String input = Menu.sc.nextLine().trim();

		return input;
	}

	private String getPasswordInput() {
		System.out.println("Enter your password: ");
		String input = Menu.sc.nextLine().trim();

		return input;
	}

}
