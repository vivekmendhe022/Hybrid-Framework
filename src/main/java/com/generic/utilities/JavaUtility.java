package com.generic.utilities;

import java.util.Date;
import java.util.Random;

/**
 * This class contains basic java methods for test scripts.
 * 
 * @author Vivek
 * 
 *
 */
public class JavaUtility {

	public int getRandomValue() {
		Random random = new Random();
		return random.nextInt(1000);
	}
	
	public String getSystemDate() {
		Date date = new Date();
		return date.toString();
	}
	
	public String getSystemDateInFormate() {
		Date d = new Date();
		String[] split = d.toString().split(" ");
		String date=split[2];
		String month=split[1];
		String year=split[5];
		String time=split[3].replace(":", "-");
		return date+" "+month+" "+year+" "+time;		
	}
	
	public static void main(String[] args) {
		JavaUtility j=new JavaUtility();
		String date = j.getSystemDate();
		System.out.println(date);
	}
}
