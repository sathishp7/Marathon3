package org.salesForceTestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethods {
	public RemoteWebDriver driver;
	public String excelFileName;
	
	@Parameters({"url","browser"})	
@BeforeMethod
	public void openBrowser(String url,String browser) {
		switch(browser) {
		case "chrome":
						
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			break;
		
		case "edge":
			EdgeOptions options1 = new EdgeOptions();
			options1.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(options1);
			break;
			
			default:
				break;
		}

		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		
	}

public void closeBrowser() {
	driver.quit();
}

@DataProvider
public String[][] sendData() throws Exception {
String[][] data = TestDataBook.testData(excelFileName);

return data;



}
}
