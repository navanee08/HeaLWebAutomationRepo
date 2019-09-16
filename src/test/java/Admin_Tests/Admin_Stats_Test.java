package Admin_Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.heka.PageObjects.AdminStatsPage;
import com.heka.PageObjects.LoginPage;
import com.heka.PageObjects.TabsNavigationPage;

import resources.Library;
import resources.Xls_Reader;
import resources.base;

public class Admin_Stats_Test extends base {
	public static Logger log = LogManager.getLogger(Admin_Stats_Test.class.getName());

	String projectpath = System.getProperty("user.dir");

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		log.info("===============ADMIN STATS TEST STARTS HERE=====================");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test
	public void run_Stats() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoginPage login = new LoginPage(driver);

		// Get user's credentials test data from excel sheet
		String projectpath = System.getProperty("user.dir");
		Xls_Reader reader = new Xls_Reader(projectpath + "\\src\\test\\java\\resources\\LoginTestData.xlsx");
		String mobile = reader.getCellData("LoginData", "mobile", 2);
		String password = reader.getCellData("LoginData", "password", 2);

		// Enter users's credentials data
		Library.sendKeys(driver, login.getMobile(), 10, mobile);
		login.getPassword().click();
		Library.sendKeys(driver, login.getPassword(), 10, password);
		Library.click(driver, login.Signin(), 10);
		Thread.sleep(5000);
		Assert.assertEquals(login.getUsername().getText(), "KD");
		log.info("Assertion passed - Doctor name is verified");
		String text = login.getDashboard().getText();
		Assert.assertEquals("Dashboard", text, "Due to login fail, Dashboard is not displayed");
		System.out.println("After login, as expected, it has displayed" + " " + text);

		TabsNavigationPage tabs = new TabsNavigationPage(driver);
		AdminStatsPage stats = new AdminStatsPage(driver);

		// Click on Admin tab
		Library.click(driver, tabs.getAdmin(), 10);
		Thread.sleep(2000);

		// Click on Stats
		Library.click(driver, stats.stats_Dropdown_Value(), 10);
		Thread.sleep(2000);

		// Enter number of weeks of data required
		Library.click(driver, stats.StatsDuration(), 10);
		stats.StatsDuration().clear();
		Thread.sleep(2000);
		Library.sendKeys(driver, stats.StatsDuration(), 10, "3");
		Thread.sleep(3000);

		// Run Statistics
		Library.click(driver, stats.runStats(), 15);
		Thread.sleep(30000);

		// Switch to confirmation pop up
		stats.switchToWindow();
		Thread.sleep(5000);

		// Click Quadrants
		Library.click(driver, stats.runQuadrants(), 10);
		Thread.sleep(5000);

		Library.click(driver, stats.browse_Button(), 10);
		Thread.sleep(5000);

		// Run Auto it script to upload a file
		Runtime.getRuntime().exec(projectpath + "\\src\\test\\java\\resources\\FileUpload.exe");
		Thread.sleep(10000);
		log.info("Excel file uploaded using Autoit");
		stats.switchToWindow();
		Thread.sleep(10000);

		// Select from which week need to run statistics
		String fromWeek = "#mat-tab-content-1-1 > div > div:nth-child(1) > tbody > tr > td:nth-child(3) > select";
		String toWeek = "/html/body/app-root/app-avg-stats/mat-tab-group/div/mat-tab-body[2]/div/div[1]/tbody/tr/td[4]/select";
		Select select1 = new Select(driver.findElement(By.cssSelector(fromWeek)));
		select1.selectByIndex(2);
		Thread.sleep(2000);
		select1.selectByIndex(1);

		// Select to which week need to run statistics
		Select select2 = new Select(driver.findElement(By.xpath(toWeek)));
		select2.selectByIndex(1);
		Thread.sleep(5000);
		select2.selectByIndex(3);
		Thread.sleep(5000);

		// Run stats
		Library.click(driver, stats.run(), 15);
		Thread.sleep(15000);
		log.info("Run Stats successful");

		// Switch to confirmation pop up window
		stats.switchToWindow();
		Thread.sleep(5000);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("=================== ADMIN STATS TEST ENDS HERE *************************");
		System.out.println("##############################################################################################################################################");

	}

}
