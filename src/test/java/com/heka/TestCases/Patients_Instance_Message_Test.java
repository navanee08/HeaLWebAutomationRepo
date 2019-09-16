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
import com.heka.PageObjects.TrackMyPatientsPage;

import resources.base;

public class Patients_Instance_Message_Test extends base {
	public static Logger log = LogManager.getLogger(Patients_Instance_Message_Test.class.getName());
	
	@BeforeMethod
	public void setUp() throws IOException {
		log.info("========TRACK MY PATIENTS INSTANCE MESSAGE TEST STARTS HERE=====");	
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test
	public void sendingInstanceMessageToPatient() throws IOException, InterruptedException {

		LoginPage login = new LoginPage(driver);
		
		//Enter login details
		login.getMobile().sendKeys("9441053222");
		log.info("Entered valid mobile number");
		login.getPassword().sendKeys("12341234");
		log.info("Entered valid password");
		
		//Click on SIGN IN button
		login.Signin().click();
		log.info("Logged in");
		Thread.sleep(3000);
		
		//Get doctor name, page title and verify assertion
		log.info("Logged in Doctor is: " + login.physicianDetails().getText());
		Assert.assertEquals(login.getUsername().getText(), "KD");
		log.info("Logged in Doctor name is verified");
		String title = driver.getTitle();
		log.info("The Page Title is: " + title);
		
		TabsNavigationPage tabs=new TabsNavigationPage(driver);		
		TrackMyPatientsPage patient = new TrackMyPatientsPage(driver);
		
		//Click on Track My Patients tab
		tabs.getTrackMyPatientsTab().click();
		log.info("Clicked on Track My Patients tab");
		Thread.sleep(2000);
		
		//Click on MESSAGE button
		patient.getInstanceMessage().click();
		log.info("Clicked on Message button");		
		Thread.sleep(3000);
		
		//Enter instant message
		patient.getInstanceMessageBox().sendKeys("Stop current diabetic medicine and visit your doctor to assess your diabetic profile");
		log.info("Instant Message entered");
		
		//click SEND button
		patient.send_Button().click();
		Thread.sleep(3000);
		log.info("Instance message sent to Patient");	
		
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("========TRACK MY PATIENTS_INSTANCE MESSAGE TEST ENDS HERE======");
		System.out.println("##############################################################################################################################################");


	}

}


