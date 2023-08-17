package com.Phptravels.com.Admin;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DeleteCancelled 
{
	WebDriver driver;
	WebElement email;
	WebElement password;
	WebElement login;
	WebDriverWait wait;
  
						//Delete a record having booking status as cancelled
	  @BeforeTest
	  public void beforeTest() throws InterruptedException 
	 {
		 System.setProperty("webdriver.chrome.driver", "D:\\Software_testing_course\\Internship\\Php_TCSiON\\Drivers\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://phptravels.net/admin/login.php");
		  driver.manage().window().maximize();
		  Thread.sleep(2000);
		   email=driver.findElement(By.id("email"));
		   password=driver.findElement(By.id("password"));
		   login=driver.findElement(By.id("submit"));
		  wait=new WebDriverWait(driver, 15);
		  
		  // Login
		  
		  email.sendKeys("admin@phptravels.com");
		  password.sendKeys("demoadmin");
		  login.click();
		  System.out.println("Login clicked ");
		  Thread.sleep(2000);		  
		} 

  
	  @Test(priority = 1) //Complete the cancellation request and check if record is deleted
	  
	  public void delete_transac() throws InterruptedException 
	  {
		  
		  
		 Thread.sleep(2000);
		 WebElement booking=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/main/header/ul/li[10]/a")));	  
		booking.click(); 	
		
		String actual_url=driver.getCurrentUrl();
		String current_url="https://phptravels.net/admin/bookings.php";
		Assert.assertEquals(actual_url, current_url);	
		
		// Select booking status as Cancelled
		Select booking_status=new Select(driver.findElement(By.name("booking_status"))); 
		booking_status.selectByVisibleText("Cancelled");
		System.out.println("Booking status "); 
		
		// Click search
		 WebElement submit=driver.findElement(By.xpath("//button[text()='Search']"));
	     submit.click();
	     System.out.println("clicked search ");
		 Thread.sleep(2000);
		
		System.out.println("no entries");
		
	  }

	  @AfterTest
	  public void after_test()
	  {
		  driver.close();
		  
	  }
}

