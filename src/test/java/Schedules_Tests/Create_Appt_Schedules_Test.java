package Schedules_Tests;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.heka.PageObjects.LoginPage;

import resources.base;

import com.heka.PageObjects.CreateApptSchedulesPage;


public class Create_Appt_Schedules_Test extends base {
	public static Logger log = LogManager.getLogger(Create_Appt_Schedules_Test.class.getName());
			
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		log.info("=======CREATE APPOINTMENT SCHEDULE TEST STARTS HERE=========");
		driver = initializeDriver();
		log.info("Browser Started");

	}

	@Test
	public void createAppointmentSchedule() throws IOException, InterruptedException {

		driver.get(prop.getProperty("prodUrl"));
		log.info("Application URL opened");

		LoginPage login = new LoginPage(driver);
		login.getMobile().sendKeys("9441053222");
		log.info("Mobile number entered");
		login.getPassword().sendKeys("12341234");
		log.info("Password entered");
		login.Signin().click();
		log.info("Clicked on SIGN IN button");
		log.info("Doctor has successfully logged in");

		CreateApptSchedulesPage schedule = new CreateApptSchedulesPage(driver);
		schedule.myScheduleTab().click();
		Thread.sleep(2000);
		schedule.select_year();
		Thread.sleep(3000);
		schedule.select_month();		
		Thread.sleep(3000);
		schedule.select_day();
		Thread.sleep(5000);
		schedule.getDate().click();
		Thread.sleep(2000);
		schedule.select_from();
		Thread.sleep(2000);
		schedule.select_to();
		Thread.sleep(2000);
		log.info("Clicked on My Schedule tab, entered Year, Month, Day of appointment schedule");
		schedule.getSave().click();
		Thread.sleep(5000);
		log.info("Clicked on save button");		
		schedule.switchToWindow();
		Thread.sleep(2000);
		// To verify whether schedule appointment is displaying in Dash board
		schedule.getDashboard().click();
		Thread.sleep(5000);
		log.info("Doctor has successfully created appointment schedule");
		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Browser is closed");
		log.info("=======CREATE APPOINTMENT SCHEDULE TEST ENDS HERE=========");
		System.out.println("#####################################################################################################################################");
	}

}
