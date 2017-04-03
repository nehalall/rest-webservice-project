package com.rest.api.junit;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
/**
 * JUnit Test Suite containing the list of the classes JUnit Test Case classes
 * @author Neha Lall
 *
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
   JunitTestCaseUser.class,
   JunitTestCaseDBConnection.class
})

public class JunitTestSuite {   
}