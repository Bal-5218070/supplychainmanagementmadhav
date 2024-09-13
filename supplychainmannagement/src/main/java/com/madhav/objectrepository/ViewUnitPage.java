package com.madhav.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewUnitPage {
public ViewUnitPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath  ="//input[@value='+ Add Unit']")
private WebElement addunitbutton;
public WebElement getAddunitbutton() {
	return addunitbutton;
}

}
