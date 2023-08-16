package com.Phptravels.com.Admin;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class DeleteCancelled 
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
/*	  @Test(priority=1) //Complete the cancellation request and delete the record
	  
	  public void delete_transac() throws InterruptedException 
	  {
		  WebElement cancel=driver.findElement(By.xpath("/html/body/main/section/div[2]/div[2]/div[2]/div/div[2]/ul/li/div/span"));
		  cancel.click();
		  driver.switchTo().alert().accept();
	  }*/
@Test(priority=2) //access items in  a list
	  
	  public void access_list() throws InterruptedException 
	  {
/*	 	driver.findElement(By.xpath("/html/body/main/section/div[2]/div[2]/div[2]/div/div[2]/ul"));
	 	WebElement liElements = driver.findElement(By.xpath("/html/body/main/section/div[2]/div[2]/div[2]/div/div[2]/ul/li[1]"));
	 	List<WebElement> ListItems = liElements.findElements(By.tagName("li"));
	 	for (WebElement e : ListItems) 
	 	{
            System.out.println("List Item Text : " + e.getText());
            System.out.println("List Item HTML : " + e.getAttribute("innerHTML") + "\n");*/
	
	List<WebElement> allElements = driver.findElements(By.xpath("/html/body/main/section/div[2]/div[2]/div[2]/div/div[2]/ul"));
    System.out.println(allElements);

    for (WebElement element: allElements) 
    {
        System.out.println(element.getText());
        element.click();          
	  }
  /*  for (WebElement row: allElements)
    {
    	
    }*/
	  }
}
