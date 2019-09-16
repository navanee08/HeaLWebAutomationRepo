package TrackYourPatients_Tests;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.LoginPage;
import com.heka.PageObjects.MedicationLogPage;
import com.heka.PageObjects.PatientsDetailsPage;
import com.heka.PageObjects.TabsNavigationPage;
import resources.base;

public class Patient_Medication_Log_Test extends base {
	public static Logger log = LogManager.getLogger(Patient_Medication_Log_Test.class.getName());
	base b = new base();

	@BeforeMethod
	public void setUp() throws IOException {
		log.info("============= PATIENT MEDICATION LOG TEST STARTS HERE ===============");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test
	public void patient_Medication_Log() throws IOException, InterruptedException {

		LoginPage login = new LoginPage(driver);
		
		//Enter mobile number
		login.getMobile().sendKeys("9441053222");
		log.info("Entered valid mobile number");
		
		//Enter password
		login.getPassword().sendKeys("12341234");
		log.info("Entered valid password");
		
		//Clicked in SIGN IN button
		login.Signin().click();
		log.info("Logged in");
		Thread.sleep(3000);
		
		//Get Text, get title and verify assertion
		log.info("Logged in Doctor is: " + login.physicianDetails().getText());
		Assert.assertEquals(login.getUsername().getText(), "KD");
		log.info("Logged in Doctor name is verified");
		String title = driver.getTitle();
		log.info("The Page Title is: " + title);
		
		//Track My Patients tab
		TabsNavigationPage tabs = new TabsNavigationPage(driver);
		tabs.getTrackMyPatientsTab().click();
		Thread.sleep(3000);
		log.info("Clicked on Track My Patients tab");

		//Details button
		PatientsDetailsPage details = new PatientsDetailsPage(driver);
		details.patientDetailsButton().click();
		Thread.sleep(2000);
		log.info("Clicked on Details button");
		
		
		//Patient's Mediation Log
		MedicationLogPage medicationlog = new MedicationLogPage(driver);
		medicationlog.medication_log_Button().click();
		Thread.sleep(5000);
		log.info("Navigated to Medication Log to view patient's medicines");		
			
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
