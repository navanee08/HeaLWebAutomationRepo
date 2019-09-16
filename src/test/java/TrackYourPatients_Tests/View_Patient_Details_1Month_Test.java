package TrackYourPatients_Tests;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.LoginPage;
import com.heka.PageObjects.PatientsDetailsPage;
import com.heka.PageObjects.TabsNavigationPage;
import resources.base;

public class View_Patient_Details_1Month_Test extends base {
	public static Logger log = LogManager.getLogger(View_Patient_Details_1Month_Test.class.getName());
	base b = new base();

	@BeforeMethod
	public void setUp() throws IOException {
		log.info("========== VIEW PATIENT'S ONE MONTH DATA TEST START HERE =========");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test
	public void viewPatientOneMonthData() throws IOException, InterruptedException {

		LoginPage login = new LoginPage(driver);

		// Enter login details
		login.getMobile().sendKeys("9441053222");
		log.info("Entered valid mobile number");
		login.getPassword().sendKeys("12341234");
		log.info("Entered valid password");

		// Clicked on SIGN IN button
		login.Signin().click();
		log.info("Logged in");
		Thread.sleep(3000);

		// Get doctor name, get page title, and verify assertion
		log.info("Logged in Doctor is: " + login.physicianDetails().getText());
		Assert.assertEquals(login.getUsername().getText(), "KD");
		log.info("Logged in Doctor name is verified");
		String title = driver.getTitle();
		log.info("The Page Title is: " + title);

		TabsNavigationPage tabs = new TabsNavigationPage(driver);

		// Click on Track My Patients tab
		tabs.getTrackMyPatientsTab().click();
		log.info("Clicked on Track My Patients tab");

		PatientsDetailsPage details = new PatientsDetailsPage(driver);

		//// Click on DETAILS button
		details.patientDetailsButton().click();
		log.info("Clicked on Details button");
		Thread.sleep(2000);

		// Selecting 1 Month data
		WebElement dropdown = details.selectPeriodDropdownField();
		Select sel = new Select(dropdown);
		sel.selectByVisibleText("1 Month");
		log.info("1 Month Selected to view patient's one month data");
		Thread.sleep(5000);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("========== VIEW PATIENT'S ONE MONTH DATA TEST ENDS HERE ==========");
		System.out.println("##############################################################################################################################################");

	}

}
