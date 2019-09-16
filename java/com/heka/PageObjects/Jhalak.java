package com.heka.PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Jhalak {
	
	WebDriver driver;
	
	@Test
	public void selectDropdown() throws InterruptedException {
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://jobs.jhalak.com/jobs/My-Skills.aspx?mode=edit");
		
		driver.findElement(By.id("ctl00_MainContent_txtEmail")).sendKeys("harika.chiluka17@gmail.com");
		driver.findElement(By.id("ctl00_MainContent_txtPwd")).sendKeys("jhalak@123");
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_btnLogin\"]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"InnerMenu\"]/div/ul/li[5]")).click();
		Thread.sleep(5000);
		
		//Selecting specialized area
		String areaXpath = "//*[@id=\"ctl00_ContentPlaceHolder1_lstSpeArea\"]";		
		Select areaElement = new Select(driver.findElement(By.xpath(areaXpath)));
		areaElement.selectByVisibleText("Java-J2EE");
		Thread.sleep(5000);
		
		//Selecting Specialized Skill
		String skillsXpath = "//*[@id=\"ctl00_ContentPlaceHolder1_lstSpeSkill\"]";
		Select skillsElement = new Select(driver.findElement(By.xpath(skillsXpath)));
		skillsElement.selectByVisibleText("Java Web Services");
		Thread.sleep(5000);
		
		//CLicking Add button
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnAddSkill")).click();
		Thread.sleep(5000);
		
		
	}
	
	
	
	

}
