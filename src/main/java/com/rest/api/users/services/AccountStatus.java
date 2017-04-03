package com.rest.api.users.services;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.api.users.User;
import com.rest.api.users.dao.UserAccountDAO;
import com.rest.api.users.dao.UserDAO;

/**
 * AccountStatus is a REST API WebService which returns the account status of a User
 * @author X150977
 *
 */
@Path("accountStatus")
public class AccountStatus {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{user_id}")
	/*getAccountStatus method of the AccountStatus is responsible for 
	 * returning the account status of the User ID passed to the REST API*/
	public String getAccountStatus(@PathParam("user_id") int user_id){
		
		Map<Integer, String> accountsStatusMap = getAllUsersStatus();		
		String account_status = accountsStatusMap.get(user_id);
		return account_status;		
	}

	/*Method getAllUsersStatus returns a Map of User Statuses for all the User IDs 
	 * It stubs out the List in the absence of the actual DB*/
	public Map<Integer, String> getAllUsersStatus(){
		
		Map<Integer, String> accountsStatusMap = new HashMap<>();
		accountsStatusMap.put(1, "Active");
		accountsStatusMap.put(2, "Active");
		accountsStatusMap.put(3, "Suspended");
		return accountsStatusMap;
	}

	/*Method getAccountStatusFromDB is for getting Account Status of User from AccountStatusDB*/
	public String getAccountStatusFromDB(int user_id) throws SQLException{
		
		String accountStatus = null;
		UserAccountDAO userAccountDao = new UserAccountDAO();
		accountStatus = userAccountDao.getUserAccountStatus(user_id);		
		return accountStatus;
	}	

}
