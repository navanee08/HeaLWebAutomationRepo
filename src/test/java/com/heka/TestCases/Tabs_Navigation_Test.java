package com.heka.TestCases;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.LoginPage;
import com.heka.PageObjects.TabsNavigationPage;
import resources.base;

public class Tabs_Navigation_Test extends base {
	public static Logger log = LogManager.getLogger(Tabs_Navigation_Test.class.getName());

	@BeforeMethod
	public void setUp() throws IOException {
		log.info("=============== TABS NAVIGATION TEST STARTS HERE ===============");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test
	public void tabsNavigation() throws IOException, InterruptedException {

		LoginPage login = new LoginPage(driver);

		// Enter login details
		login.getMobile().sendKeys("9441053222");
		log.info("Entered valid mobile number");
		login.getPassword().sendKeys("12341234");
		log.info("Entered valid password");

		// Click on SIGN IN button
		login.Signin().click();
		log.info("Logged in");
		Thread.sleep(3000);

		// Get doctor name and get page title and then verify assertion
		log.info("Logged in Doctor is: " + login.physicianDetails().getText());
		Assert.assertEquals(login.getUsername().getText(), "KD");
		log.info("Logged in Doctor name is verified - Assetion passed");
		String title = driver.getTitle();
		log.info("The Page Title is: " + title);

		TabsNavigationPage tabs = new TabsNavigationPage(driver);

		// Click on dash board tab
		tabs.getdashboard().click();
		Thread.sleep(2000);
		log.info("Clicked on Dashboard tab");

		// Click on My Schedule tab
		tabs.getMySchedule().click();
		Thread.sleep(2000);
		log.info("Clicked on My Schedule tab");

		// Click on Track My Patients Tab
		tabs.getTrackMyPatientsTab().click();
		Thread.sleep(2000);
		log.info("Clicked on Track My Patients tab");

		// Click on Admin Tab
		tabs.getAdmin().click();
		log.info("Clicked on Admin tab");
		Thread.sleep(5000);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("=============== TABS NAVIGATION TEST ENDS HERE =================");
		System.out.println("##############################################################################################################################################");


	}

}


