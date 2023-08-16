package com.Phptravels.com.Agent;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

									// Update USD to INR
public class Currency 
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
//Login to user: Agent		  
		  WebElement email=driver.findElement(By.id("email"));
		  WebElement password=driver.findElement(By.id("password"));
		  WebElement login=driver.findElement(By.id("submitBTN"));
		  email.sendKeys("agent@phptravels.com");
		  password.sendKeys("demoagent");
		  login.click();
		  Thread.sleep(2000);
	  }
	 
//Test case to update currency from USD to INR	 
  @Test 
  public void update_currency() 
  {
	  Actions action= new Actions(driver);
	  WebElement currency=driver.findElement(By.xpath("//a[@class=\"nav-link dropdown-toggle btn px-0 ps-3 text-center d-flex align-items-center justify-content-center gap-1 waves-effect\"]"));
	  WebElement INR=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[2]/ul/li[2]/ul/li[4]/a"));
	  action.moveToElement(currency);
	  currency.click();
	  action.moveToElement(INR);
	  INR.click();  
  } 

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
