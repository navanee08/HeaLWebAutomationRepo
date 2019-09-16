package com.heka.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.AddUsersToChallengePage;
import com.heka.PageObjects.LoginPage;
import resources.base;

public class Add_Users_And_Run_Challenge_Test extends base {
	public static Logger log = LogManager.getLogger(Add_Users_And_Run_Challenge_Test.class.getName());

	@BeforeMethod
	public void setUp() throws IOException {
		log.info("=============== ADD USERS TO CHALLENGE AND RUN PONTIFICATION TEST STARTS HERE =====================");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("qaUrl"));
		log.info("Launching Application URL");
	}

	@Test(timeOut=120000)
	public void add_Users_To_Challenge() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		LoginPage login = new LoginPage(driver);

		// Entered mobile number
		login.getMobile().sendKeys("9441053222");
		log.info("Entered valid mobile number");

		// Entered password
		login.getPassword().sendKeys("12341234");
		log.info("Entered valid password");

		// Click on SIGN IN button
		login.Signin().click();
		log.info("Logged in");
		Thread.sleep(3000);

		// Get doctor name, get page title, and verify assertion
		log.info("Logged in Doctor is: " + login.physicianDetails().getText());
		Assert.assertEquals(login.getUsername().getText(), "KD");
		log.info("Logged in Doctor name is successfully verified");
		String title = driver.getTitle();
		log.info("The Page Title is: " + title);

		AddUsersToChallengePage users = new AddUsersToChallengePage(driver);

		// Hovering on admin tab
		WebElement target1 = driver.findElement(By.cssSelector("#navbar3 > ul:nth-child(1) > li.dropdown"));
		Actions action = new Actions(driver);
		action.moveToElement(target1).build().perform();
		log.info("Hovering on admin");

		// Click on Challenges from admin tab
		users.getChallenges().click();
		Thread.sleep(3000);
		log.info("Clicked on Challenges from admin");
		
		// Click users tab
		users.add_Users_Tab().click();
		Thread.sleep(10000);
		
		//Select active challenge
		String activeChallegesDropdown = "/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[2]/div/div/div[1]/div/div/select";
		Select activeChallenge = new Select(driver.findElement(By.xpath(activeChallegesDropdown)));
		activeChallenge.selectByVisibleText("5000_Steps_challenge_ten_points");
		Thread.sleep(5000);
		log.info("Active Challenge is selected");
		
		// Select all users check box
		users.get_All_Users_Button().click();
		log.info("Clicked on GET ALL USERS button");
		
		// Select all users check box
		users.select_All_Users().click();
		log.info("All users check box is selected - all users added");

		// Get all users to challenge
		users.get_All_Users_In_Challenge().click();
		log.info("Clicked on GET ALL USERS IN CHALLENGE button");

		// Add users to challenge to run
		users.add_Users_To_Challenge().click();
		log.info("Clicked on ALL USERS TO CHALLENGE button and ready to run pontification");

		// Run challenge
		users.run_Challenge().click();
		Thread.sleep(5000);
		log.info("Pontification has been run successfully");

		//Switch to Challenge saved successfully pop up message window
		users.switchToWindow();
		Thread.sleep(10000);
		
		//Switch to Pontification successful pop up message window
		users.switchToWindow();
		Thread.sleep(10000);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("===================ADD USERS TO CHALLENGE TEST ENDS HERE=====================");
		System.out.println("##############################################################################################################################################");

	}

}

