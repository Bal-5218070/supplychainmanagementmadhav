package com.madhav.manufacturer;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.invokers.AbstractParallelWorker.Arguments;

import com.madhav.generic.baseutility.BaseClass;
import com.madhav.generic.fileUtility.FileUtility;
import com.madhav.objectrepository.AddCategorypage;
import com.madhav.objectrepository.AddUnitPage;
import com.madhav.objectrepository.HomePage;
import com.madhav.objectrepository.LoginPage;
import com.madhav.objectrepository.ViewCategoryPage;
import com.madhav.objectrepository.ViewUnitPage;
@Listeners(com.madhav.ListenerUtility.ListenerImpClass.class)
//we cannot run here directly 
//for this we have to make listenertestng class for failed testcase
public class AddManageCategoryTest extends BaseClass {
@Test(groups = "smoke")
public void addManageCategoryTest() throws Throwable {
LoginPage lp =new LoginPage(driver);
FileUtility futil =new FileUtility();
String Username = futil.getDataFromPropertyFile("adminusername");
String Password = futil.getDataFromPropertyFile("adminpassword");
lp.loginForAdmin(Username, Password);

HomePage page =new HomePage(driver);
page.getManagecategorylink().click();
ViewCategoryPage page1= new ViewCategoryPage(driver);
JavascriptExecutor js =(JavascriptExecutor)driver;
js.executeScript("arguments[0].click()", page1.getAddcategorybutton());
	AddCategorypage acp =new AddCategorypage(driver);
	acp.getCategorynametextfield().sendKeys("fast food 1");
	acp.getCategorydetailstextfield().sendKeys("abcd");
	acp.getAddcategorybutton().click();
	}
@Test(groups = "regression")
public void manageUnitTest() throws IOException {
	LoginPage lp =new LoginPage(driver);
	FileUtility futil =new FileUtility();
	String Username = futil.getDataFromPropertyFile("adminusername");
	String Password = futil.getDataFromPropertyFile("adminpassword");
	lp.loginForAdmin(Username, Password);

	HomePage page =new HomePage(driver);
	page.getManageunitlink().click();
	
	ViewUnitPage vup =new ViewUnitPage(driver);
	vup.getAddunitbutton().click();
	
	AddUnitPage auu =new AddUnitPage(driver);
	auu.getUnitnametextfield().sendKeys("KG");
	auu.getUnitdetailstextfield().sendKeys("KILOGRAM");
}
}