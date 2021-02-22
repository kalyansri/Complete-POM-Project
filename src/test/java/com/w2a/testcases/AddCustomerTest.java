package com.w2a.testcases;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class AddCustomerTest extends TestBase {

	@Test(dataProvider="getdata")
	public void addCustomer(String firstName, String lastName, String postCode, String alerttext) throws InterruptedException {

		driver.findElement(By.cssSelector(Locators.getProperty("addCustBtn"))).click();
		driver.findElement(By.cssSelector(Locators.getProperty("firstname"))).sendKeys(firstName);
		driver.findElement(By.cssSelector(Locators.getProperty("lastname"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(Locators.getProperty("postcode"))).sendKeys(postCode);
		driver.findElement(By.cssSelector(Locators.getProperty("addbtn"))).click();

		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alerttext));
		alert.accept();
		Thread.sleep(3000);
	}
	@DataProvider
	public Object[][] getdata() {

		String sheetName = "AddCustomerTest";
 		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0]rows [0]columns
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				// -2
			}
		}
		return data;
	}
}
