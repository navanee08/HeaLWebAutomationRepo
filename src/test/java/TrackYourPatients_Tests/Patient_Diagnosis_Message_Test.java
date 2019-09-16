package TrackYourPatients_Tests;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.LoginPage;
import com.heka.PageObjects.PatientsDetailsPage;
import com.heka.PageObjects.TabsNavigationPage;
import com.heka.PageObjects.TrackMyPatientsPage;

import resources.base;

public class Patient_Diagnosis_Message_Test extends base {
	public static Logger log = LogManager.getLogger(Patient_Diagnosis_Message_Test.class.getName());
	base b = new base();

	@BeforeMethod
	public void setUp() throws IOException {
		log.info("==========PATIENT DIAGNOSIS MESSAGE TEST STARTS HERE=======");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test
	public void patient_Diagnosis_Message() throws IOException, InterruptedException {

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
		Thread.sleep(3000);
		
		//Get doctor name, get page title, and verify assertion
		log.info("Logged in Doctor is: " + login.physicianDetails().getText());
		Assert.assertEquals(login.getUsername().getText(), "KD");
		log.info("Logged in Doctor name is verified");
		String title = driver.getTitle();
		log.info("The Page Title is: " + title);

		TabsNavigationPage tabs = new TabsNavigationPage(driver);
		
		//Click on Track My Patients Tab
		tabs.getTrackMyPatientsTab().click();
		log.info("Clicked on Track My Patients tab");

		PatientsDetailsPage details = new PatientsDetailsPage(driver);
		
		//Click on DETAILS button
		details.patientDetailsButton().click();
		log.info("Clicked on Details button");
		Thread.sleep(2000);

		TrackMyPatientsPage patientDiagnosis = new TrackMyPatientsPage(driver);
		
		//Enter diagnosis message
		patientDiagnosis.diagnosis_Message().sendKeys("Congratulations!!!your HbA1c level is normal");
		Thread.sleep(2000);
		log.info("Entered diagnosis message");
		patientDiagnosis.saveButton().click();
		log.info("Saved diagnosis message");
		Thread.sleep(5000);

		// Switching to window pop up & clicking OK button
		TrackMyPatientsPage alert = new TrackMyPatientsPage(driver);
		alert.switchToWindow();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("==========PATIENT DIAGNOSIS MESSAGE TEST ENDS HERE========");
		System.out.println("********************************************************************************************************************");

	}

}
