package com.madhav.manufacturer;



import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.madhav.generic.baseutility.BaseClass;
import com.madhav.generic.fileUtility.FileUtility;
import com.madhav.generic.webdriverutility.WebDriverUtility;
import com.madhav.objectrepository.AddRetailerPage;
import com.madhav.objectrepository.HomePage;
import com.madhav.objectrepository.LoginPage;

public class manufacturerAbleToSeeRetailerTest extends BaseClass{
	@Test
 public void manufacturerAbleToSeeRetailerTest() throws IOException, InterruptedException {
	// login as admin
	LoginPage lp=new LoginPage(driver);
	FileUtility futil =new FileUtility();
	String Username = futil.getDataFromPropertyFile("adminusername");
	String Password = futil.getDataFromPropertyFile("adminpassword");
	lp.loginForAdmin(Username, Password);
	
	HomePage page1 =new HomePage(driver);
	page1.getAddretailerlink().click();
	
	AddRetailerPage page =new AddRetailerPage(driver);
	page.getUsernametextfield().sendKeys("sauravgarg");
	page.getPasswordtextfield().sendKeys("sauravgarg");
	
	WebDriverUtility wutil= new WebDriverUtility();
	wutil.selectValueFromDropdown(page.getAreacodedropdown(), "SRKJ (Sarkhej)");
	
	page.getPhonetextfield().sendKeys("9149387369");
	page.getEmailtextfield().sendKeys("sauravgarg123@gmail.com");
	page.getAddresstextfield().sendKeys("abc");
	page.getAddretailerbutton().click();
	
	
	
	//logout  as admin
	
	//page.getLogoutbutton().click();
	
	Thread.sleep(5000);
	
	//login as manufacturer
	
	LoginPage lp1= new LoginPage(driver);
	
	Thread.sleep(4000);
	
	String Username1 = futil.getDataFromPropertyFile("manufacturerusername");
	String Password1 = futil.getDataFromPropertyFile("manufacturerpassword");
	lp1.loginForManufacturer(Username1, Password1);
	
	page1.getRetailerslink().click();
	
	String expectedresult="sauravgarg";
	 String actualresult = driver.findElement(By.xpath("//td[text()=' sauravgarg ']")).getText();
	 Assert.assertTrue(expectedresult.contains(actualresult));
	
	
}
}
