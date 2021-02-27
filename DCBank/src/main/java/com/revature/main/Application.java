package com.revature.main;


import java.sql.Connection;
import java.sql.SQLException;

import com.revature.menu.Menu;
import com.revature.menu.mainMenu;
import com.revature.util.connectionUtil;


public class Application {
	public static void main(String[] args) throws SQLException {
		
	Menu mainMenu = new mainMenu();
		
	mainMenu.display();

	
	Connection con = connectionUtil.getConnection();
System.out.println(con.hashCode());
		
		
		

		Menu.sc.close();
		System.out.println("Bye, see you next time.");
	}
}
