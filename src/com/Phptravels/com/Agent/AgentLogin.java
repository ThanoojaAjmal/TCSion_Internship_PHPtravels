package com.Phptravels.com.Agent;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

                                    //************* Test valid login credentials for Agent Font End ******************
public class AgentLogin 
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
	 
	 							
  @Test(priority=1) // Valid Login
  public void valid_log() throws InterruptedException 
  {
	  WebElement email=driver.findElement(By.id("email"));
	  WebElement password=driver.findElement(By.id("password"));
	  WebElement login=driver.findElement(By.id("submitBTN"));
	  
// Valid login case 1
	  System.out.println("valid test data1");
	  email.sendKeys("agent@phptravels.com");
	  password.sendKeys("demoagent");
	  login.click();
	  System.out.println("login clicked");
	  Thread.sleep(2000);
	  String actualUrl=driver.getCurrentUrl();
	  String expectedUrl="https://phptravels.net/dashboard";
	  Assert.assertEquals(actualUrl,expectedUrl);
	  Thread.sleep(2000);
	  WebElement logout = driver.findElement(By.linkText("Logout"));
	  logout.click();
	  Thread.sleep(2000);
	
	  
// Valid login case 2	  
	     driver.navigate().to("https://phptravels.net/login");
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 WebDriverWait wait=new WebDriverWait(driver, 15);		 
		 WebElement email1=driver.findElement(By.name("email"));
		 WebElement password1=driver.findElement(By.id("password"));
		 WebElement login1=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitBTN")));
		 System.out.println("valid test data2");
		 email1.sendKeys("AGENT@phptravels.com");
		 password1.sendKeys("demoagent");
		 login1.click();
		 System.out.println("login clicked");
		 Thread.sleep(2000);
		 String actualUrl1=driver.getCurrentUrl();
		 String expectedUrl1="https://phptravels.net/dashboard";
		 Assert.assertEquals(actualUrl1,expectedUrl1);
		 Thread.sleep(2000);
		 WebElement logout1 = driver.findElement(By.linkText("Logout"));
		 logout1.click();
  }
  
@Test(priority=2) // Invalid Login
  public void invalid_log() throws InterruptedException 
  {
	 driver.get("https://phptravels.net/login");
	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	 WebDriverWait wait=new WebDriverWait(driver, 15);
	 WebElement email=driver.findElement(By.name("email"));
	 WebElement password=driver.findElement(By.id("password"));
     WebElement login=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitBTN")));
	  
// Invalid login case 1	
	  System.out.println("invalid test data1");
	  email.sendKeys("agent@phptravels.com");
	  password.sendKeys("");
	  System.out.println("login clicked");
	  login.click();
	  Thread.sleep(2000);
	  String actualUrl=driver.getCurrentUrl();
	  String expectedUrl="https://phptravels.net/dashboard";
	  Assert.assertNotEquals(actualUrl,expectedUrl);
	  Thread.sleep(2000);
/*	  String title="https://phptravels.net/dashboard";
	  String actualTitle = driver.getTitle();
	  if(title!=actualTitle)
		  System.out.println("Invalid login");
	  Thread.sleep(2000);*/
	  
	// Invalid login case 2	 
	  WebElement email1=driver.findElement(By.name("email"));
	  WebElement password1=driver.findElement(By.id("password"));
	  WebElement login1=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitBTN")));
	  System.out.println("invalid case 2");
	  System.out.println("test data 2");
	  email1.sendKeys(""); 
	  password1.sendKeys("demoagent");
	  System.out.println("login clicked");
	  login1.click();
	  Thread.sleep(2000);
	  String actualUrl1=driver.getCurrentUrl();
	  String expectedUrl1="https://phptravels.net/dashboard";
	  Assert.assertNotEquals(actualUrl1,expectedUrl1);
	  Thread.sleep(2000);
	  
	// Invalid login case 3 
		  WebElement email2=driver.findElement(By.id("email"));
		  WebElement password2=driver.findElement(By.id("password"));
		  WebElement login2=driver.findElement(By.id("submitBTN"));
		  System.out.println("test data 3");  
		  email2.sendKeys("");
		  password2.sendKeys("");
		  System.out.println("login clicked");
		  login2.click();
		  Thread.sleep(2000);
		  String actualUrl2=driver.getCurrentUrl();
		  String expectedUrl2="https://phptravels.net/dashboard";
		  Assert.assertNotEquals(actualUrl2,expectedUrl2);
		  Thread.sleep(2000);
		  
		// Invalid login case 4 	  
		  WebElement email3=driver.findElement(By.id("email"));
		  WebElement password3=driver.findElement(By.id("password"));
		  WebElement login3=driver.findElement(By.id("submitBTN"));
		  System.out.println("test data 4");
		  email3.sendKeys("agent");
		  password3.sendKeys("demoagent");
		  System.out.println("login clicked");
		  login3.click();
		  Thread.sleep(2000);
		  String actualUrl3=driver.getCurrentUrl();
		  String expectedUrl3="https://phptravels.net/dashboard";
		  Assert.assertNotEquals(actualUrl3,expectedUrl3);
		  Thread.sleep(2000);
  }
 

@AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
