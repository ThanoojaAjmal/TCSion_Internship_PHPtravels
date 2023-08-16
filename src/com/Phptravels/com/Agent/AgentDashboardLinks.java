package com.Phptravels.com.Agent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

								//  Verify links Home, Hotels, Flights, Tours and Blog
public class AgentDashboardLinks 
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
		  
		  email.sendKeys("agent@phptravels.com");
		  password.sendKeys("demoagent");
		  login.click();
	  }
	
@BeforeMethod
public void beforeMethod() throws InterruptedException
{
	driver.get("https://phptravels.net/dashboard");
	Thread.sleep(2000);
}

  
  @Test(priority=1)		// Verify Hotels link
  public void hotel_LinkVerification() throws InterruptedException 
  {
	  WebElement hotel=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[1]/ul/li[4]/a"));
	  hotel.click();
	  Thread.sleep(2000);
	  String actualUrl=driver.getCurrentUrl();
	  String expectedUrl="https://phptravels.net/hotels";
	  Assert.assertEquals(actualUrl,expectedUrl);
  }
  
  @Test(priority=2)		// Verify Flights link
  public void flights_LinkVerification() throws InterruptedException 
  {
	  WebElement flights=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[1]/ul/li[1]/a"));
	  flights.click();
	  Thread.sleep(2000);
	  String actualUrl=driver.getCurrentUrl();
	  String expectedUrl="https://phptravels.net/flights";
	  Assert.assertEquals(actualUrl,expectedUrl);
  }
  
  @Test(priority=3)		// Verify Tours link
  public void tours_LinkVerification() throws InterruptedException 
  {
	  WebElement tours=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[1]/ul/li[2]/a"));
	  tours.click();
	  Thread.sleep(2000);
	  String actualUrl=driver.getCurrentUrl();
	  String expectedUrl="https://phptravels.net/tours";
	  Assert.assertEquals(actualUrl,expectedUrl);
  }
  
  
  @Test(priority=4)		// Verify Blog link
  public void blog_LinkVerification() throws InterruptedException 
  {
	  WebElement blog=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[1]/ul/li[5]/a"));
	  blog.click();
	  Thread.sleep(2000);
	  String actualUrl=driver.getCurrentUrl();
	  String expectedUrl="https://phptravels.net/blogs";
	  Assert.assertEquals(actualUrl,expectedUrl);
  }
  
 
   
  @Test(priority=5)		// Verify Home link
  public void home_LinkVerification() throws InterruptedException 
  {
	  WebElement home=driver.findElement(By.xpath("//*[@id=\"fadein\"]/header/div/div[1]/a/img"));
	  home.click();
	  Thread.sleep(2000);
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
