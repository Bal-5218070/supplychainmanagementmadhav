package com.madhav.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUnitPage {
public AddUnitPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(id="unitName")
private WebElement unitnametextfield;
@FindBy(id="unitDetails")
private WebElement unitdetailstextfield;
public WebElement getUnitnametextfield() {
	return unitnametextfield;
}
public WebElement getUnitdetailstextfield() {
	return unitdetailstextfield;
}


}
