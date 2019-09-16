package com.heka.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.heka.PageObjects.AdminStatsPage;
import com.heka.PageObjects.LoginPage;
import com.heka.PageObjects.TabsNavigationPage;

import resources.base;

public class Admin_Stats_Test extends base {
	public static Logger log = LogManager.getLogger(Admin_Stats_Test.class.getName());
	
	String projectpath = System.getProperty("user.dir");
	
	@BeforeMethod
	public void setUp() throws IOException {
		log.info("===============ADMIN STATS TEST STARTS HERE=====================");	
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test
	public void admin_Stats() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		LoginPage login = new LoginPage(driver);
		
		//Enter login details
		login.getMobile().sendKeys("9441053222");
		log.info("Entered valid mobile number");
		login.getPassword().sendKeys("12341234");
		log.info("Entered valid password");
		
		//CLick on SIGN IN button
		login.Signin().click();
		log.info("Logged in");
		Thread.sleep(3000);
		
		//Get doctor name, get page title and verify assertion
		log.info("Logged in Doctor is: " + login.physicianDetails().getText());
		Assert.assertEquals(login.getUsername().getText(), "KD");
		log.info("Logged in Doctor name is successfully verified");
		String title = driver.getTitle();
		log.info("The Page Title is: " + title);
		
		TabsNavigationPage tabs=new TabsNavigationPage(driver);
		
		//Click on Admin tab
		tabs.getAdmin().click();		
		log.info("Clicked on Admin tab");
		
		AdminStatsPage stats = new AdminStatsPage(driver);
		
		//Clicked on Stats drop down value from Admin tab
		stats.stats_Dropdown_Value().click();
		log.info("Clicked on Stats from drop down");
		
		//Enter number of weeks of data required
		stats.StatsDuration().click();
		stats.StatsDuration().clear();
		stats.StatsDuration().sendKeys("2");
		log.info("Entered duration");
		
		//Run Statistics
		stats.runStats().click();
		Thread.sleep(15000);
		log.info("Ran statistics");
		
		//Switch to confirmation pop up
		stats.switchToWindow();
		Thread.sleep(10000);
		
		//Click Quadrants
		stats.runQuadrants().click();
		log.info("Clicked on Quadrants button");
		Thread.sleep(3000);
		stats.browse_Button().click();
		log.info("Clicked on browse button");
		Thread.sleep(2000);
		
		//Run Autoit script to upload a file		
		Runtime.getRuntime().exec(projectpath + "\\src\\test\\java\\resources\\FileUpload.exe");
		Thread.sleep(10000);
		log.info("Excel file uploaded using Autoit");		
		stats.switchToWindow();
		Thread.sleep(10000);
		
		// Select from which week need to run statistics
		String fromWeek = "#mat-tab-content-1-1 > div > div:nth-child(1) > tbody > tr > td:nth-child(3) > select";
		String toWeek = "/html/body/app-root/app-avg-stats/mat-tab-group/div/mat-tab-body[2]/div/div[1]/tbody/tr/td[4]/select";
		Select select1 = new Select(driver.findElement(By.cssSelector(fromWeek)));
		select1.selectByIndex(2);
		Thread.sleep(2000);
		select1.selectByIndex(1);
		log.info("From Week is selected to run stats");

		// Select to which week need to run statistics
		Select select2 = new Select(driver.findElement(By.xpath(toWeek)));
		select2.selectByIndex(1);
		Thread.sleep(2000);
		select2.selectByIndex(2);
		log.info("To Week is selected to run stats");

		// Run stats
		stats.run().click();
		Thread.sleep(10000);
		log.info("Run Statistics successful");    
	    
	    //Switch to confirmation pop up window
	    stats.switchToWindow();
		Thread.sleep(5000);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("=================== ADMIN STATS TEST ENDS HERE *************************");
		System.out.println("##############################################################################################################################################");


	}

}


