package org.salesForceTestng;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesForceTask2 extends ProjectSpecificMethods {
	@BeforeTest
	public void setData() {
		excelFileName = "salesForceTestDataOpportunity";
	}

	@Test(dataProvider = "sendData")
	public void salesForce2(String opportunity, String amount) throws Exception {
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement viewDeals = driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
		js.executeScript("arguments[0].click()", viewDeals);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys(opportunity);
		Thread.sleep(3000);
		WebElement typeSelect = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[2]"));
		typeSelect.click();
		driver.findElement(By.xpath("(//span[text()='New Customer'])[1]")).click();
		driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]")).click();
		driver.findElement(By.xpath("(//span[text()='Partner Referral'])[1]")).click();

		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys(amount);

		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("3/17/2023");
		driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']/span[text()='Needs Analysis']")).click();
		driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input'])[2]")).click();
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
				
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.name("SaveAndNew")).click();
		

	}
}
