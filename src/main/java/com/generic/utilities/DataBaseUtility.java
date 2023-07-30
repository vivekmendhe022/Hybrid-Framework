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

	/**
	 * This method contains driver, register driver, get connection & return create
	 * statement.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Statement createStatement() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/intercon360", "root", "root");
		Statement statement = connection.createStatement();
		return statement;
	}

	/**
	 * This method will perform read query from database
	 * 
	 * @throws SQLException
	 */
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

	/**
	 * This method will perform insert query from database
	 * 
	 * @throws SQLException
	 */
	public void insertData() throws SQLException {
		Statement statement = createStatement();
		String query = "insert into user(first_name, surname, email, password, cpassword, gender, dob)"
				+ " values('Jona', 'Sonag', 'jona@gmail.com', '1223456', '1223456', 'female', '2023-07-02')";
		int create = statement.executeUpdate(query);
		if (create == 1) {
			System.out.println("Created");
		} else {
			System.out.println("Error");
		}
	}

	/**
	 * This method will perform update query from database
	 * 
	 * @throws SQLException
	 */
	public void updateData() throws SQLException {
		Statement statement = createStatement();
		String query = "update user set first_name = 'Rona' where userid = '14' ";
		int update = statement.executeUpdate(query);
		if (update == 1) {
			System.out.println("Update");
		} else {
			System.out.println("Error");
		}
	}

	/**
	 * This method will perform delete query from database
	 * 
	 * @throws SQLException
	 */
	public void deleteData() throws SQLException {
		Statement statement = createStatement();
		String query = "delete from user where userid = 14";
		int delete = statement.executeUpdate(query);
		if (delete == 1) {
			System.out.println("Delete");
		} else {
			System.out.println("Error");
		}
	}

	public static void main(String[] args) throws SQLException {
		DataBaseUtility d = new DataBaseUtility();
		d.insertData();
	}

}
