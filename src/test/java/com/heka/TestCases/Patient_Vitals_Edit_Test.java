package com.heka.TestCases;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.base;

public class Patient_Vitals_Edit_Test extends base {
	public static Logger log = LogManager.getLogger(Patient_Vitals_Edit_Test.class.getName());
	base b = new base();

	@BeforeMethod
	public void setUp() throws IOException {
		log.info("=============PATIENT VITALS EDIT TEST STARTS HERE===============");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test
	public void patient_Vitals_Edit() {
		throw new SkipException("Skipping Vitals Edit Test as script development has not completed");

		/*
		 * LoginPage login = new LoginPage(driver);
		 * 
		 * //Enter mobile number login.getMobile().sendKeys("9441053222");
		 * log.info("Entered valid mobile number");
		 * 
		 * //Enter password login.getPassword().sendKeys("12341234");
		 * log.info("Entered valid password");
		 * 
		 * //Click on SIGN IN button login.Signin().click(); Thread.sleep(3000);
		 * log.info("Logged in");
		 * 
		 * //Get doctor name log.info("Logged in Doctor is: " +
		 * login.physicianDetails().getText());
		 * 
		 * //Verify assertion Assert.assertEquals(login.getUsername().getText(), "KD");
		 * log.info("Logged in Doctor name is verified");
		 * 
		 * //Get Page title String title = driver.getTitle();
		 * log.info("The Page Title is: " + title);
		 * 
		 * TabsNavigationPage tabs = new TabsNavigationPage(driver);
		 * 
		 * //Click on Track My Patients tabs.getTrackMyPatientsTab().click();
		 * log.info("Clicked on Track My Patients tab");
		 * 
		 * PatientsDetailsPage details = new PatientsDetailsPage(driver);
		 * 
		 * //Click on Details button details.patientDetailsButton().click();
		 * log.info("Clicked on Details button"); Thread.sleep(2000);
		 * 
		 * VitalsRangeAndFrequencyEditPage vitals = new
		 * VitalsRangeAndFrequencyEditPage(driver);
		 * 
		 * //Click on Vitals edit button vitals.vitals_Edit_Button().click();
		 * log.info("Clicked on Vitals edit button");
		 * 
		 * //Edit Diastolic value vitals.bp_Diastolic_Edit().sendKeys("81");
		 * 
		 * //Edit Systolic value vitals.bp_Systolic_Edit().sendKeys("121");
		 * 
		 * //Edit HBA1c value vitals.hba1ac_Lower_Range_Edit().sendKeys("4.1");
		 * vitals.hba1ac_Higher_Range_Edit().sendKeys("5.0");
		 * 
		 * //Edit Total Cholesterol value
		 * vitals.totalCholesterol_Lower_Range_Edit().sendKeys("0.1");
		 * vitals.totalCholesterol_Higher_Range_Edit().sendKeys("220");
		 * 
		 * //Edit Triglycerides value
		 * vitals.triglycerides_Lower_Range_Edit().sendKeys("0.2");
		 * vitals.triglycerides_Higher_Range_Edit().sendKeys("150.1");
		 * 
		 * //Click Save button vitals.save_Button().click(); Thread.sleep(5000);
		 * 
		 * //Switch to pop up vitals.switchToWindow(); Thread.sleep(3000); }
		 * 
		 * @AfterMethod public void tearDown() { driver.close(); driver = null;
		 * log.info("Driver is closed");
		 * log.info("=============PATIENT VITALS EDIT TEST ENDS HERE================");
		 * System.out.println(
		 * "********************************************************************************************************************"
		 * );
		 * 
		 * }
		 */
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("============= PATIENT MEDICATION LOG TEST ENDS HERE ================");
		System.out.println("********************************************************************************************************************");

	}
}