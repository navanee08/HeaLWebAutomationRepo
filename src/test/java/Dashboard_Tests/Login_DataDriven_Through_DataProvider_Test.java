package Dashboard_Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.heka.PageObjects.LoginPage;
import resources.Library;
import resources.base;

public class Login_DataDriven_Through_DataProvider_Test extends base {
	public static Logger log = LogManager.getLogger(Login_DataDriven_Through_DataProvider_Test.class.getName());

	@BeforeTest
	public void setUp() throws IOException, InterruptedException {
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
		Library.sendKeys(driver, login.getMobile(), 10, mobile);
		Library.sendKeys(driver, login.getPassword(), 10, password);
		Library.click(driver, login.Signin(), 10);
		Thread.sleep(3000);
		String userName = login.getUsername().getText();
		System.out.println("Doctor name: " + userName + " " +"has successfully logged in");		
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
		data[0][0] = "9999999999";
		data[0][1] = "12341234";

		data[1][0] = "9985199100";
		data[1][1] = "paulomikurup";

		data[2][0] = "9441053222";
		data[2][1] = "12341234";

		return data;

	}

}
