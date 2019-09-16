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

public class Login_With_Single_User_Test extends base {
	public static Logger log = LogManager.getLogger(Login_With_Single_User_Test.class.getName());

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		log.info("===================LOGIN TEST STARTS HERE===================");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");

	}

	@Test(timeOut=60000)
	public void login_With_Valid_Mobile_Number() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		LoginPage login = new LoginPage(driver);

		// Get credentials test data from excel sheet
		String projectpath = System.getProperty("user.dir");
		Xls_Reader reader = new Xls_Reader(projectpath + "\\src\\test\\java\\resources\\LoginTestData.xlsx");
		String mobile = reader.getCellData("LoginData", "mobile", 2);
		String password = reader.getCellData("LoginData", "password", 2);

		// Enter login details from above retrieved data
		Library.click(driver, login.getMobile(), 10);
		Library.sendKeys(driver, login.getMobile(), 10, mobile);
		Library.click(driver, login.getPassword(), 10);
		Library.sendKeys(driver, login.getPassword(), 10, password);
		Library.click(driver, login.Signin(), 10);
		Thread.sleep(5000);

		// Assertion
		Assert.assertEquals(login.getUsername().getText(), "KD");
		log.info("Assertion passed - Doctor name is verified");
		String text = login.getDashboard().getText();
		Assert.assertEquals("Dashboard", text, "Due to login fail, Dashboard is not displayed");
		System.out.println("After login, as expected, it has displayed" + " " + text);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("===============LOGIN TEST ENDS HERE==================");
		System.out.println("##############################################################################################################################################");

	}

}