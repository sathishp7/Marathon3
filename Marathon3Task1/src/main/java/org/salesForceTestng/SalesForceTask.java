package org.salesForceTestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SalesForceTask extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setData() {
		excelFileName="salesForceTestngData";
	}
	
	
@Test(dataProvider="sendData")
public void salesForce(String question,String details) throws Exception {
	
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
	
	driver.findElement(By.xpath("//p[text()='Content']")).click();
	Thread.sleep(3000);
	JavascriptExecutor js=(JavascriptExecutor) driver;
	
	WebElement chatterTab = driver.findElement(By.xpath("//span[text()='Chatter']"));
	js.executeScript("arguments[0].click()",chatterTab);
	String chatterTitle = driver.getTitle();
	
	if(chatterTitle.contains("chatter")) {
		System.out.println("Page Title is correctly displayed");
	}else {
		System.out.println("Page Title is not correctly displayed");
	}
	
	driver.findElement(By.xpath("//span[text()='Question']")).click();
	
	WebElement questionField = driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']"));
	questionField.sendKeys(question);
	
	WebElement detailsField = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow']"));
	detailsField.sendKeys(details);
	
	driver.findElement(By.xpath("//button[text()='Ask']")).click();
	WebElement questionValidate = driver.findElement(By.xpath("//span[text()='What is TestNg']"));
	String questionCheck = questionValidate.getText();
	
	if (questionCheck.contains("What is TestNg")) {
		System.out.println("Question is displayed");
	}else {
		System.out.println();
	}
	
}
}
