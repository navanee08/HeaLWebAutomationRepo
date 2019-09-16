package com.heka.TestCases;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.heka.PageObjects.LoginPage;

import resources.base;

public class Login_With_Data_Driven_Test extends base {
	public static Logger log = LogManager.getLogger(Login_With_Data_Driven_Test.class.getName());

	@BeforeTest
	public void setUp() throws IOException {
		log.info("==============LOGIN DATA DRIVEN TEST STARTS HERE==================");

		driver = initializeDriver();
		log.info("Browser Launched");
	}

	@Test(dataProvider = "getData")
	public void loginDataDriven(String mobile, String password) throws IOException, InterruptedException {

		driver.get(prop.getProperty("prodUrl"));
		log.info("Application URL Launched");

		LoginPage login = new LoginPage(driver);
		
		//Enter login details
		login.getMobile().sendKeys(mobile);
		login.getPassword().sendKeys(password);
		login.Signin().click();
		Thread.sleep(5000);
		log.info("Doctor has successfully logged in");
		
		//Get doctor name, get page title
		String userName = login.getUsername().getText();
		log.info("Logged in Doctor name is: " + userName);
		String title = driver.getTitle();
		log.info("The Page Title is: " + title);

	}

	@AfterTest
	public void teardown() {

		driver.close();
		driver = null;
		log.info("Browser is closed");
		log.info("==============LOGIN DATA DRIVEN TEST ENDS HERE===================");
		System.out.println("##############################################################################################################################################");

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "8247550247";
		data[0][1] = "12341234";

		data[1][0] = "9988776611";
		data[1][1] = "12341234";

		data[2][0] = "9441053222";
		data[2][1] = "12341234";

		return data;

	}

}
