package com.headhunters.automation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	
  public final static String URL = "http://localhost:4200";	
  
  public WebElement txtUserName;
  public WebElement txtPassword;
  public WebElement btnLogin;
  public WebElement btnLogout;
  public WebDriver webDriver;
  
  @BeforeTest
  public void setup() {
	  
	  System.setProperty("webdriver.chrome.driver", "F:\\Studies\\Esoft\\MSC\\C17260 SQE\\GroupProject\\automation\\chromedriver.exe");
	  webDriver = new ChromeDriver();
	  webDriver.navigate().to(URL);
	  webDriver.manage().window().maximize();
	  
	  txtUserName = webDriver.findElement(By.id("userName"));
	  txtPassword = webDriver.findElement(By.id("password"));
	  btnLogin = webDriver.findElement(By.xpath("//*[@type=\"submit\"]"));
	  
	  
  }
  
  @Test 
 
  public void testValidCredentials() {
	  txtUserName.sendKeys("test1");
	  txtPassword.sendKeys("test1");
	  btnLogin.click();
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  assertEquals(webDriver.getCurrentUrl(),  URL+"/job-seeker-home");
  }
  
  @Test
  public void testInvalidUserName() {
	  txtUserName.sendKeys("test11");
	  txtPassword.sendKeys("test1");
	  btnLogin.click();
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
  
  
  
  
  
  
  @AfterTest
  public void closeBrowser() {
	  txtUserName.clear();
	  txtPassword.clear();
	  
	  webDriver.close();
  }
  
}
