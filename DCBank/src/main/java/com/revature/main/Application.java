package com.revature.main;

import com.revature.menu.Menu;
import com.revature.menu.mainMenu;

public class Application {
	public static void main(String[] args) {
		
		Menu mainMenu = new mainMenu();
		
		mainMenu.display();

		

		Menu.sc.close();
		System.out.println("Bye, see you next time.");
	}
}
