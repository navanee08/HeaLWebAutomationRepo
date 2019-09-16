package com.heka.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.CreateChallengePage;
import com.heka.PageObjects.LoginPage;
import resources.base;

public class Create_Challenge_Test extends base {
	public static Logger log = LogManager.getLogger(Create_Challenge_Test.class.getName());

	@BeforeMethod
	public void setUp() throws IOException {
		log.info("=============== CREATE CHALLENGE TEST STARTS HERE =====================");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test
	public void create_Challenge() throws IOException, InterruptedException {
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

		CreateChallengePage challenge = new CreateChallengePage(driver);

		// Hovering on admin tab
		WebElement target1 = driver.findElement(By.cssSelector("#navbar3 > ul:nth-child(1) > li.dropdown"));
		Actions action = new Actions(driver);
		action.moveToElement(target1).build().perform();
		log.info("Hovering on admin");

		// Click on Challenges from admin tab
		challenge.getChallenges().click();
		Thread.sleep(3000);
		log.info("Clicked on Challenges from admin");
		
		// Enter challenge description
		challenge.description().click();
		challenge.description().sendKeys("5000_Steps_Challenge_Ten_Points");
		log.info("Entered Challenge description");

		// Run Autoit script to upload 5000 steps challenge image
		challenge.choose_File().click();// Click on "Choose file" button
		Thread.sleep(3000);
		String projectpath = System.getProperty("user.dir");
		Runtime.getRuntime().exec(projectpath + "\\src\\test\\java\\resources\\ChallengeImage.exe");
		Thread.sleep(3000);
		challenge.upload_Image_Button().click();// Upload image file
		Thread.sleep(3000);
		challenge.switchToWindow();// Switch to confirmation pop up
		Thread.sleep(3000);
		log.info("Steps challenge image uploaded successfully using Autoit");

		// Select challenge type
		challenge.challengeType();
		log.info("Selected challege type Exercise");

		// Select item
		challenge.enterAndSelectItemType();
		log.info("Selected item type steps");

		// Challenge frequency
		challenge.challengeFreq();
		log.info("Selected Challenge frequency Daily");

		// Challenge points
		challenge.challengePoints().sendKeys("10");
		log.info("Entered challenge points ");

		// Challenge goal
		challenge.challengeStepsGoal().sendKeys("5000");
		log.info("Entered challenge steps goal ");

		// Challenge goal steps or grams
		challenge.goal_In_Grams_Or_Steps();
		log.info("Selected goal Steps from drop down");

		// Enter max challenge points
		challenge.maxChallengePoints().sendKeys("1000");		
		log.info("Entered maximum challenge points");

		// Select challenge Start Date
		challenge.challengeStartDate();
		log.info("Challenge start date selected");

		// Select challenge End Date
		challenge.challengeEndDate();
		log.info("Challenge end date selected");
		
		// Save the challenge
		challenge.save_Button().click();
		Thread.sleep(10000);
		log.info("Challenge end date selected");
		
		//Switch to pop up window
		challenge.switchToWindow();
		Thread.sleep(3000);

	}

	@AfterMethod
	public void tearDown() {
		//driver.close();
		//driver = null;
		log.info("Driver is closed");
		log.info("===================CREATE CHALLENGE TEST ENDS HERE=====================");
		System.out.println("##############################################################################################################################################");

	}

}

