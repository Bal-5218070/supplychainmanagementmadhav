package com.madhav.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * wait for page to load
	 * @param driver
	 */
public void waitForPageToLoad(WebDriver driver) {
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
/**
 * wait for element to be clickable
 * @param driver
 * @param element
 */
public void elementToBeClickable(WebDriver driver,WebElement element) {
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * switch inside the childwindow 
 * @param driver
 * @param partialChildUrl
 */
public void switchToChildWindow(WebDriver driver,String partialChildUrl) {
	Set<String> allids = driver.getWindowHandles();
	Iterator<String> it = allids.iterator();
	while(it.hasNext()) {
		String id = it.next();
		driver.switchTo().window(id);
		String currenturl = driver.getCurrentUrl();
		if(currenturl.contains(partialChildUrl)) {
			break;
		}
	}
}
/**
 * 
 * @param driver
 * @param partailParentUrl
 * i am going to switch driver control from parent window to child window
 */
public void switchFromParentWindow(WebDriver driver,String partailParentUrl) {
	Set<String> allids = driver.getWindowHandles();
	Iterator<String> it = allids.iterator();
	while(it.hasNext()) {
	String id = it.next();
	driver.switchTo().window(id);
	String currenturl= driver.getCurrentUrl();
	if(currenturl.contains(partailParentUrl)) {
		break;
	}
	}
}
/**
 * to select the value from dropdown
 * @param driver
 * @param element
 */
public void selectValueFromDropdown(WebElement element,String text) {
	Select select =new Select(element);
	select.selectByVisibleText(text);
}
/**
 * 
 * @param element
 * @param index
 */
public void selectValueFromDropdown(WebElement element,int index) {
	Select select =new Select(element);
	select.deselectByIndex(index);
}
/**
 * to switch inside the frame
 * @param driver
 * @param element
 */
public void moveToElement(WebDriver driver,WebElement element) {
	Actions action =new Actions(driver);
	action.moveToElement(element).perform();
}
public void switchToFrame(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
public void switchToFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);
}
/**
 * handle alert popup
 * @param driver
 */
public void handleAlertpopupsAccept(WebDriver driver) {
	driver.switchTo().alert().accept();
}
public void handleAlertpopupDismiss(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
}
