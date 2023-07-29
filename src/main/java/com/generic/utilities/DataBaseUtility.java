package com.generic.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains CRUD operations of MySQL database
 * 
 * @author Vivek M
 *
 */
public class DataBaseUtility {

	public Statement createStatement() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/intercon360", "root", "root");
		Statement statement = connection.createStatement();
		return statement;
	}

	public void readData() throws SQLException {
		Statement statement = createStatement();
		String query = "select * from user";
		ResultSet set = statement.executeQuery(query);
		while (set.next()) {
			int id = set.getInt(1);
			String first_name = set.getString(2);
			System.out.println(id + " : " + first_name);
		}
	}

	public static void main(String[] args) throws SQLException {
		DataBaseUtility d = new DataBaseUtility();
		d.readData();
	}

}
