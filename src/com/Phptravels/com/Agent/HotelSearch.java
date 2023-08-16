package com.Phptravels.com.Agent;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

									// To search and display hotels by City
public class HotelSearch 
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
	
  @Test
  	  public void hotel_Search() throws InterruptedException 
	  {
		  WebElement hotel=driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[1]/ul/li[2]/a"));
		  hotel.click();		  
		  WebElement search=driver.findElement(By.xpath("//*[@id=\"hotels-search\"]/div/div[1]/div[1]/span"));
		  search.click();
		  WebElement city=driver.findElement(By.xpath("//*[@id=\"select2-hotels_city-results\"]/div/div[1]/div/strong/small"));
		  city.click();
		  Thread.sleep(2000);
		  WebElement search_btn=driver.findElement(By.xpath("//*[@id=\"hotels-search\"]/div/div[5]/button"));
		  search_btn.click();
		  Thread.sleep(2000);
	  }    

  @AfterTest
  public void afterTest() 
  {
	 driver.close(); 
  }

}
