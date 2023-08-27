package com.object.repository.bard.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BardHomePage {

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement AddProduct;
	
	public BardHomePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void clickOnAddProductBtnLink() {
		AddProduct.click();
	}
}
