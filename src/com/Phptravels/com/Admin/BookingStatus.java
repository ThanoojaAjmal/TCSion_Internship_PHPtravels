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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookingStatus 
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
	 
	 @Test 				// Change pending status to confirmed
  public void pendingToConfirmed() throws InterruptedException 
	 {
		 WebElement booking=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/main/header/ul/li[10]/a")));	  
		  booking.click(); 	
		  Thread.sleep(2000);
		  String actual_url=driver.getCurrentUrl();
		  String current_url="https://phptravels.net/admin/bookings.php";
		  Assert.assertEquals(actual_url, current_url);						//Verify Bookings link
		  
		//select booking status as Pending
//		  WebElement booking_id=driver.findElement((By.xpath("//*[@id=\"search\"]/div[1]/div/input")));
//		  booking_id.sendKeys("20230811104447");
		  Select booking_status=new Select(driver.findElement(By.name("booking_status"))); 
		  booking_status.selectByVisibleText("Pending");
		  System.out.println("Booking status "); 
		  
		//Click search button
		  WebElement submit=driver.findElement(By.xpath("//button[text()='Search']"));
	      submit.click();
	      System.out.println("clicked search ");
	      String parent=driver.getWindowHandle();
	      
	      int details=driver.findElements(By.xpath("/html/body/main/section/div[2]/div/div[2]/figure/blockquote[2]/div/span/a")).size();// Check if element is present

	      if(details>0)
	     {
	       WebElement booking_details=driver.findElement(By.xpath("/html/body/main/section/div[2]/div/div[2]/figure/blockquote[2]/div/span/a"));
	       booking_details.click();
		   Thread.sleep(5000);
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
		  		String parent1=driver.getWindowHandle();
		  		
		  		Thread.sleep(2000);
		  		WebElement proceed=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"form\"]")));
				   proceed.click();
				   
				   Actions actions = new Actions(driver);
				   
				  
	/*			   Set <String> allHandles=driver.getWindowhandles();//return all window handles opened by current driver instance
				   Iterator<String> j=allHandles.iterator();
				   while(allHandles.hasNext())
				   {
				     if (allHandles!=parentHandle)
				     {
				         WebDriver popup=driver.switchTo().window(allHandles);*/
				   
				   
				   WebElement payment_window=driver.findElement(By.xpath("/html/body/div[1]/div[1]"));
				   actions.moveToElement(payment_window);
	//			   String popupPageSource=popup.getPageSource();
				   Thread.sleep(2000);
				   
				   WebElement paypal=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@id='jsx-iframe-3f5c67777b']")));
			   driver.switchTo().frame(paypal);//img[@role='presentation']
				   paypal.click();
				   
				  
//		  		driver.close();								//close child window 
		  		}
		  	}
		   
/*   //iframe[@id='jsx-iframe-3f5c67777b']
 //*[@id=\"jsx-iframe-68111648a0\"]		 iframe
 
  	//*[@id=\"zoid-paypal-buttons-uid_aff5a4983c_mta6mji6mty\"]
  
  	 //*[@id="buttons-container"]
  	   //*[@id="smart-menu"]
  	    //*[@id="installments-modal"]
  	    //*[@id="zoid-paypal-buttons-uid_aff5a4983c_mta6mji6mty"]/iframe[2]
  	     //*[@id="jsx-iframe-68111648a0"]
  	     //*[@id="buttons-container"]/div/div/div
  	      //*[@id="buttons-container"]
  	 //*[@id="jsx-iframe-68111648a0"]
  	 //*[@id="paypal-button"]
  	  //img[@role='presentation']
  	   
  	  */
  	
 
	     }
	      else
	      System.out.println("No bookings made");	
		  
	 }
	 
	 
}
