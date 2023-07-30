package com.object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name = "user_name")
	private WebElement UsernameTextField;

	@FindBy(name = "user_password")
	private WebElement PasswordTextField;

	@FindBy(id = "submitButton")
	private WebElement SubmitBtn;

	public LoginPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public WebElement getUsernameTextField() {
		return UsernameTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public void loginToApplication(String USERNAME, String PASSWORD) {
		UsernameTextField.sendKeys(USERNAME);
		PasswordTextField.sendKeys(PASSWORD);
		SubmitBtn.click();
	}
}
