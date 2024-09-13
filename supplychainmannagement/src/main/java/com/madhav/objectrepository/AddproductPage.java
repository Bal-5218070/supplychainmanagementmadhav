package com.madhav.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddproductPage {
	
public AddproductPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	@FindBy(id="product:price") 
	private WebElement pricetextfield;
	
	
	@FindBy(id="product:name")
	private WebElement productnametextfield;
	@FindBy(id="product:unit")
	private WebElement unitTypedropdown;
	@FindBy(id="product:category")
	private WebElement categorydropdown;
	@FindBy(name="rdbStock")
	private WebElement enableradiobutton;
    @FindBy(id="product:description")
    private WebElement descriptiontextfields;
    @FindBy(className = "submit_button")
    private WebElement addproductbutton;
	public WebElement getPricetextfield() {
		return pricetextfield;
	}
	public WebElement getProductnametextfield() {
		return productnametextfield;
	}
	public WebElement getUnitTypedropdown() {
		return unitTypedropdown;
	}
	public WebElement getCategorydropdown() {
		return categorydropdown;
	}
	public WebElement getEnableradiobutton() {
		return enableradiobutton;
	}
	public WebElement getDescriptiontextfields() {
		return descriptiontextfields;
	}
	public WebElement getAddproductbutton() {
		return addproductbutton;
	}
	
    
}