package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.model.Account;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public Account getAccountByUsername(String username, String password, Connection con) throws SQLException {
		Account user = null;

		String sql = "SELECT * FROM revature_bank.accounts WHERE username = ? AND \"password\" = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, username);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			String id = rs.getString("account_id");
			// username goes here
			// password goes here
			String first = rs.getString("first_name");
			String last = rs.getString("last_name");
			double balance = rs.getDouble("balance");
			String status = rs.getString("status");

			user = new Account(id, username, password, first, last, balance, status);
		}
		return user;

	}

	@Override
	public ArrayList<Account> getAllPendingAccounts(Connection con) throws SQLException {

		ArrayList<Account> user = new ArrayList<Account>();

		String sql = "SELECT account_id, username, first_name, last_name, balance, status FROM revature_bank.accounts WHERE status = 'pending'";
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Account newUser;
			String id = rs.getString("account_id");
			String username = rs.getString("username");
			
			String first = rs.getString("first_name");
			String last = rs.getString("last_name");
			double balance = rs.getDouble("balance");
			String status = rs.getString("status");
			newUser = new Account(id, username, first, last, balance, status);
			user.add(newUser);
		}
		return user;
	}

	@Override
	public Account acceptPendingAccount(String id, Connection con) throws SQLException {

		String sql = "UPDATE revature_bank.accounts SET status = 'accepted' WHERE account_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setInt(1, Integer.parseInt(id));
		 
		pstmt.executeUpdate();
		//=======================================================================
		Account user = null;

		String sql2 = "SELECT * FROM revature_bank.accounts WHERE account_id = ?";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);

		pstmt2.setInt(1, Integer.parseInt(id));
	

		ResultSet rs = pstmt2.executeQuery();

		if (rs.next()) {
			
			String username = rs.getString("username");
			String password = rs.getString("password");
			String first = rs.getString("first_name");
			String last = rs.getString("last_name");
			double balance = rs.getDouble("balance");
			String status = rs.getString("status");
		

			user = new Account(id, username, password, first, last, balance, status);
		}
		return user;
		 
		 
		 
	}

	@Override
	public void denyPendingAccount(String id, Connection con) throws SQLException {
		
		String sql3 = "SELECT username FROM revature_bank.accounts WHERE account_id = ?";
		PreparedStatement pstmt3 = con.prepareStatement(sql3);
		
		pstmt3.setInt(1, Integer.parseInt(id));
		
		ResultSet rs = pstmt3.executeQuery();
		
		if(rs.next() == true){
		//====================================================================
		String sql = "DELETE FROM revature_bank.transactions WHERE username = (SELECT username FROM revature_bank.accounts WHERE account_id = ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setInt(1, Integer.parseInt(id));
		 
		pstmt.executeUpdate();
		
		//=====================================================================
		String sql2 = "DELETE FROM revature_bank.accounts WHERE account_id = ?";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);

		pstmt2.setInt(1, Integer.parseInt(id));
		 
		pstmt2.executeUpdate();
		
		System.out.println("Database updated successfully ");
		} else {
			System.out.println("account you selected does not exist");
		}
	}

	@Override
	public Account getSelectedAccountByID(String id, Connection con) throws SQLException {
		Account user = null;
		
		String sql = "SELECT * FROM revature_bank.accounts WHERE account_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, Integer.parseInt(id));
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next() == true) {
			// id goes here
			String username = rs.getString("username");
			String password = rs.getString("password");
			String first = rs.getString("first_name");
			String last = rs.getString("last_name");
			double balance = rs.getDouble("balance");
			String status = rs.getString("status");

			user = new Account(id, username, password, first, last, balance, status);
		}
		return user;
		
	}

	@Override
	public Account getSelectedAccountByUsername(String username, Connection con) throws SQLException {
		Account user = null;
		
		String sql = "SELECT * FROM revature_bank.accounts WHERE username = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, username);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next() == true) {
			String id = rs.getString("account_id");
//			String username = rs.getString("username");
			String password = rs.getString("password");
			String first = rs.getString("first_name");
			String last = rs.getString("last_name");
			double balance = rs.getDouble("balance");
			String status = rs.getString("status");

			user = new Account(id, username, password, first, last, balance, status);
		}
		return user;
		
	}
	
	@Override
	public Account createNewAccount(String username, String password, String firstName, String lastName, double balance, Connection con) throws SQLException {
		String sql = "INSERT INTO revature_bank.accounts (username, password, first_name, last_name, balance) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, username);
		pstmt.setString(2, password);
		pstmt.setString(3, firstName);
		pstmt.setString(4, lastName);
		pstmt.setDouble(5, balance);
		
		pstmt.executeUpdate();
		//=======================================================================
		String sql2 = "SELECT * FROM revature_bank.accounts WHERE username = ?";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		
		pstmt2.setString(1, username);
		
		ResultSet rs = pstmt2.executeQuery();
		Account newUser = null;
		if(rs.next()) {
			
			String id = rs.getString("account_id");
			String un = rs.getString("username");
			String pw = rs.getString("password");
			String first = rs.getString("first_name");
			String last = rs.getString("last_name");
			double b = rs.getDouble("balance");
			String status = rs.getString("status");
			newUser = new Account(id, un, pw, first, last, b, status);
		}
		return newUser;
		
	}

	@Override
	public Account postTransaction(String username, double deposit, Connection con) throws SQLException {
		String sql = "UPDATE revature_bank.accounts SET balance = "
				+ "(SELECT balance FROM revature_bank.accounts WHERE username = ?) + ? "
				+ "WHERE username = ?";
		PreparedStatement pmtst = con.prepareStatement(sql);
		
		pmtst.setString(1, username);
		pmtst.setDouble(2, deposit);
		pmtst.setString(3, username);
		
		pmtst.executeUpdate();
		//==============================================================================================
		Account account = null;
		
		String sql2 = "SELECT * FROM revature_bank.accounts WHERE username = ?";
			PreparedStatement pmtst2 = con.prepareStatement(sql2);
			
			pmtst2.setString(1, username);
			
			ResultSet rs = pmtst2.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("account_id");
				// username goes here
				
				String first = rs.getString("first_name");
				String last = rs.getString("last_name");
				double balance = rs.getDouble("balance");
				String status = rs.getString("status");
				
				
				account = new Account(id, username, first, last, balance, status);
			}
		
		
		return account;
	}

	
	@Override
	public ArrayList<Account> getAllAcceptedAccounts(Connection con) throws SQLException {
		
		ArrayList<Account> user = new ArrayList<Account>();

		String sql = "SELECT account_id, username, first_name, last_name, balance, status FROM revature_bank.accounts WHERE status = 'accepted'";
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Account newUser;
			String id = rs.getString("account_id");
			String username = rs.getString("username");
			
			String first = rs.getString("first_name");
			String last = rs.getString("last_name");
			double balance = rs.getDouble("balance");
			String status = rs.getString("status");
			newUser = new Account(id, username, first, last, balance, status);
			user.add(newUser);
		}
		return user;
	}


	@Override
	public ArrayList<Account> getAllAccounts(Connection con) throws SQLException {
		ArrayList<Account> user = new ArrayList<Account>();

		String sql = "SELECT account_id, username, first_name, last_name, balance, status FROM revature_bank.accounts";
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Account newUser;
			String id = rs.getString("account_id");
			String username = rs.getString("username");
			
			String first = rs.getString("first_name");
			String last = rs.getString("last_name");
			double balance = rs.getDouble("balance");
			String status = rs.getString("status");
			newUser = new Account(id, username, first, last, balance, status);
			user.add(newUser);
		}
		return user;
	}

	
	@Override
	public Account postTransfer(String username, String username2, double transfer, Connection con) throws SQLException {
		// Transfer to statement
		String sql = "UPDATE revature_bank.accounts SET balance = "
				+ "(SELECT balance FROM revature_bank.accounts WHERE username = ?) + ? "
				+ "WHERE username = ?";
		PreparedStatement pmtst = con.prepareStatement(sql);
		
		pmtst.setString(1, username2);
		pmtst.setDouble(2, transfer);
		pmtst.setString(3, username2);
		
		pmtst.executeUpdate();
		//Transfer from statement ======================================================================
		String sql3 = "UPDATE revature_bank.accounts SET balance = "
				+ "(SELECT balance FROM revature_bank.accounts WHERE username = ?) + ? "
				+ "WHERE username = ?";
		PreparedStatement pmtst3 = con.prepareStatement(sql3);
		
		pmtst3.setString(1, username);
		pmtst3.setDouble(2, (-transfer));
		pmtst3.setString(3, username);
		
		pmtst3.executeUpdate();
		
		//Transfer Log =======================================================================
		Account account = null;
		
		String sql2 = "SELECT * FROM revature_bank.accounts WHERE username = ?";
			PreparedStatement pmtst2 = con.prepareStatement(sql2);
			
			pmtst2.setString(1, username2);
			
			ResultSet rs = pmtst2.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("account_id");
				// username goes here
				String first = rs.getString("first_name");
				String last = rs.getString("last_name");
				double balance = rs.getDouble("balance");
				String status = rs.getString("status");
				
				
				account = new Account(id, username, first, last, balance, status);
			}
		
		
		return account;
	}

	
}
