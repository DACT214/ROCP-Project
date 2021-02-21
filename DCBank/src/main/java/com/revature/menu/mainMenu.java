package com.revature.menu;

public class mainMenu implements Menu{

	int choice = 0;
	@Override
	public void display() {
	do {
		System.out.println("================= Revature Bank: DC Branch =================");
		System.out.println("< 1: Exit > < 2: Account > < 3: Transactions >");
		System.out.println("============================================================");

		try {
			choice = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
		}
		switch (choice) {
		case 1:
			break;
		case 2:
			Menu accountsMenu = new accountsMenu();
			accountsMenu.display();
			break;
		case 3:
			Menu transactionMenu = new transactionMenu();
			transactionMenu.display();
			break;
		default:
			System.out.println("invalide choice");
		}
	}while (choice != 1);
}
	
	
}
