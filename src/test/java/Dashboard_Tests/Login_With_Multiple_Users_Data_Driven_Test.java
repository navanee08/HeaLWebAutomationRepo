package Dashboard_Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.LoginPage;

import resources.Library;
import resources.Xls_Reader;
import resources.base;

public class Login_With_Multiple_Users_Data_Driven_Test extends base {
	public static Logger log = LogManager.getLogger(Login_With_Multiple_Users_Data_Driven_Test.class.getName());
	LoginPage login = new LoginPage(driver);

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		log.info("===================LOGIN TEST STARTS HERE===================");
		driver = initializeDriver();
		Thread.sleep(10000);
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");

	}

	@Test(timeOut=60000)
	public void login_With_Valid_Mobile_Number() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		LoginPage login = new LoginPage(driver);

		// Get test data from excel sheet
		String projectpath = System.getProperty("user.dir");
		Xls_Reader reader = new Xls_Reader(projectpath + "\\src\\test\\java\\resources\\Login_Multiple_Data.xlsx");
		int rowCount = reader.getRowCount("LoginMultipleData");
		System.out.println("Number of rows in my excel sheet: " + rowCount);

		// Parameterization
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
			System.out.println("++++++++++++++++++");

			driver.get(prop.getProperty("qaUrl"));
			log.info("Launching Application URL");

			String mobile = reader.getCellData("LoginMultipleData", "mobile", rowNum);
			System.out.println("Username: " + mobile);
			String password = reader.getCellData("LoginMultipleData", "password", rowNum);
			System.out.println("Password: " + password);

			// Enter login details from above retrieved data
			Library.click(driver, login.getMobile(), 10);
			Library.sendKeys(driver, login.getMobile(), 10, mobile);
			Library.click(driver, login.getPassword(), 10);
			Library.sendKeys(driver, login.getPassword(), 10, password);
			Library.click(driver, login.Signin(), 10);
			Thread.sleep(5000);
			
			String doctorName = login.getUsername().getText();
			System.out.println("Logged in doctor name: " + doctorName);
			String text = login.getDashboard().getText();
			System.out.println("After login, as expected, it has displayed" + " " + text);
			Assert.assertEquals("Dashboard", text, "Due to login fail, Dashboard is not displayed");
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		driver = null;
		log.info("Driver is closed");
		log.info("===============LOGIN TEST ENDS HERE==================");
		System.out.println("##############################################################################################################################################");

	}
}
