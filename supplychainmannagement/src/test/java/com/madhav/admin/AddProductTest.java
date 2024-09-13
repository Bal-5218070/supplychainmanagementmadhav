package com.madhav.admin;

import java.io.IOException;

import org.testng.annotations.Test;

import com.madhav.generic.baseutility.BaseClass;
import com.madhav.generic.fileUtility.FileUtility;
import com.madhav.generic.webdriverutility.WebDriverUtility;
import com.madhav.objectrepository.AddproductPage;
import com.madhav.objectrepository.HomePage;
import com.madhav.objectrepository.LoginPage;

public class AddProductTest extends BaseClass{
@Test
public void addProductTest() throws IOException {
	LoginPage lp = new LoginPage(driver);
	FileUtility futil =new FileUtility();
	String Username = futil.getDataFromPropertyFile("adminusername");
	String Password = futil.getDataFromPropertyFile("adminpassword");
	
	
	lp.loginForAdmin(Username, Password);
	HomePage page =new HomePage(driver);
	page.getAddproductlink().click();
	
	
	AddproductPage page1 =new AddproductPage(driver);
	page1.getProductnametextfield().sendKeys("allotikk");
	page1.getPricetextfield().sendKeys("50");
	
	
	WebDriverUtility wutil=new WebDriverUtility();
	wutil.selectValueFromDropdown(page1.getUnitTypedropdown(), "KG");
	wutil.selectValueFromDropdown(page1.getCategorydropdown(), "Fast Food");
	
	
	page1.getEnableradiobutton().click();
	page1.getDescriptiontextfields().sendKeys("abc");
	
	page1.getAddproductbutton().click();
	
}
}