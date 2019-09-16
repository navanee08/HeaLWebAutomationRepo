package TrackYourPatients_Tests;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.FoodLogPage;
import com.heka.PageObjects.LoginPage;
import com.heka.PageObjects.PatientsDetailsPage;
import com.heka.PageObjects.TabsNavigationPage;
import resources.base;

public class Food_Log_Test extends base {
	public static Logger log = LogManager.getLogger(Food_Log_Test.class.getName());
	base b = new base();

	@BeforeMethod
	public void setUp() throws IOException {
		log.info("======================Food Log Test Starts Here====================");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test
	public void food_Log() throws IOException, InterruptedException {

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

		FoodLogPage foodlog = new FoodLogPage(driver);

		// Clicking on Food Log button
		foodlog.food_Log_Button().click();
		log.info("Navigated to food log page");
		Thread.sleep(10000);

		//Select Week in Food Log window
		foodlog.selectPeriodMonth();
		Thread.sleep(5000);
		log.info("Selected Month from period dropdown");
		
		//Select Month in Food Log window
		foodlog.selectPeriodWeek();
		Thread.sleep(5000);
		log.info("Selected Week from period dropdown");
		
		//Click Detailed Food Log tab
		foodlog.detailed_Food_Log_Tab().click();
		Thread.sleep(5000);
		log.info("Navigated to detailed food log tab");
				
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("================FOOD LOG TEST ENDS HERE====================");
		System.out.println("********************************************************************************************************************");

	}

}
