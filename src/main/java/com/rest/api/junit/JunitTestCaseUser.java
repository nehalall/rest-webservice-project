package com.rest.api.junit;

import org.junit.Test;

import com.rest.api.users.User;

import junit.framework.Assert;
/**
 * JUnit Test Case for User class
 * @author Neha Lall
 *
 */
public class JunitTestCaseUser {
	
	String msg = "Testing the User class!!";
	User user = new User(1,"john@yahoo.com","Burlington","1234");
	
	@Test
	public void testUserGetters(){
		System.out.println(msg);
		Assert.assertEquals(1, user.getUser_id());
		Assert.assertEquals("john@yahoo.com", user.getEmail());
		Assert.assertEquals("Burlington", user.getAddress());
		Assert.assertEquals("1234", user.getZip_code());
	}
}
