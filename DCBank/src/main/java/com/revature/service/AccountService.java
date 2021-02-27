package com.revature.service;

import java.sql.Connection;
import java.sql.SQLException;

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
	
	public Account getAccountByUsername (String username, String password) throws AccountNotFoundException, SQLException {
		try (Connection con = connectionUtil.getConnection()){ 
			Account user;
			
			user = accountDAO.getAccountByUsername(username, password, con);
			
			if (user == null) {
				System.out.println(new AccountNotFoundException("username or password do not match or does not exist"));
				
			} 
			
		
			return user;
		}
		
	}
	
	
}
