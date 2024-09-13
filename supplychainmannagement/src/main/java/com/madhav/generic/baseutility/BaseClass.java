package com.madhav.generic.baseutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.madhav.generic.databaseutility.DataBaseUtility;
import com.madhav.generic.fileUtility.FileUtility;
import com.madhav.generic.webdriverutility.JavaUtilty;
import com.madhav.generic.webdriverutility.WebDriverUtility;
import com.madhav.geniric.excelutility.ExcelUtilty;
import com.madhav.objectrepository.HomePage;
import com.madhav.objectrepository.LoginPage;

public class BaseClass {

	public WebDriver driver = null;

	public FileUtility futil = new FileUtility();
	public ExcelUtilty eutil = new ExcelUtilty();
	public DataBaseUtility dutil = new DataBaseUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public JavaUtilty jutil = new JavaUtilty();

	@BeforeSuite(groups = {"smoke","regression"})
	public void configBs() {
		System.out.println("connect to db");
	}
   // @Parameters("browser")
	@BeforeClass(groups = {"smoke","regression"})
	public void configBc() throws IOException {
   // String	Browser=browser;
		System.out.println("launch the browser");
		String Browser = futil.getDataFromPropertyFile("browser");
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
	}

	@BeforeMethod(groups = {"smoke","regression"})
	public void configBm() throws IOException {
		System.out.println("launch the url");
		wutil.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		String URL = futil.getDataFromPropertyFile("url");
		driver.get(URL);
	}

	@AfterMethod(groups = {"smoke","regression"})
	public void configAm() 
	{
		System.out.println("logout from application");
		HomePage page = new HomePage(driver);
		page.logout();

	}

	@AfterClass(groups = {"smoke","regression"})
	public void configAc() {
		System.out.println("close the browser");
		driver.close();
	}

	@AfterSuite(groups = {"smoke","regression"})
	public void configAs() {
		System.out.println("close the data base connection");
	}
}
