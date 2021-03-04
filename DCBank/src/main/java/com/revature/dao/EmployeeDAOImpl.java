package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public Employee getEmployeeByCode(String emC, String password, Connection con) throws SQLException {
		Employee user = null;
		
		String sql = "SELECT * FROM revature_bank.employees WHERE em_code = ? AND em_password = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, emC);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			int id = rs.getInt("em_ID");
			//emC goes here
			//password goes here
			String first = rs.getString("first_name");
			String last = rs.getString("last_name");
			
			user = new Employee(id, emC, password, first, last);
		}
		return user;
	}

}
