package com.rest.api.users.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * UserAccountDAO class is the DAO class for fetching the account status for a given user from UserAccountsDB
 * @author Neha Lall
 *
 */
public class UserAccountDAO {

	public String getUserAccountStatus(int user_id) throws SQLException{
		String select_query = "select account_status from UserAccountsDB.Accounts where user_id=" + user_id + ";";
		Statement stmt = null;
		String account_status = null;
		DBConnection dbConnection = new DBConnection();
		Connection conn = dbConnection.connect_to_UserAccountsDB();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select_query);
			while(rs.next()){
				account_status = rs.getString("account_status").toString();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if (stmt != null){stmt.close();}
			dbConnection.disconnect(conn);
		}
		return account_status;
	}

}