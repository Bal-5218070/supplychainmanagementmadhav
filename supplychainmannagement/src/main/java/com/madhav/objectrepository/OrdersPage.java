package com.madhav.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
public OrdersPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(id="cmbFilter")
private WebElement searchbydropdown;
@FindBy(xpath = "//input[@type='submit']")
private WebElement searchbutton;
@FindBy(id="txtId")
private WebElement idtextfield;
public WebElement getSearchbydropdown() {
	return searchbydropdown;
}
public WebElement getSearchbutton() {
	return searchbutton;
}
public WebElement getIdtextfield() {
	return idtextfield;
}


}
