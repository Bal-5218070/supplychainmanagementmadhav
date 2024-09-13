package com.madhav.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategorypage {
	public AddCategorypage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "categoryName")
	private WebElement categorynametextfield;
	@FindBy(id = "categoryDetails")
	private WebElement categorydetailstextfield;
	@FindBy(className = "submit_button")
	private WebElement addcategorybutton;
	

	public WebElement getAddcategorybutton() {
		return addcategorybutton;
	}

	public WebElement getCategorydetailstextfield() {
		return categorydetailstextfield;
	}

	public WebElement getCategorynametextfield() {
		return categorynametextfield;

		

	}

}
