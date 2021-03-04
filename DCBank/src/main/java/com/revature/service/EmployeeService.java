package com.revature.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.EmployeeDAO;
import com.revature.dao.EmployeeDAOImpl;
import com.revature.exception.AccountNotFoundException;
import com.revature.model.Employee;
import com.revature.util.connectionUtil;

public class EmployeeService {

	public EmployeeDAO employeeDAO;

	public EmployeeService() {
		this.employeeDAO = new EmployeeDAOImpl();
	}

	public Employee getEmployeeByCode(String emC, String password) throws SQLException, AccountNotFoundException {
		try (Connection con = connectionUtil.getConnection()) {
			Employee user;

			user = employeeDAO.getEmployeeByCode(emC, password, con);

			if (user == null) {
				System.out.println(
						new AccountNotFoundException("employee Code or password do not match or does not exist"));
			}

			return user;
		}

	}

}
