package com.heka.TestCases;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.AddPrescriptionPage;
import com.heka.PageObjects.LoginPage;
import com.heka.PageObjects.PatientsDetailsPage;
import com.heka.PageObjects.TabsNavigationPage;
import resources.base;

public class Delete_Prescription_Test extends base {
	public static Logger log = LogManager.getLogger(Delete_Prescription_Test.class.getName());
	base b = new base();

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		log.info("====== DELETE PRESCRIPTOPN TEST STARTS HERE =========");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test
	public void delete_prescription() throws IOException, InterruptedException {

		LoginPage login = new LoginPage(driver);
		
		//Enter mobile number
		login.getMobile().sendKeys("9441053222");
		log.info("Entered valid mobile number");
		
		//Enter password
		login.getPassword().sendKeys("12341234");
		log.info("Entered valid password");
		
		//Click on SIGN IN button
		login.Signin().click();
		log.info("Logged in");
				
		//Get doctor name, get page title, and verify assertion
		log.info("Logged in Doctor is: " + login.physicianDetails().getText());
		Assert.assertEquals(login.getUsername().getText(), "KD");
		log.info("Logged in Doctor name is verified");
		String title = driver.getTitle();
		log.info("The Page Title is: " + title);
		
		//Click on Track My Patients tab
		TabsNavigationPage tabs = new TabsNavigationPage(driver);
		tabs.getTrackMyPatientsTab().click();
		log.info("Clicked on Track My Patients tab");

		//Click on Patient "Details" button
		PatientsDetailsPage details = new PatientsDetailsPage(driver);
		details.patientDetailsButton().click();
		log.info("Clicked on Details button");
		Thread.sleep(2000);

		AddPrescriptionPage add = new AddPrescriptionPage(driver);
		
		//Click on Add button
		add.add_Button().click(); 
		log.info("Clicked on Add button");
		Thread.sleep(5000);
		
		//Delete medicine
		String path = "#cdk-overlay-0 > mat-dialog-container > app-prescription-details > div:nth-child(2) > div.col-md-12 > div > app-prescription > div > a.list-group-item.clearfix > div > div.col-xs-12.col-md-1 > div.col-md-6 > button";
		driver.findElement(By.cssSelector(path)).click();
		Thread.sleep(5000);
		log.info("Medicine deleted");
		Thread.sleep(10000);
				
		// Switching to alert and clicking ok button
		add.switchToWindow();
		Thread.sleep(5000);
		
		// Save after prescription delete
		add.save_After_Delete().click();
		Thread.sleep(5000);
		
		// Switching to alert and clicking ok button
		add.switchToWindow();
		Thread.sleep(5000);	
		 		
}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("========== DELETE PRESCRIPTOPN TEST ENDS HERE ===========");
		System.out.println("********************************************************************************************************************");

	}

}
