package com.object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorLookUpImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignoutTextLink;

	public HomePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	public void logoutFromApplication(WebDriver d) {
		mouseHoverAction(d, AdministratorLookUpImg);
		SignoutTextLink.click();
	}
	
	
	
}
