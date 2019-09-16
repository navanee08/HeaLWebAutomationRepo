package com.heka.TestCases;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.DeleteChallengePage;
import com.heka.PageObjects.LoginPage;
import resources.base;

public class Delete_Challenge_Test extends base {
	public static Logger log = LogManager.getLogger(Delete_Challenge_Test.class.getName());

	@BeforeMethod
	public void setUp() throws IOException {
		log.info("=============== DELETE CHALLENGE TEST STARTS HERE =====================");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test
	public void delete_Challenge() throws IOException, InterruptedException {

		LoginPage login = new LoginPage(driver);

		// Enter mobile number
		login.getMobile().sendKeys("9441053222");
		log.info("Entered valid mobile number");

		// Enter password
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

		DeleteChallengePage challenge = new DeleteChallengePage(driver);

		// Hovering on admin tab
		String cssPath = "#navbar3 > ul:nth-child(1) > li.dropdown";
		WebElement target1 = driver.findElement(By.cssSelector(cssPath));
		Actions action = new Actions(driver);
		action.moveToElement(target1).build().perform();
		log.info("Hovering on admin");

		// Click on Challenges from admin tab
		challenge.getChallenges().click();
		Thread.sleep(3000);
		log.info("Clicked on Challenges from admin");
				
		// Delete challenge
		challenge.delete_Challenge().click();
		Thread.sleep(5000);
		log.info("Clicked on delete button to delete a challenge");
		
		//Switch to Delete Confirm Popup window
		challenge.switchToDeleteConfirmPopUP();
		Thread.sleep(3000);
		
		// Switch to Delete Success Popup Window
		challenge.switchToDeleteSuccessPopup();
		Thread.sleep(3000);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("==========DELETE CHALLENGE TEST ENDS HERE===========");
		System.out.println("##############################################################################################################################################");

	}

}

