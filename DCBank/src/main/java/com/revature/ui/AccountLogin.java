package com.revature.ui;

import com.revature.model.Account;

public class AccountLogin implements UIInterface {
	

	public void display(Account account) {
		int choice = 0;
		do {
			System.out.println("=================       " + account.getFirstName() + " " + account.getLastName() + "           =================");
			System.out.println("                  < 2. See Account Balance >");
			System.out.println("                  < 3. Deposite Money >");
			System.out.println("                  < 4. Withdrawl Money >");
			System.out.println("                  < 5. See Transactions >");
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
				System.out.println("Account holder: " + account.getFirstName() + " " + account.getLastName());
				System.out.println("Current Balance: " + account.getBalance());
				System.out.println("============================================================");
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				System.out.println("                       Invalid Choice");
				break;
			}

		} while (choice == 1);
	}
}
