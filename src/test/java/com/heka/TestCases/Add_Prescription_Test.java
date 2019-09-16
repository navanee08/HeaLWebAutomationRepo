package com.heka.TestCases;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.AddPrescriptionPage;
import com.heka.PageObjects.LoginPage;
import com.heka.PageObjects.PatientsDetailsPage;
import com.heka.PageObjects.TabsNavigationPage;
import resources.base;

public class Add_Prescription_Test extends base {
	public static Logger log = LogManager.getLogger(Add_Prescription_Test.class.getName());
	base b = new base();

	@BeforeMethod
	public void setUp() throws IOException {
		log.info("====== ADD PRESCRIPTION TEST STARTS HERE =========");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test
	public void add_Prescription() throws IOException, InterruptedException {

		LoginPage login = new LoginPage(driver);
		login.getMobile().sendKeys("9441053222");
		log.info("Entered valid mobile number");
		login.getPassword().sendKeys("12341234");
		log.info("Entered valid password");
		login.Signin().click();
		log.info("Logged in");
		log.info("Logged in Doctor is: " + login.physicianDetails().getText());
		Assert.assertEquals(login.getUsername().getText(), "KD");
		log.info("Logged in Doctor name is verified");
		String title = driver.getTitle();
		log.info("The Page Title is: " + title);
		
		//Clicking on Track My Patients tab
		TabsNavigationPage tabs = new TabsNavigationPage(driver);
		tabs.getTrackMyPatientsTab().click();
		log.info("Clicked on Track My Patients tab");

		//Clicking on Patient's "Details" button
		PatientsDetailsPage details = new PatientsDetailsPage(driver);
		details.patientDetailsButton().click();
		log.info("Clicked on Details button");
		
		AddPrescriptionPage add = new AddPrescriptionPage(driver);
		
		//Clicking on Add button
		add.add_Button().click();
		log.info("Clicked on Add button");
			
		//Clicking on New Medicine button
		add.new_Medicine_Button().click();		
		log.info("Clicked on New Medicine button");
				
		//Entering medicine name	
		add.enter_Medicine_Name().clear();	
		add.enter_Medicine_Name().sendKeys("DOLO 650 MG TABLET");		
		log.info("Enterd Medicine Name");
				
		//Entering dose	
		String path="//*[@id=\"cdk-overlay-0\"]/mat-dialog-container/app-prescription-details/div[2]/div[3]/div[1]/app-prescription/div[1]/a[2]/div/div[2]/input";
		Thread.sleep(5000);
		driver.findElement(By.xpath(path)).clear();	
		driver.findElement(By.xpath(path)).sendKeys("650 MG");		
		log.info("Dose enterd");
				
		// Selecting frequency from drop down
		String path1="//*[@id=\"cdk-overlay-0\"]/mat-dialog-container/app-prescription-details/div[2]/div[3]/div[1]/app-prescription/div/a[2]/div/div[3]/select";
		Select sel = new Select(driver.findElement(By.xpath(path1)));
		sel.selectByVisibleText("Daily");
		log.info("Frequency selected");
				
		// Entering duration
		add.duration().clear();
		add.duration().sendKeys("365");
		log.info("Entered duration");
		
		// Entering notes
		add.notes().sendKeys("Don't skip BP tablet");
		log.info("Entered notes");
		
		// Selecting after breakfast radio button
		add.after_Breakfast_Radio_Button().click();
				
		// Clicking save button
		add.save().click();
		
		// Switching to alert and clicking ok button
		add.switchToWindow();
				 		
}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("====== ADD PRESCRIPTION TEST ENDS HERE =========");
		System.out.println("********************************************************************************************************************");

	}

}
