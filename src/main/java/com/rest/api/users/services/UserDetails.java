package com.rest.api.users.services;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.rest.api.users.User;
import com.rest.api.users.dao.UserDAO;

/**
 * UserDetails is a REST API WebService which returns user details with account status
 * @author Neha Lall
 *
 */
@Path("userDetails")
public class UserDetails {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{user_id}")
	
	/*getUserInfo method of the UserDetails is responsible for 
	 * returning the user details + account status of the User ID passed to the REST API*/
	public Response getUserInfo(@PathParam("user_id") int user_id){
		List<User> usersList = getAllUsers();
		Iterator<User> it = usersList.iterator();
		Boolean userFound = false;
		while(it.hasNext()){
			if(it.next().getUser_id() == user_id) {
				userFound = true; break; 
			}
		}
		if(!userFound){
			return Response.status(Status.NOT_FOUND).entity("User doesn't exist").build();
		}
		User user = new User();
		user = getUserDetails(user_id);
		//String respose = "The user " + user.getUser_id() + " Lives @"+ user.getAddress();
		Client client = ClientBuilder.newClient();
    	WebTarget target = client.target("http://localhost:8080/users/restapi/accountStatus/" + user_id);
    	String accountStatus = target.request().get(String.class);
    	user.setAccount_status(accountStatus);
		return Response.status(Status.OK).entity(user).build();
	}	
	
	/*Method getUserDetails uses the stub method getAllUsers to get the details of the User*/
	public User getUserDetails(int user_id){
		
		User user = new User();
		List<User> userList = new ArrayList<User>();
		userList = getAllUsers();
		Iterator<User> it = userList.iterator();
		while(it.hasNext()){
			user = it.next();
			if(user.getUser_id() == user_id)
				break;
		}
		return user;
	}

	/*Method getAllUsers returns a List of all User 
	 * It stubs out the List in the absence of the actual DB*/
	
	public List<User> getAllUsers(){
		
		User u1 = new User(1, "neha@gmail.com", "Westford", "01886");
		User u2 = new User(2, "reema@gmail.com", "Lexington", "01234");
		User u3 = new User(3, "jack@gmail.com", "Bedford", "01555");
		List<User> userList = new ArrayList<User>();
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);
		return userList;
	}

	/*Method getUserDetailsFromDB returns the User information from AccountStatusDB as User object*/	
	public User getUserDetailsFromDB(int user_id) throws SQLException{
		
		User user = new User();
		UserDAO userDao = new UserDAO();
		user = userDao.getUserInfo(user_id);		
		return user;
	}
}