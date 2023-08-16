package com.Phptravels.com.Customer;

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

public class CustomerLogin 
{
	WebDriver driver;
	WebElement email;
	WebElement password;
	WebElement login;
	

//Test case Launch_001 : Site Launch
@BeforeTest
	  public void beforeTest() throws InterruptedException 
	  {

	  System.setProperty("webdriver.chrome.driver", "D:\\Software_testing_course\\Internship\\Php_TCSiON\\Drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://phptravels.net/login");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
	  }

//Test case Login_001:  Valid login 	
  @Test(priority=1)
  public void valid_log() throws InterruptedException 
  {
	  
	  WebElement email=driver.findElement(By.id("email"));
	  WebElement password=driver.findElement(By.id("password"));
 	  WebElement login=driver.findElement(By.id("submitBTN"));

// Valid login data 1  
	  email.sendKeys("user@phptravels.com");
	  password.sendKeys("demouser");
	  login.click();
	  System.out.println("login clicked");
	  Thread.sleep(2000);	 
	  String title=driver.getCurrentUrl();
	  String actualTitle="https://phptravels.net/dashboard";
	  Assert.assertEquals(title,actualTitle);
	  Thread.sleep(2000);
	  WebElement logout = driver.findElement(By.linkText("Logout"));
	  logout.click();
	  Thread.sleep(2000);
	  
// Valid login data 2	  
	     driver.navigate().to("https://phptravels.net/login");
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 WebDriverWait wait=new WebDriverWait(driver, 15);
		  WebElement email1=driver.findElement(By.name("email"));
		  WebElement password1=driver.findElement(By.id("password"));
		  WebElement login1=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitBTN")));
		  email1.sendKeys("USER@phptravels.com");
		  password1.sendKeys("demouser");
		  login1.click();
		  System.out.println("login clicked");
		  String title1=driver.getCurrentUrl();
		  String actualTitle1="https://phptravels.net/dashboard";
		  Assert.assertEquals(title1,actualTitle1);
		  Thread.sleep(2000);	
		  WebElement logout1 = driver.findElement(By.linkText("Logout"));
		  logout1.click();
  }

////Test case Login_002:  Invalid login 	  
  @Test(priority=2)
  public void invalid_login() throws InterruptedException 
  {
	  driver.get("https://phptravels.net/login");
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 WebDriverWait wait=new WebDriverWait(driver, 15);
		  WebElement email=driver.findElement(By.name("email"));
		  WebElement password=driver.findElement(By.id("password"));
		  WebElement login=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitBTN")));
		  
	// Invalid login data 1	
		  System.out.println("invalid test data1");
		  email.sendKeys("user@phptravels.com");
		  password.sendKeys("");
		  login.click();
		  System.out.println("login clicked");
		  String title="https://phptravels.net/dashboard";
		  String actualTitle = driver.getTitle();
		  Assert.assertNotEquals(title,actualTitle);
		  Thread.sleep(2000);
		  
		// Invalid login data 2	 
		  WebElement email1=driver.findElement(By.name("email"));
		  WebElement password1=driver.findElement(By.id("password"));
		  WebElement login1=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitBTN")));
		  System.out.println("invalid test data 2");
		  email1.sendKeys(""); 
		  password1.sendKeys("demouser");		 
		  login1.click();
		  System.out.println("login clicked");
		  String title1="https://phptravels.net/dashboard";
		  String actualTitle1 = driver.getTitle();
		  Assert.assertNotEquals(title1,actualTitle1);
		  Thread.sleep(2000);
		  
		// Invalid login data 3 
		  WebElement email2=driver.findElement(By.id("email"));
		  WebElement password2=driver.findElement(By.id("password"));
		  WebElement login2=driver.findElement(By.id("submitBTN"));
		  System.out.println("invalid test data 3");  
			  email2.sendKeys("");
			  password2.sendKeys("");			  
			  login2.click();
			  System.out.println("login clicked");
			  String title2="https://phptravels.net/dashboard";
			  String actualTitle2 = driver.getTitle();
			  Assert.assertNotEquals(title2,actualTitle2);
			  Thread.sleep(2000);
			  
			// Invalid login data 4 	  
			  WebElement email3=driver.findElement(By.id("email"));
			  WebElement password3=driver.findElement(By.id("password"));
			  WebElement login3=driver.findElement(By.id("submitBTN"));
			  System.out.println("test data 4");
			  email3.sendKeys("user");
			  password3.sendKeys("demouser");			  
			  login3.click();
			  System.out.println("login clicked");
			  String title3="https://phptravels.net/dashboard";
			  String actualTitle3 = driver.getTitle();
			  Assert.assertNotEquals(title3,actualTitle3);
			  Thread.sleep(2000);  
  }
  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
