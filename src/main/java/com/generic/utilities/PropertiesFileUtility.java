package com.generic.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains method to read data from properties file.
 * 
 * @author Vivek M
 *
 */
public class PropertiesFileUtility {

	/**
	 * This method will return property file key.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream file = new FileInputStream(IConstantUtility.PROPERTIESFILEPATH);
		Properties properties = new Properties();
		properties.load(file);
		String value = properties.getProperty(key);
		return value;
	}
}
