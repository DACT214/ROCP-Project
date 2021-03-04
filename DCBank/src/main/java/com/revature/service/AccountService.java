package com.revature.service;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.exception.AccountNotFoundException;
import com.revature.model.Account;
import com.revature.util.connectionUtil;

public class AccountService {

	public AccountDAO accountDAO;

	public AccountService() {
		this.accountDAO = new AccountDAOImpl();

	}

	public Account getAccountByUsername(String username, String password) throws AccountNotFoundException, SQLException {
		try (Connection con = connectionUtil.getConnection()) {
			Account user;

			user = accountDAO.getAccountByUsername(username, password, con);

			if (user == null) {
				System.out.println(new AccountNotFoundException("username or password do not match or does not exist"));

			}

			return user;
		}

	}

	public ArrayList<Account> getAllPendingAccounts() throws SQLException {
		try (Connection con = connectionUtil.getConnection()) {
			ArrayList<Account> user;

			user = accountDAO.getAllPendingAccounts(con);

			if (user == null) {
				System.out.println(new SQLException().fillInStackTrace());
			}

			return user;

		}

	}

	public Account acceptPendingAccount(String id) throws AccountNotFoundException, SQLException {
		try (Connection con = connectionUtil.getConnection()) {
			Account user;
			user = accountDAO.acceptPendingAccount(id, con);
			System.out.println("Database updated successfully ");
			if (user == null) {
				System.out.println(new SQLException().fillInStackTrace());
			}
			return user;
		}

	}

	public void denyPendingAccount(String id) throws AccountNotFoundException, SQLException {
		try (Connection con = connectionUtil.getConnection()) {
		
			accountDAO.denyPendingAccount(id, con);
			
			
		}
	}

	public Account getSelectedAccountByID(String id) throws AccountNotFoundException, SQLException {
		try (Connection con = connectionUtil.getConnection()) {
			Account user;

			user = accountDAO.getSelectedAccountByID(id, con);

			if (user == null) {
				System.out.println(new AccountNotFoundException("Account does not exist"));

			}

			return user;
		}
	}
	
	public Account getSelectedAccountByUsername(String username) throws AccountNotFoundException, SQLException, NullPointerException {
		try (Connection con = connectionUtil.getConnection()) {
			Account user = null;

			user = accountDAO.getSelectedAccountByUsername(username, con);

//			if (user == null) {
//				System.out.println(new AccountNotFoundException("Account does not exist"));
//			}

			return user;
		}
	}
	
	public Account createNewAccount(String username, String password, String firstName, String lastName, double balance) throws SQLException{
		try (Connection con = connectionUtil.getConnection()) {
			Account user;
			user = accountDAO.createNewAccount(username, password, firstName, lastName, balance, con);
			System.out.println(" Your Account Request has been sent in successfully");
			if (user == null) {
				System.out.println(new SQLException().fillInStackTrace());
			}
			return user;
		}
	}

	public Account postTransaction(String username, double deposit) throws SQLException{
		try(Connection con = connectionUtil.getConnection()){
			Account account;
			account = accountDAO.postTransaction(username, deposit, con);
			
			if (account == null) {
				System.out.println(new SQLException().fillInStackTrace());
			}
			
			
			return account;
			
		}
	}

	public ArrayList<Account> getAllAcceptedAccounts() throws SQLException {
		try (Connection con = connectionUtil.getConnection()) {
			ArrayList<Account> user;

			user = accountDAO.getAllAcceptedAccounts(con);

			if (user == null) {
				System.out.println(new SQLException().fillInStackTrace());
			}

			return user;

		}

	}
	
	public ArrayList<Account> getAllAccounts() throws SQLException {
		try (Connection con = connectionUtil.getConnection()) {
			ArrayList<Account> user;

			user = accountDAO.getAllAccounts(con);

			if (user == null) {
				System.out.println(new SQLException().fillInStackTrace());
			}

			return user;

		}

	}

	public Account postTransaction(String username, String username2, double transfer) throws AccountNotFoundException, SQLException {
		try(Connection con = connectionUtil.getConnection()){
			Account account;
			account = accountDAO.postTransfer(username, username2, transfer, con);
			
			if (account == null) {
				System.out.println(new SQLException().fillInStackTrace());
			}
			
			
			return account;
			
		}
	}
}
