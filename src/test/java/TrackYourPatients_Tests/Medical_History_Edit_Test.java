package TrackYourPatients_Tests;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.LoginPage;
import com.heka.PageObjects.MedicalHistoryEditPage;
import com.heka.PageObjects.PatientsDetailsPage;
import com.heka.PageObjects.TabsNavigationPage;
import resources.base;

public class Medical_History_Edit_Test extends base {
	public static Logger log = LogManager.getLogger(Medical_History_Edit_Test.class.getName());
	base b = new base();

	@BeforeMethod
	public void setUp() throws IOException {
		log.info("=======MEDICAL HISTORY EDIT TEST STARTS HERE=======");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test
	public void patient_Medical_History_Edit() throws IOException, InterruptedException {
		LoginPage login = new LoginPage(driver);
		
		//Enter mobile number
		login.getMobile().sendKeys("9441053222");
		log.info("Entered valid mobile number");
		
		//Enter password		
		login.getPassword().sendKeys("12341234");
		log.info("Entered valid password");
		
		//Click SIGN IN button
		login.Signin().click();		
		Thread.sleep(3000);
		log.info("Logged in");
		
		//Get doctor name and verify assertion
		log.info("Logged in Doctor is: " + login.physicianDetails().getText());
		Assert.assertEquals(login.getUsername().getText(), "KD");
		log.info("Logged in Doctor name is verified");
		
		//Get page title
		String title = driver.getTitle();
		log.info("The Page Title is: " + title);

		TabsNavigationPage tabs = new TabsNavigationPage(driver);
		
		//Click on Track My Patients tab
		tabs.getTrackMyPatientsTab().click();
		log.info("Clicked on Track My Patients tab");

		PatientsDetailsPage details = new PatientsDetailsPage(driver);
		
		//Click on DETAILS button
		details.patientDetailsButton().click();
		Thread.sleep(2000);
		log.info("Clicked on Details button");
		

		MedicalHistoryEditPage medicalhistory = new MedicalHistoryEditPage(driver);
		
		//Enter Medical History
		medicalhistory.thyroid_By_Self().click();
		medicalhistory.thyroid_By_Family().click();		
		medicalhistory.dentalProblems_By_Self().click();		
		medicalhistory.dentalProblems_By_Family().click();		
		medicalhistory.diabetes_By_Self().click();		
		medicalhistory.diabetes_By_Family().click();		
		medicalhistory.footProblems_By_Self().click();		
		medicalhistory.footProblems_By_Family().click();		
		medicalhistory.heartDiseases_By_Family().click();		
		medicalhistory.highCholesterol_By_Self().click();		
		medicalhistory.highCholesterol_By_Family().click();		
		medicalhistory.hypertension_By_Family().click();		
		medicalhistory.hypertension_By_Self().click();		
		medicalhistory.kidneyDiseases_By_Family().click();		
		medicalhistory.kidneyDiseases_By_Self().click();
		log.info("Medical History entered");
		
		//Click Save button
		medicalhistory.save_Button().click();
		Thread.sleep(5000);	
		log.info("Medical History saved");
		
		//Switch to alert
		medicalhistory.switchToWindow();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("=====MEDICAL HISTORY EDIT TEST ENDS HERE==========");
		System.out.println("********************************************************************************************************************");

	}

}
