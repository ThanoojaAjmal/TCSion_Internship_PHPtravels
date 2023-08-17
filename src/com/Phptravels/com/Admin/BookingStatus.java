package com.Phptravels.com.Admin;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookingStatus 
{
    WebDriver driver;
	WebElement email;
	WebElement password;
	WebElement login;
	WebDriverWait wait;
	
						// Change booking status from pending to confirmed and verify count in Dashboard
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
		  
		  // Get the booking count before confirmation
		  WebElement dash_count=driver.findElement(By.xpath("/html/body/main/section/div[2]/div[1]/div[3]/div/div/div/div[1]/div[2]"));
			 String count=dash_count.getText();
			 System.out.println("count before confirming "+count);
		  
	  }
	 
	 @Test(priority = 1) 				// Change pending status to confirmed
	 
  public void pendingToConfirmed() throws InterruptedException 
	 {		
		 WebElement booking=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/main/header/ul/li[10]/a")));	  
		  booking.click(); 	
		  Thread.sleep(2000);
		  String actual_url=driver.getCurrentUrl();
		  String current_url="https://phptravels.net/admin/bookings.php";
		  Assert.assertEquals(actual_url, current_url);						//Verify Bookings link
		  
		  
		//select booking status as Pending

		  Select booking_status=new Select(driver.findElement(By.name("booking_status"))); 
		  booking_status.selectByVisibleText("Pending");
		  System.out.println("Booking status "); 
		  
		//Click search button
		  WebElement submit=driver.findElement(By.xpath("//button[text()='Search']"));
	      submit.click();
	      System.out.println("clicked search ");
	     
int details=driver.findElements(By.xpath("/html/body/main/section/div[2]/div/div[2]/figure/blockquote[2]/div/span/a")).size();// Check if element is present
	      if(details>0)
	     {
	       WebElement booking_details=driver.findElement(By.xpath("/html/body/main/section/div[2]/div/div[2]/figure/blockquote[2]/div/span/a"));
	       booking_details.click();
		   Thread.sleep(2000);
		   
		 //saving window handles
		   
		   Set<String> w = driver.getWindowHandles();
		      // window handles iterate
		      Iterator<String> t = w.iterator();
		      String pw = t.next();
		      String ch = t.next();
		      // switching child window
		      driver.switchTo().window(ch);
		      System.out.println("Child window title "+ driver.getTitle());	      
		      
		      Thread.sleep(2000);
		  	  WebElement proceed=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"form\"]")));
			  proceed.click();  
			  
			  Actions actions = new Actions(driver);		  
			   
			  //Move to payment window   
			  WebElement payment_window=driver.findElement(By.xpath("/html/body/div[1]/div[1]"));
			  actions.moveToElement(payment_window);
			  Thread.sleep(2000);
				   
				   
			  WebElement paypal=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"paypal-button\"]")));
			  paypal.click();
			  Thread.sleep(8000);	      
		      
			  // close the child browser window
		      driver.close();
		      
		      // switching parent window
		      driver.switchTo().window(pw);
		      System.out.println("Child window title "+ driver.getTitle());	    
	  	    }  	

	      }	 

@AfterTest
public void afterTest() throws InterruptedException
{
	WebElement dash=driver.findElement(By.xpath("/html/body/main/header/div[1]/a[1]/span"));
	dash.click();
	Thread.sleep(2000);
	 WebElement dash_count=driver.findElement(By.xpath("/html/body/main/section/div[2]/div[1]/div[3]/div/div/div/div[1]/div[2]"));
	 String count=dash_count.getText();
	 System.out.println("count after status changed to confirmed "+count);
	 driver.close();
}
}