package com.Phptravels.com.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SupplierDashboard 
{
	WebDriver driver;
	 @BeforeTest
	  public void beforeTest() throws InterruptedException 
	 {
		 System.setProperty("webdriver.chrome.driver", "D:\\Software_testing_course\\Internship\\Php_TCSiON\\Drivers\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://phptravels.net/login");
		  driver.manage().window().maximize();
		  Thread.sleep(2000);
//Login to user 'Agent'		  
		  WebElement email=driver.findElement(By.id("email"));
		  WebElement password=driver.findElement(By.id("password"));
		  WebElement login=driver.findElement(By.id("submitBTN"));
		  
		  email.sendKeys("supplier@phptravels.com");
		  password.sendKeys("demosupplier");
		  login.click(); 
	  }	
	 @Test(priority=1)
	  public void dashboard_LinkVerification() throws InterruptedException 
	  {
		  WebElement dashboard=driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div/div[2]/ul/li[1]/a"));
		  dashboard.click();
		  Thread.sleep(2000);
		  String actualUrl=driver.getCurrentUrl();
		  String expectedUrl="https://phptravels.net/dashboard";
		  Assert.assertEquals(actualUrl,expectedUrl);
	  }
	  
	 @Test(priority=2)
	  public void myBookings_LinkVerification() throws InterruptedException 
	  {
		  WebDriverWait wait=new WebDriverWait(driver, 15);
		  WebElement myBookings=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div/div[2]/ul/li[2]/a")));
		  myBookings.click();
		  Thread.sleep(2000);
		  String actualUrl=driver.getCurrentUrl();
		  String expectedUrl="https://phptravels.net/bookings";
		  Assert.assertEquals(actualUrl,expectedUrl);
		  Thread.sleep(2000);
	  }
	 
	 @Test(priority=3)  
	  public void myProfile_LinkVerification() throws InterruptedException 
	  {
		  WebDriverWait wait=new WebDriverWait(driver, 15);
		  WebElement myProfile=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div/div[2]/ul/li[3]/a")));
		  myProfile.click();
		  Thread.sleep(2000);
		  String actualUrl=driver.getCurrentUrl();
		  String expectedUrl="https://phptravels.net/profile";
		  Assert.assertEquals(actualUrl,expectedUrl);
		  Thread.sleep(2000);
	  }
	  
	 @Test(priority=4) 
	 public void logout_LinkVerification() throws InterruptedException 
	  {
		  WebDriverWait wait=new WebDriverWait(driver, 15);
		  WebElement logout=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div/div[2]/ul/li[4]/a")));
		  logout.click();
		  String actualUrl=driver.getCurrentUrl();
		  String expectedUrl="https://phptravels.net/";
		  Assert.assertEquals(actualUrl,expectedUrl);
		  
	  }
	  
	 @AfterTest
	  public void afterTest() 
	  {
		  driver.quit();
	  }
}
