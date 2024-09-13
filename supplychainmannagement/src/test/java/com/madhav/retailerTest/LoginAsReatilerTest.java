package com.madhav.retailerTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.madhav.generic.baseutility.BaseClass;
import com.madhav.generic.fileUtility.FileUtility;
import com.madhav.objectrepository.HomePage;
import com.madhav.objectrepository.LoginPage;
import com.madhav.objectrepository.OrderItemsPage;

public class LoginAsReatilerTest extends BaseClass {
@Test(groups = "smoke")
public void LoginAsReatilerTest() throws Throwable {
	LoginPage lp =new LoginPage(driver);
	FileUtility futil =new FileUtility();
	String username = futil.getDataFromPropertyFile("retailerusername");
	String password =futil.getDataFromPropertyFile("retailerpassword");
	lp.loginForRetailer(username, password);
}
@Test(groups="regression")
public void createOrderTest() throws Throwable {
	LoginPage lp =new LoginPage(driver);
	FileUtility futil =new FileUtility();
	String username = futil.getDataFromPropertyFile("retailerusername");
	String password =futil.getDataFromPropertyFile("retailerpassword");
	lp.loginForRetailer(username, password);
	HomePage page =new HomePage(driver);
	page.getNeworderlink().click();
	OrderItemsPage page1 = new OrderItemsPage(driver);
	page1.getQuantity1textfield().sendKeys("20");
	page1.getQuantity2textfield().sendKeys("30");
	page1.getQuantity3textfield().sendKeys("20");
	page1.getPostorderbutton().click();
	
}
}

