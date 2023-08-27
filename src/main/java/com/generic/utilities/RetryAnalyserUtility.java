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

	int count = 0;
	int retryCount = 5;

	public boolean retry(ITestResult result) {
		while (retryCount > count) {
			count++;
			return true;
		}
		return false;
	}

}
