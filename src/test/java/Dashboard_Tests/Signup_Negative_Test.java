//ALWAYS ENTER AN EXISTING MOBILE NUMBER FOR A NEGATIVE TEST
package Dashboard_Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.SignupPage;
import resources.Library;
import resources.Xls_Reader;
import resources.base;

public class Signup_Negative_Test extends base {
	public static Logger log = LogManager.getLogger(Signup_Negative_Test.class.getName());

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		log.info("============ SIGNUP NEGATIVE TEST STARTS HERE==========");
		driver = initializeDriver();
		log.info("Browser is launched");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Application URL is launched");

	}

	@Test(timeOut=60000)
	public void signUp_Negative() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		SignupPage signup = new SignupPage(driver);

		// Click on Register Here link
		Library.click(driver, signup.getRegister(), 10);
		Thread.sleep(2000);
		log.info("Clicked on Register Here link");
		
		// Get Sign Up test data from excel sheet
		String projectpath = System.getProperty("user.dir");
		Xls_Reader reader = new Xls_Reader(projectpath + "\\src\\test\\java\\resources\\SignupData.xlsx");
		String fname = reader.getCellData("SignupData", "fname", 2);
		String lname = reader.getCellData("SignupData", "lname", 2);
		String degree = reader.getCellData("SignupData", "degree", 2);
		String title = reader.getCellData("SignupData", "title", 2);
		String mobile = reader.getCellData("SignupData", "mobile", 2);
		String email = reader.getCellData("SignupData", "email", 2);
		String password = reader.getCellData("SignupData", "password", 2);
		
		System.out.println(fname);

		// Enter Sign Up details
		Library.sendKeys(driver, signup.getFname(), 10, fname);
		Library.sendKeys(driver, signup.getLname(), 10, lname);
		Library.sendKeys(driver, signup.getDegree(), 10, degree);
		Library.sendKeys(driver, signup.getDesignation(), 10, title);
		Library.sendKeys(driver, signup.getMobile(), 10, mobile);
		Library.sendKeys(driver, signup.getEmail(), 10, email);
		Library.sendKeys(driver, signup.getPassword(), 10, password);
		
		log.info("Entered signup details");

		// Clicked on SIGN UP button
		Library.click(driver, signup.SignUpButton(), 10);
		Thread.sleep(5000);
		log.info("Clicked on SIGN UP button");

		// Switch to window
		signup.switchToWindow();
		Thread.sleep(5000);
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
