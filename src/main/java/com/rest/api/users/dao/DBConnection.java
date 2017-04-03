package com.rest.api.users.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * This class DBConnection performs Database connection to the MySQL Databases used by the API
 * @author Neha Lall
 *
 */
public class DBConnection {
	private final String USER_DB_URL = "jdbc:sqlserver://localhost\\UserDB";
	private final String USER_ACCOUNTS_DB_URL = "jdbc:sqlserver://localhost\\UserAccountsDB";
	private final String USER = "myUser";
	private final String PASSWORD = "password";
	
	/*Method connect_to_UserDB is used to connect to the MySQL UserDB*/
	public Connection connect_to_UserDB(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(this.USER_DB_URL, this.USER, this.PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/*Method connect_to_UserAccountsDB is used to connect to the MySQL UserAccountsDB*/
	public Connection connect_to_UserAccountsDB(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(this.USER_ACCOUNTS_DB_URL, this.USER, this.PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/*Method disconnect is used to disconnect the Database*/
	public void disconnect(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
