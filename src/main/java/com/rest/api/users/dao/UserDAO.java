package com.rest.api.users.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.rest.api.users.User;

/**
 ** UserDAO class is the DAO class for fetching the user information for a given user from UserDB
 * @author Neha Lall
 *
 */
public class UserDAO {

	public User getUserInfo(int user_id) throws SQLException{
		String select_query = "select * from UserDB.User where user_id=" + user_id + ";";
		Statement stmt = null;
		User user = new User();
		DBConnection dbConnection = new DBConnection();
		Connection conn = dbConnection.connect_to_UserDB();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(select_query);
			while(rs.next()){
				user.setUser_id(rs.getInt("user_id"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setZip_code(rs.getString("zip_code"));
				user.setAccount_status(rs.getString("account_status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if (stmt != null){stmt.close();}
			dbConnection.disconnect(conn);
		}
		return user;
	}

}