package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.Account;

public class AccountDAOImpl implements AccountDAO{

	@Override
	public Account getAccountByUsername(String username, String password, Connection con) throws SQLException {
		Account user = null;
		
		String sql = "SELECT * FROM revature_bank.accounts WHERE username = ? AND \"password\" = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			int id= rs.getInt("account_id");
			//username goes here
			//password goes here
			String first= rs.getString("first_name");
			String last= rs.getString("last_name");
			double balance= rs.getDouble("balance");
			
		user = new Account(id, username, password, first, last, balance);
		}
		return user;
		
	}

}
