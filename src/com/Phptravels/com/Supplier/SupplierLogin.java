package com.Phptravels.com.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

									// Supplier Login
public class SupplierLogin 
{
	WebDriver driver;
	WebElement email;
	WebElement password;
	WebElement login;
@Test	
	  public void test() throws InterruptedException 
	  {

	  System.setProperty("webdriver.chrome.driver", "D:\\Software_testing_course\\Internship\\Php_TCSiON\\Drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://phptravels.net/supplier");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
	  String title=driver.getCurrentUrl();
	  String actualTitle="https://phptravels.net/supplier/dashboard";
	  Assert.assertEquals(title,actualTitle);
	  }
	
 @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
