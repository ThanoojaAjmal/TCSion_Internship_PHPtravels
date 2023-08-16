package com.Phptravels.com.Admin;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.Set;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import java.util.Iterator;

								// Test link Bookings and display Booking Invoice where payment is successful
public class DisplayPaid 
{
	WebDriver driver;
	WebElement email;
	WebElement password;
	WebElement login;
	WebDriverWait wait;
	
	
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
	 
	//Display booking invoice where payment is successful 
 @Test   
  public void displayPaid() throws InterruptedException 
  {
	  
	//Navigate through Bookings/ Paid / Confirmed
	  WebElement booking=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/main/header/ul/li[10]/a")));	  
	  booking.click(); 	
	  Thread.sleep(2000);
	  String actual_url=driver.getCurrentUrl();
	  String current_url="https://phptravels.net/admin/bookings.php";
	  Assert.assertEquals(actual_url, current_url);						//Verify Bookings link
	  
	//select status as Paid
	  Select payment_status=new Select(driver.findElement(By.name("payment_status"))); 
	  payment_status.selectByVisibleText("Paid");
	  System.out.println("Payment status ");
	  Thread.sleep(2000);
	  String parent=driver.getWindowHandle();	  
		  
	//select booking status as Confirmed
	  Select booking_status=new Select(driver.findElement(By.name("booking_status"))); 
	  booking_status.selectByVisibleText("Confirmed");
	  System.out.println("Booking status "); 
	  
	//Click search button
	  WebElement submit=driver.findElement(By.xpath("//button[text()='Search']"));
      submit.click();
      System.out.println("clicked search ");
	  
	  //Display booking details of successful payment

      int details=driver.findElements(By.xpath("/html/body/main/section/div[2]/div/div[2]/figure/blockquote[2]/div/span/a")).size();// Check if element is present

      if(details>0)
     {
       WebElement booking_details=driver.findElement(By.xpath("/html/body/main/section/div[2]/div/div[2]/figure/blockquote[2]/div/span/a"));
       booking_details.click();
	   Thread.sleep(5000);
     }
      else
      System.out.println("No bookings made");	  
   
  //saving child windows
  	Set<String> childwindows=driver.getWindowHandles();
  	Iterator<String> i=childwindows.iterator();
  //Switch to child window
  	while(i.hasNext())
  	{
  		String childwindow=i.next();
  		if(!parent.equals(childwindow))
  		{
  		driver.switchTo().window(childwindow);
  		System.out.println(driver.getCurrentUrl());  		
  		driver.close();								//close child window
  		}
  	}
  	driver.switchTo().window(parent);
  	Thread.sleep(2000);  	
  }
 
  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }
}
