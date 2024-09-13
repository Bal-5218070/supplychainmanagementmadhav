package endtoendscenario;

import java.io.IOException;

import org.testng.annotations.Test;

import com.madhav.generic.baseutility.BaseClass;
import com.madhav.generic.fileUtility.FileUtility;
import com.madhav.generic.webdriverutility.WebDriverUtility;
import com.madhav.objectrepository.HomePage;
import com.madhav.objectrepository.LoginPage;
import com.madhav.objectrepository.OrderItemsPage;
import com.madhav.objectrepository.OrdersPage;

public class OrderCreatedByRetailerAndVerifyByManufacturerTest extends BaseClass {
	/**
	 * 
	 * @throws Throwable
	 */
	@Test
	public void ordercreatedbyretailerandverifyByManufacturerTest() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		FileUtility futil = new FileUtility();
		String username = futil.getDataFromPropertyFile("retailerusername");
		String password = futil.getDataFromPropertyFile("retailerpassword");

		lp.loginForRetailer(username, password);

		HomePage page = new HomePage(driver);

		page.getNeworderlink().click();

		OrderItemsPage page1 = new OrderItemsPage(driver);
		page1.getQuantity1textfield().sendKeys("20");
		page1.getQuantity2textfield().sendKeys("30");
		page1.getQuantity3textfield().sendKeys("20");
		page1.getPostorderbutton().click();

		LoginPage lp2 = new LoginPage(driver);
		String username1 = futil.getDataFromPropertyFile("manufacturerusername");
		String password1 = futil.getDataFromPropertyFile("manufacturerpassword");
		Thread.sleep(2000);
		lp2.loginForManufacturer(username1, password1);

		page.getOrderslink().click();
		OrdersPage pg = new OrdersPage(driver);

		WebDriverUtility wutil = new WebDriverUtility();
		wutil.selectValueFromDropdown(pg.getSearchbydropdown(), "Id");
		
		pg.getIdtextfield().sendKeys("8");
		pg.getSearchbutton().click();

	}
}
