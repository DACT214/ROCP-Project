package com.revature.ui;

import java.util.Scanner;

import com.revature.model.Account;

public interface UIInterface {
	public static final Scanner sc = new Scanner(System.in);
	
	void displayUI(Account account);

}
