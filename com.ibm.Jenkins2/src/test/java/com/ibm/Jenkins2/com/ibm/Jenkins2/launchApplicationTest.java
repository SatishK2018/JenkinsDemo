package com.ibm.Jenkins2.com.ibm.Jenkins2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class launchApplicationTest {
	private WebDriver driver;
	private String actualResult,expectedResult;
  @Test
  public void loginToAppTest() {
	  WebElement userName = driver.findElement(By.id("cyclosUsername"));
	  WebElement password = driver.findElement(By.id("cyclosPassword"));
	  WebElement loginBtn = driver.findElement(By.xpath("//INPUT[@type='submit']"));
	  
	  userName.sendKeys("admin");
	  password.sendKeys("1234");
	  loginBtn.click();
	  
	  String actualResult = "Application status"; 
	  String expectedResult = driver.findElement(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody/tr[1]/td[1]")).getText();		  
	  assertEquals(actualResult, expectedResult);
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\SATISHKALE\\Downloads\\IBM\\Upskill Program - Selenium\\SeleniumSetUpFiles\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://ec2-13-233-153-88.ap-south-1.compute.amazonaws.com:8080/web/do/login");
	  actualResult = "Bank Application";
	  expectedResult = driver.getTitle();
	  assertEquals(actualResult,expectedResult);
  }

 
@AfterTest
  public void afterTest() {
	  driver.close();
  }

}
