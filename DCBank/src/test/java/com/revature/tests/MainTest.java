package com.revature.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.revature.model.Account;

public class MainTest {
	public Account account;
	public Account account2;
	
	@Before
	public void setUp() {
		this.account = new Account();
		this.account2 = new Account();
	}
	
	@Test
	public void witdrawlTest() {
		account.setBalance(500);

		double withdrawl = 900;
		
		assertFalse(account.getBalance()>=withdrawl && withdrawl>=0);
	}
	
	@Test
	public void depositTest() {
		account.setBalance(10);
		
		double deposit = 100;
		
		assertTrue(deposit>=0);
	}
	
	@Test
	public void userExistTest() {
		account2.setUsername("bob101");
		
		assertTrue(account2.getUsername() != null);
	}
	
	@Test
	public void userNonExistTest() {
		assertFalse(account.getUsername() != null);
	}
	
	@Test
	public void redundantUser() {
		account.setUsername("bob101");
		
		account2.setUsername("bob101");
		
		
		assertTrue(account.equals(account2));
	}
	
	@Test
	public void logInTest() {
		
		account.setUsername("test");
		account.setPassword("abc123");
		
		String usernameInput = "test";
		String passwordInput = "abc123";		
		
		assertTrue(account.getUsername()== usernameInput && account.getPassword() == passwordInput);
	}
	
	@Test
	public void transferTest() {
		account.setBalance(500);
		double balance1 = account.getBalance();

		account2.setBalance(200);
		double balance2 = account2.getBalance();
		
		double transferMoney = 100;
		
		account.setBalance(account.getBalance() - transferMoney);
	
		account2.setBalance(account2.getBalance() + transferMoney);
		
		assertTrue(balance1 >= account.getBalance() && balance2 <= account2.getBalance());
	}
	
	@Test
	public void test() {
		
	}
}