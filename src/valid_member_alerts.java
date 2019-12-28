//This script shows the execution of the login page and member alerts with valid data


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class valid_member_alerts 
{
	WebDriver driver;
  @Test (priority = 1)
  public void login() 
  {
	  driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
	  driver.findElement(By.xpath("//input[@value='1']")).click();
	  driver.findElement(By.xpath("//input[@value='2']")).click();
	  driver.findElement(By.xpath("//input[@value='3']")).click();
	  driver.findElement(By.xpath("//input[@value='4']")).click();
	  driver.findElement(By.xpath("//input[@value='Submit']")).click();
  }
  @Test (priority = 2)
  public void memberalerts() 
  {
	  String expres="Cyclos";
	  String actres=driver.getTitle();
	  assertEquals(expres,actres);
	  driver.findElement(By.xpath("//span[text()='Alerts']")).click();
	  driver.findElement(By.xpath("//span[text()='Alerts History']")).click();
	  driver.findElement(By.id("typeSelect")).click();
	  WebElement testDropDown = driver.findElement(By.id("typeSelect"));
	  Select dropdown = new Select(testDropDown);
	  dropdown.selectByValue("MEMBER");
	  driver.findElement(By.xpath("//input[@name='query(period).begin']")).sendKeys("12/12/2013");
	  driver.findElement(By.xpath("//input[@name='query(period).end']")).sendKeys("27/12/2016");
	  driver.findElement(By.id("memberUsername")).sendKeys("pinkubhui");
	  driver.findElement(By.id("memberName")).sendKeys("pinkubhui");
	  driver.findElement(By.xpath("//input[@value='Search']")).click();
  }
  @Test (priority = 3)
  public void Mo()
  {
	  String expected ="Search results";
	  WebElement res = driver.findElement(By.xpath("//table[2]/tbody/tr[1]/td[1]"));
	  String actual = res.getText();
	  assertEquals(actual,expected);
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  
  }

  @AfterMethod
  public void afterMethod() 
  {
	  
  }

  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.get("http://localhost:8585/do/login ");
  }

  @AfterTest
  public void afterTest() 
  {
	  
  }

}
