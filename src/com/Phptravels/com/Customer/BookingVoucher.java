package com.Phptravels.com.Customer;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class BookingVoucher 
{
	WebDriver driver;
	WebElement email;
	WebElement password;
	WebElement login;
	
	@BeforeTest
	  public void beforeTest() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Software_testing_course\\Internship\\Php_TCSiON\\Drivers\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://phptravels.net/login");
		  driver.manage().window().maximize();
		  Thread.sleep(2000);
	  }	
	
//Display Booking Voucher	
  @Test
  public void booking_voucher() throws InterruptedException 
  {
	  WebElement email=driver.findElement(By.id("email"));
	  WebElement password=driver.findElement(By.id("password"));
 	  WebElement login=driver.findElement(By.id("submitBTN"));
	  email.sendKeys("user@phptravels.com");
	  password.sendKeys("demouser");
	  login.click();
	  Thread.sleep(2000);
	  
	  WebElement myBookings=driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div/div[2]/ul/li[2]/a"));
	  myBookings.click();
	  Thread.sleep(2000);
	  
//new window switch	  
	  Set<String> handles = driver.getWindowHandles();
      String originalWindow = driver.getWindowHandle();

      Iterator <String> iterator = handles.iterator();
      while(iterator.hasNext())     
      {
      String newWindow = iterator.next();
      if(!originalWindow.equalsIgnoreCase(newWindow))
      	{
    	  driver.switchTo().window(newWindow);
      	}
      }
	  Thread.sleep(2000);
	  WebElement voucher=driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[7]/a")); 
	  voucher.click();
	  Thread.sleep(4000);
      }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
