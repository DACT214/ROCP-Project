package com.revature.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.model.Employee;

public interface EmployeeDAO {
	 
	Employee getEmployeeByCode(String emC, String password, Connection con) throws SQLException;
}
