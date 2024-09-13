package com.madhav.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className="submit_button")
	private WebElement logoutbutton;
	
	@FindBy(linkText = "Retailers")
	private WebElement retailerslink;
	
	@FindBy(xpath = "//a[text()='New Order']")
	private WebElement neworderlink;
	@FindBy(linkText = "Add Retailers")
	private WebElement addretailerlink;
	
	
	
	public WebElement getNeworderlink() {
		return neworderlink;
	}
	@FindBy(linkText = "Orders")
	private WebElement orderslink;
	
	
	
	

	

	public WebElement getRetailerslink() {
		return retailerslink;
	}

	public WebElement getLogoutbutton() {
		return logoutbutton;
	}
	@FindBy(linkText = "Add Products")
	private WebElement addproductlink;
	@FindBy(linkText = "Manage Category")
	private WebElement managecategorylink;
	@FindBy(linkText = "Manage Unit")
	private WebElement manageunitlink;
	
	
	
	public WebElement getManageunitlink() {
		return manageunitlink;
	}

	public WebElement getManagecategorylink() {
		return managecategorylink;
	}

	public WebElement getAddretailerlink() {
		return addretailerlink;
	}

	public WebElement getAddproductlink() {
		return addproductlink;
	}

	public void logout() {
		logoutbutton.click();
	}

	public WebElement getOrderslink() {
		// TODO Auto-generated method stub
		return orderslink ;
	}

	
}
