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
import com.heka.PageObjects.TabsNavigationPage;

import resources.Library;
import resources.Xls_Reader;
import resources.base;

public class Tabs_Navigation_Test extends base {
	public static Logger log = LogManager.getLogger(Tabs_Navigation_Test.class.getName());

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		log.info("=============== TABS NAVIGATION TEST STARTS HERE ===============");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test(timeOut=60000)
	public void tabsNavigation() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		LoginPage login = new LoginPage(driver);
		
		// Get test data from excel sheet
		String projectpath = System.getProperty("user.dir");
		Xls_Reader reader = new Xls_Reader(projectpath + "\\src\\test\\java\\resources\\LoginTestData.xlsx");
		String mobile = reader.getCellData("LoginData", "mobile", 2);
		String password = reader.getCellData("LoginData", "password", 2);
		
		// Enter login details
		Library.sendKeys(driver, login.getMobile(), 10, mobile);
		Library.sendKeys(driver, login.getPassword(), 10, password);
		Library.click(driver, login.Signin(), 10);
		Thread.sleep(5000);
		
		// Get doctor name and get page title and then verify assertion
		log.info("Logged in Doctor is: " + login.physicianDetails().getText());
		Assert.assertEquals(login.getUsername().getText(), "KD");
		log.info("Logged in Doctor name is verified - Assertion passed");		

		TabsNavigationPage tabs = new TabsNavigationPage(driver);
		
		// Click on dash board tab		
		Library.click(driver, tabs.getdashboard(), 10);
		Thread.sleep(2000);
		log.info("Clicked on Dashboard tab");

		// Click on My Schedule tab
		Library.click(driver, tabs.getMySchedule(), 10);
		Thread.sleep(2000);
		log.info("Clicked on My Schedule tab");

		// Click on Track My Patients Tab
		Library.click(driver, tabs.getTrackMyPatientsTab(), 10);
		Thread.sleep(2000);
		log.info("Clicked on Track My Patients tab");

		// Click on Admin Tab
		Library.click(driver, tabs.getAdmin(), 10);
		Thread.sleep(2000);
		log.info("Clicked on Admin tab");
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("=============== TABS NAVIGATION TEST ENDS HERE =================");
		System.out.println("##############################################################################################################################################");


	}

}


