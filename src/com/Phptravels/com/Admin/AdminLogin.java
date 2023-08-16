package com.Phptravels.com.Admin;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

//import java.util.Iterator;
//import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

						// Verify valid and invalid login 
public class AdminLogin 
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
		  driver.get("https://phptravels.net/admin/login.php");
		  driver.manage().window().maximize();
		  Thread.sleep(2000);
	  }
 
	 @Test(priority=1)			//Test valid login credentials
	  public void valid_log() throws InterruptedException 
	  {

		  WebElement email=driver.findElement(By.id("email"));
		  WebElement password=driver.findElement(By.id("password"));
		  WebElement login=driver.findElement(By.id("submit"));
		  
	// Valid login case 1
		  System.out.println("Valid test data 1");
		  email.sendKeys("admin@phptravels.com");
		  password.sendKeys("demoadmin");
		  login.click();
		  System.out.println("Login clicked ");
		  Thread.sleep(2000);
		//check correct page is loaded	
		  String actualUrl=driver.getCurrentUrl();
		  String expectedUrl="https://phptravels.net/admin/dashboard.php";
		  Assert.assertEquals(actualUrl,expectedUrl);
		  Thread.sleep(2000);
		 
		  //Logout from admin page
    	  WebElement super_admin = driver.findElement(By.xpath("//a[@id='dropdownUser1']"));
    	  super_admin.click(); 

    	  WebElement logout = driver.findElement(By.xpath("/html/body/main/header/div[2]/ul/li[6]/a"));
    	  logout.click();
    	  System.out.println("Logged out");

    	  Thread.sleep(2000);
		
	  
	// Valid login case 2	
    	  	 System.out.println("Valid test data 2");
			 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			 WebDriverWait wait=new WebDriverWait(driver, 15);
			 WebElement email1=driver.findElement(By.name("email"));
			 WebElement password1=driver.findElement(By.id("password"));
			 WebElement login1=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
			 
			 email1.sendKeys("ADMIN@phptravels.com");
			 password1.sendKeys("demoadmin");
			 login1.click();
			  System.out.println("Login clicked ");
			 Thread.sleep(2000);
			//check correct page is loaded	
			  String actualUrl1=driver.getCurrentUrl();
			  String expectedUrl1="https://phptravels.net/admin/dashboard.php";
			  Assert.assertEquals(actualUrl1,expectedUrl1);
			  Thread.sleep(2000);	
			  //Logout from admin page
			  WebElement super_admin1 = driver.findElement(By.xpath("//a[@id='dropdownUser1']"));
	    	  super_admin1.click(); 
			  WebElement logout1 = driver.findElement(By.xpath("/html/body/main/header/div[2]/ul/li[6]/a"));
			  logout1.click();
	    	  System.out.println("Logged out");
	  }
	  
	@Test(priority=2) // Invalid Login
	  public void invalid_log() throws InterruptedException 
	  {
		 driver.get("https://phptravels.net/admin/dashboard.php");
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 WebDriverWait wait=new WebDriverWait(driver, 15);
		 WebElement email=driver.findElement(By.name("email"));
		 WebElement password=driver.findElement(By.id("password"));
		 WebElement login=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
		  
	// Invalid login case 1	
		  System.out.println("Invalid test data1");
		  email.sendKeys("admin@phptravels.com");
		  password.sendKeys("");
		  login.click();
		  System.out.println("login clicked");
		  String message=driver.switchTo().alert().getText();
		  System.out.println(message);
		  Thread.sleep(2000);
		  driver.switchTo().alert().accept();	  		  
		  System.out.println("Clicked OK");
		  Thread.sleep(2000);
		  
	// Invalid login case 2	 
		  System.out.println("Invalid test data2");
		  WebElement email1=driver.findElement(By.name("email"));
		  WebElement password1=driver.findElement(By.id("password"));
		  WebElement login1=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit")));
		  email1.sendKeys(""); 
		  password1.sendKeys("demoadmin");		 
		  login1.click();
		  System.out.println("login clicked");
		  String message1=driver.switchTo().alert().getText();
		  System.out.println(message1);
		  Thread.sleep(2000);
		  driver.switchTo().alert().accept();
		  System.out.println("Clicked OK");
		  Thread.sleep(2000);
		  
		// Invalid login case 3 
		  WebElement email2=driver.findElement(By.id("email"));
		  WebElement password2=driver.findElement(By.id("password"));
		  WebElement login2=driver.findElement(By.id("submit"));
		  System.out.println("Invalid test data 3");  
			  email2.sendKeys("");
			  password2.sendKeys("");			  
			  login2.click();
			  System.out.println("login clicked");
// checking for alerts
			  int a=2;
			  while(a>=1)
			  {
				 if (ExpectedConditions.alertIsPresent()!=null)
			  {
				  
			  String message2=driver.switchTo().alert().getText();
			  System.out.println(message2);
			  Thread.sleep(2000);
			  driver.switchTo().alert().accept();
			  System.out.println("Clicked OK"); 
			  }
				 a--;
			  }	 
			  
			  
			// Invalid login case 4 	  
			  WebElement email3=driver.findElement(By.id("email"));
			  WebElement password3=driver.findElement(By.id("password"));
			  WebElement login3=driver.findElement(By.id("submit"));
			  System.out.println("Invalid test data 4");
			  email3.sendKeys("admin");
			  password3.sendKeys("demoadmin");
			  System.out.println("login clicked");
			  login3.click();
			  String expected_url="https://phptravels.net/admin/dashboard.php";
			  String actual_url = driver.getCurrentUrl();

			  if(expected_url!=actual_url)
				  System.out.println("Invalid login");
			  Thread.sleep(2000);
	  }
@AfterTest
public void afterTest() 
{
	driver.quit();
}
	  
}
