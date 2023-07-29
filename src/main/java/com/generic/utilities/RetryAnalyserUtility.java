package com.generic.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This method contains IRetryAnalyzer abstract method to executing only failed
 * test script for to 4 to 5 times
 * 
 * @author Vivek M
 *
 */
public class RetryAnalyserUtility implements IRetryAnalyzer {

	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}

}
