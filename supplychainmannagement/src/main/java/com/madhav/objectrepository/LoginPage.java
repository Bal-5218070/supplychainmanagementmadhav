package com.madhav.objectrepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.madhav.generic.fileUtility.FileUtility;
import com.madhav.generic.webdriverutility.WebDriverUtility;

public class LoginPage {
	/**
	 * this is how we can provide java doc
	 * 
	 * @author Bal krishna Contains login page elements &businesss lib like login()
	 */

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "login:username")
	private WebElement usernametextfield;
	@FindBy(id = "login:password")
	private WebElement passwordtextfield;
	@FindBy(name = "login_type")
	private WebElement logindropdown;
	@FindBy(className = "submit_button")
	private WebElement loginbutton;

	public WebElement getUsernametextfield() {
		return usernametextfield;
	}

	public WebElement getPasswordtextfield() {
		return passwordtextfield;
	}

	public WebElement getLogindropdown() {
		return logindropdown;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}

	public void loginForAdmin(String username, String password) throws IOException {
		WebDriverUtility wtil = new WebDriverUtility();
		FileUtility futil = new FileUtility();

		usernametextfield.sendKeys(username);
		passwordtextfield.sendKeys(password);

		String Admin = futil.getDataFromPropertyFile("adminType");
		wtil.selectValueFromDropdown(logindropdown, Admin);
		loginbutton.click();
	}

	public void loginForRetailer(String username, String password) throws IOException, InterruptedException {
		WebDriverUtility wtil = new WebDriverUtility();
		usernametextfield.sendKeys(username);
		passwordtextfield.sendKeys(password);

		FileUtility futil = new FileUtility();
		String retailer= futil.getDataFromPropertyFile("retailerType");
		wtil.selectValueFromDropdown(logindropdown, retailer);

		
		loginbutton.click();
	}

	public void loginForManufacturer(String username, String password) throws IOException {
		WebDriverUtility wtil = new WebDriverUtility();

		
		usernametextfield.sendKeys(username);
		passwordtextfield.sendKeys(password);

		FileUtility futil = new FileUtility();
		String Manufacturertype = futil.getDataFromPropertyFile("manufacturerType");
		wtil.selectValueFromDropdown(logindropdown, Manufacturertype);
		loginbutton.click();
	}

}