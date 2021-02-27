package com.revature.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.model.Account;

public interface AccountDAO {

	Account getAccountByUsername(String username, String password, Connection con) throws SQLException;
	
}
