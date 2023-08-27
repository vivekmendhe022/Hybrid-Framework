package com.generic.utilities;

/**
 * This interface contains constant path of excel & properties file.
 * @author Vivek M
 *
 */
public interface IConstantUtility {

	String EXCELFILEPATH=".\\src\\test\\resources\\TestData.xlsx";
	String PROPERTIESFILEPATH=".\\src\\test\\resources\\CommonData.properties";
	String EXTENTREPORTPATH = ".\\ExtentReports\\Report - " + new JavaUtility().getSystemDateInFormate() + ".html";
	
}
