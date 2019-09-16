//ALWAYS ENTER AN EXISTING MOBILE NUMBER FOR A NEGATIVE TEST
package com.heka.TestCases;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.SignupPage;

import resources.base;

public class Signup_Negative_Test extends base {
	public static Logger log = LogManager.getLogger(Signup_Negative_Test.class.getName());

	@BeforeMethod
	public void setUp() throws IOException {
		log.info("============ SIGNUP NEGATIVE TEST STARTS HERE==========");
		driver = initializeDriver();
		log.info("Browser is launched");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Application URL is launched");

	}

	@Test
	public void signUp_Negative() throws IOException, InterruptedException {

		SignupPage signup = new SignupPage(driver);

		// Click on Register Here link
		signup.getRegister().click();
		log.info("Clicked on Register Here link");

		// Enter Registration details
		signup.getFname().sendKeys("Arvind");
		signup.getLname().sendKeys("Reddy");
		signup.getDegree().sendKeys("MD");
		signup.getDesignation().sendKeys("General Medicine");

		// Enter existing mobile number
		signup.getMobile().sendKeys("8119687856");
		signup.getEmail().sendKeys("vn65@hotmail.com");
		signup.getPassword().sendKeys("12341234");
		log.info("Entered signup details");

		// Clicked on SIGN UP button
		signup.SignUpButton().click();
		log.info("Clicked on SIGN UP button");
		Thread.sleep(5000);

		// Switch to window
		signup.switchToWindow();
		Thread.sleep(2000);
		log.info("Signup test failed due to using existing mobile number");

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Browser is closed");
		log.info("============ SIGNUP NEGATIVE TEST ENDS HERE==========");
		System.out.println("###############################################################################################################################################");

	}
}


