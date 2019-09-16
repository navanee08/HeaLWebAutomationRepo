package Schedules_Tests;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.heka.PageObjects.EditApptSchedulePage;
import com.heka.PageObjects.LoginPage;
import resources.base;


public class Edit_Appt_Schedule_Test extends base{
	public static Logger log = LogManager.getLogger(Edit_Appt_Schedule_Test.class.getName());
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		log.info("============= EDIT APPOINTMENT SCHEDULE TEST STARTS HERE ==============");
		driver = initializeDriver();
		log.info("Browser Started");

	}

	@Test
	public void edit_Appt_Schedule() throws IOException, InterruptedException {
		driver.get(prop.getProperty("prodUrl"));
		log.info("Application URL opened");

		LoginPage login = new LoginPage(driver);
		
		//Entering login details
		login.getMobile().sendKeys("9441053222");
		log.info("Mobile number entered");
		login.getPassword().sendKeys("12341234");
		log.info("Password entered");
		login.Signin().click();
		Thread.sleep(5000);
		log.info("Clicked on SIGN IN button, Doctor has successfully logged in");		
			
		EditApptSchedulePage edit = new EditApptSchedulePage(driver);
		
		//Clicking on dash board
		edit.mydashboard().click();
		Thread.sleep(5000);
		log.info("Clicked on Dash board");		
		
		//Clicking Edit button
		edit.editSchedule().click();
		Thread.sleep(5000);
		log.info("Clicked on Appointment Edit button");
		
		//Selecting new From and To timings
		edit.select_from();
		edit.select_to();
		log.info("Selected new appointment timings");
		edit.save_Button().click();
		Thread.sleep(5000);
		log.info("Clicked on save button");
				
		//Switch to alert window
		edit.switchToWindow();
		log.info("Switched on pop up");
		Thread.sleep(2000);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Browser is closed");
		log.info("============= EDIT APPOINTMENT SCHEDULE TEST ENDS HERE ==============");
		System.out.println("#################################################################################################################################################");

	}

}
