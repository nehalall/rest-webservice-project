package com.rest.api.junit;

import org.junit.Test;
import com.rest.api.users.dao.DBConnection;
import junit.framework.Assert;

/**
 * JUnit Test Case for DBConnection class
 * @author Neha Lall
 *
 */
public class JunitTestCaseDBConnection {
	
	String msg = "Testing the DB Connetion class!!";
	DBConnection conn = new DBConnection();
	
	@Test
	public void testUserGetters(){
		System.out.println(msg);
		Assert.assertNotNull(conn);
	}
}
