package com.madhav.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRetailerPage {
public AddRetailerPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(id="retailer:username")
private WebElement usernametextfield;
@FindBy(id="retailer:password")
private WebElement passwordtextfield;
@FindBy(id="retailer:areaCode")
private WebElement areacodedropdown;
@FindBy(id="retailer:phone")
private WebElement phonetextfield;
@FindBy(id="retailer:email")
private WebElement emailtextfield;
@FindBy(id="retailer:address")
private WebElement addresstextfield;
@FindBy(className  ="submit_button")
private WebElement addretailerbutton; 
@FindBy(className ="submit_button")
private WebElement logoutbutton;




public WebElement getUsernametextfield() {
	return usernametextfield;
}
public WebElement getPasswordtextfield() {
	return passwordtextfield;
}
public WebElement getLogoutbutton() {
	return logoutbutton;
}
public WebElement getAreacodedropdown() {
	return areacodedropdown;
}
public WebElement getPhonetextfield() {
	return phonetextfield;
}
public WebElement getEmailtextfield() {
	return emailtextfield;
}
public WebElement getAddresstextfield() {
	return addresstextfield;
}
public WebElement getAddretailerbutton() {
	return addretailerbutton;
}

}
