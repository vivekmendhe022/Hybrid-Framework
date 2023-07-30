package com.object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorLookUpImg;

	@FindBy(linkText = "Sign Out")
	private WebElement SignoutTextLink;

	@FindBy(linkText = "Organizations")
	private WebElement Organizations;

	@FindBy(linkText = "Contacts")
	private WebElement ContactLink;

	@FindBy(linkText = "Leads")
	private WebElement LeadsLink;

	@FindBy(linkText = "Opportunities")
	private WebElement Opportunities;

	@FindBy(xpath = "//a[@href='javascript:;'][normalize-space()='More']")
	private WebElement More;

	@FindBy(linkText = "Campaigns")
	private WebElement CampaingsLinkText;

	@FindBy(linkText = "Documents")
	private WebElement DocumentsLinkText;

	@FindBy(linkText = "Trouble Tickets")
	private WebElement TroubleTicketsLinkText;

	@FindBy(linkText = "Products")
	private WebElement ProductLinkText;

	@FindBy(linkText = "Invoice")
	private WebElement InvoiceLinkText;

	@FindBy(linkText = "Sales Order")
	private WebElement SalesOrderLinkText;

	@FindBy(linkText = "Services")
	private WebElement ServicesLinkText;

	public HomePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}

	public void logoutFromApplication(WebDriver d) {
		mouseHoverAction(d, AdministratorLookUpImg);
		SignoutTextLink.click();
	}

	public void clickOnOrganizationLink() {
		Organizations.click();
	}

	public void clickOnContactLink() {
		ContactLink.click();
	}

	public void clickOnLeadsLink() {
		LeadsLink.click();
	}

	public void clickOnOpportunitiesLink() {
		Opportunities.click();
	}

	public void hoverOnMore(WebDriver d) {
		mouseHoverAction(d, More);
	}

	public void clickOnCampaingsLinkText() {
		CampaingsLinkText.click();
	}

	public void clickOnDocumentsLinkText() {
		DocumentsLinkText.click();
	}

	public void clickOnTroubleTicketsLinkText() {
		TroubleTicketsLinkText.click();
	}

	public void clickOnProductLinkText() {
		ProductLinkText.click();
	}

	public void clickOnInvoiceLinkText(WebDriver d) {
		hoverOnMore(d);
		InvoiceLinkText.click();
	}

	public void clickOnSalesOrderLinkText(WebDriver d) {
		hoverOnMore(d);
		SalesOrderLinkText.click();
	}

	public void clickOnServicesLinkText(WebDriver d) {
		hoverOnMore(d);
		ServicesLinkText.click();
	}

}
