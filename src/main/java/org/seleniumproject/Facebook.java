package org.seleniumproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Facebook {
	
	public ChromeDriver driver;

	@BeforeMethod
	public  void invokeBrowser() {
	
	driver= new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.facebook.com/");
	}
	@Test
	public void signUpAccount() {
	driver.findElement(By.linkText("Create new account")).click(); 
	driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("bhuvana");
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("eswari");
	driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("eswari01@gmail.com");
	driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("eswari01@gmail.com");
	driver.findElement(By.xpath("//input[@name='reg_passwd__'and @type='password']")).sendKeys("onlinebook@01");
	WebElement days = driver.findElement(By.id("day"));
	WebElement months = driver.findElement(By.id("month"));
	WebElement years = driver.findElement(By.id("year"));
	Select daysdrop=new Select(days);
	daysdrop.selectByVisibleText("23");
	Select monthsdrop=new Select(months);
	monthsdrop.selectByVisibleText("Feb");
	Select yearsdrop=new Select(years);
	yearsdrop.selectByVisibleText("1988");
	WebElement femalebutton=driver.findElement(By.xpath("//label[text()='Female']"));
	femalebutton.click();
	WebElement submitbutton=driver.findElement(By.xpath("//button[text()='Sign Up']"));
	
	submitbutton.click();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}

