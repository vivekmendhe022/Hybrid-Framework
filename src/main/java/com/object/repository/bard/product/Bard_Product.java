package com.object.repository.bard.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bard_Product {

	@FindBy(id = "productName")
	private WebElement ProductNameTextField;

	@FindBy(id = "productDescription")
	private WebElement ProductDescriptionTextField;

	@FindBy(id = "productPrice")
	private WebElement ProductPriceTextField;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	private WebElement SubmitBtn;

	public Bard_Product(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void createProduct(String PNAME, String PDESC, String PPRICE) {
		ProductNameTextField.sendKeys(PNAME);
		ProductDescriptionTextField.sendKeys(PDESC);
		ProductPriceTextField.sendKeys(PPRICE);
		SubmitBtn.click();
	}

}
