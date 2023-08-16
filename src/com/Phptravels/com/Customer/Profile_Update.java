package com.Phptravels.com.Customer;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;


public class Profile_Update 
{
	WebDriver driver;
	WebElement name;
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
	  driver.findElement(By.id("email")).sendKeys("user@phptravels.com");
	  driver.findElement(By.id("password")).sendKeys("demouser");
	  driver.findElement(By.id("submitBTN")).click();
	  }
	
	
//	To update address in profile by accepting test values
	@Test
  public void updateProfile() throws InterruptedException 
	{
		//Click My Profile
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[1]/div[2]/ul/li[3]")).click(); 
		//Update the details
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("demouser");
		WebElement country_txt=driver.findElement(By.xpath("//*[@id=\"profile\"]/div/div[3]/div[2]/div/div"));
		country_txt.click();
		System.out.println("in dropdown text");
		WebElement country_code=driver.findElement(By.xpath("//*[@id=\"bs-select-1-99\"]"));
		country_code.click();	
		WebElement phone=driver.findElement(By.id("Phone"));
		phone.clear();
		phone.sendKeys("251365448996");
		Thread.sleep(2000);		
		WebElement country=driver.findElement(By.xpath("//*[@id=\"profile\"]/div/div[4]/div[1]/div/div/button"));
		country.click();
		WebElement country_name=driver.findElement(By.xpath("//*[@id=\"bs-select-2-99\"]"));
		country_name.click();		
		WebElement state=driver.findElement(By.id("State"));
		state.clear();
		state.sendKeys("Kerala");
		WebElement city=driver.findElement(By.id("City"));
		city.clear();
		city.sendKeys("Kochi");
		WebElement address1=driver.findElement(By.name("address1"));
		address1.clear();
		address1.sendKeys("abcd, efghijklm, opqrst");
		WebElement address2=driver.findElement(By.name("address2"));
		address2.clear();
		address2.sendKeys("uvwxyz, asdfgf, lkjhgh");
		
		WebElement update_profile=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		update_profile.click();
		Thread.sleep(2000);
	}
  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
