package com.revature.menu;

public class mainMenu implements Menu{

	int choice = 0;
	@Override
	public void display() {
	do {
		System.out.println("================= Revature Bank: DC Branch =================");
		System.out.println("                  < 2: Your Account >");
		System.out.println("                    < 3: Employees >");
		System.out.println("                      < 1: Exit >");
		System.out.println("============================================================");

		try {
			choice = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
		}
		switch (choice) {
		case 1:
			break;
		case 2:
			Menu accountsMenu = new AccountsMenu();
			accountsMenu.display();
			break;
		case 3:
			Menu EmployeeMenu = new EmployeeMenu();
			EmployeeMenu.display();
			break;
		default:
			System.out.println("invalide choice");
		}
	}while (choice != 1);
}
	
	
}
