package com.madhav.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderItemsPage {
public OrderItemsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(id="1")
private WebElement quantity1textfield;
@FindBy(id="2")
private WebElement quantity2textfield;
@FindBy(id="3")
private WebElement quantity3textfield;
@FindBy(className ="submit_button")
private WebElement postorderbutton;
public WebElement getQuantity1textfield() {
	return quantity1textfield;
}
public WebElement getQuantity2textfield() {
	return quantity2textfield;
}
public WebElement getQuantity3textfield() {
	return quantity3textfield;
}
public WebElement getPostorderbutton() {
	return postorderbutton;
}


}
