package Schedules_Tests;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.DeleteSchedulePage;
import com.heka.PageObjects.LoginPage;

import resources.base;


public class Delete_Appt_Schedule_Test extends base {
	public static Logger log = LogManager.getLogger(Delete_Appt_Schedule_Test.class.getName());
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		log.info("============DELETE APPOINTMENT SCHEDULE TEST ENDS HERE===============");
		driver = initializeDriver();
		log.info("Browser Started");
	}

	@Test
	public void deleteApptSchedule() throws IOException, InterruptedException {
		driver.get(prop.getProperty("prodUrl"));
		log.info("Application URL opened");

		LoginPage login = new LoginPage(driver);
		login.getMobile().sendKeys("9441053222");
		log.info("Mobile number entered");
		Thread.sleep(2000);
		login.getPassword().sendKeys("12341234");
		log.info("Password entered");
		Thread.sleep(2000);
		login.Signin().click();
		log.info("Clicked on SIGN IN button");
		Thread.sleep(3000);
		log.info("Doctor has successfully logged in");

		DeleteSchedulePage schedule = new DeleteSchedulePage(driver);
		schedule.myScheduleTab().click();
		log.info("Clicked on My Schedule tab");
		Thread.sleep(2000);
		schedule.select_year();
		Thread.sleep(2000);
		schedule.select_month();
		Thread.sleep(2000);
		schedule.select_day();
		Thread.sleep(2000);
		schedule.getDate().click();
		Thread.sleep(2000);
		log.info("Selected Year, Month, Day and specific date to delete schedule");
		schedule.deleteAppointment().click();
		Thread.sleep(15000);
		log.info("Clicked on Delete button");		
		schedule.save_Button().click();
		Thread.sleep(5000);
		log.info("Clicked on save button to confirm delete");
		Thread.sleep(2000);
		schedule.switchToWindow();
		log.info("Switched on pop up and clicked on ok button");

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Browser is closed");
		log.info("============ DELETE APPOINTMENT SCHEDULE TEST ENDS HERE ===============");
		System.out.println("##############################################################################################################################################");

	}

}
