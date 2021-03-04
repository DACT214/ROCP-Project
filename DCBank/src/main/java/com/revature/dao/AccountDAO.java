package com.revature.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.model.Account;

public interface AccountDAO {

	Account getAccountByUsername(String username, String password, Connection con) throws SQLException;
	
	ArrayList<Account> getAllPendingAccounts(Connection con) throws SQLException;
	
	Account acceptPendingAccount(String id, Connection con) throws SQLException;
	
	void denyPendingAccount(String id, Connection con) throws SQLException;
	
	Account getSelectedAccountByID(String id, Connection con) throws SQLException;
	
	Account getSelectedAccountByUsername(String username, Connection con) throws SQLException;
	
	Account createNewAccount(String username, String password, String firstName, String lastName, double balance, Connection con) throws SQLException;

	Account postTransaction(String username, double deposit, Connection con) throws SQLException;

	ArrayList<Account> getAllAcceptedAccounts(Connection con) throws SQLException;
	
	ArrayList<Account> getAllAccounts(Connection con) throws SQLException;

	Account postTransfer(String username, String username2, double transfer, Connection con) throws SQLException;
}
