package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLogintest extends TestBase {
	
	@Test
	// method name starts with small letter -- loginAsBankManager
	public void loginAsBankManager() throws InterruptedException { 
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		log.debug("Inside Login Test");		
		driver.findElement(By.cssSelector(Locators.getProperty("bmlBtn"))).click();
		
		Assert.assertTrue(isElementPresent(By.cssSelector(Locators.getProperty("addCustBtn"))), "Login not successful");
		
		log.debug("Login successfully executed....");	
		Reporter.log("Login successfully executed....");
		Reporter.log("<a target=\"blank\" href=\"D:\\screen.png\">ScreenFirst</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"blank\" href=\"D:\\screen.png\"><img src=\"D:\\screen.png\" height=200 width=200></img></a>");
		
	}
	
}
