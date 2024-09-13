package com.madhav.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCategoryPage {
public ViewCategoryPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath ="//input[@value='+ Add Category']")
private WebElement addcategorybutton;
public WebElement getAddcategorybutton() {
	return addcategorybutton;
}


}
