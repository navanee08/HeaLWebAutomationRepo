package Admin_Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.LoginPage;
import com.heka.PageObjects.ViewChallengePointsPage;
import resources.base;

public class View_Challenge_Points_Test extends base {
	public static Logger log = LogManager.getLogger(View_Challenge_Points_Test.class.getName());

	@BeforeMethod
	public void setUp() throws IOException {
		log.info("=============== VIEW CHALLENGE POINTS TEST STARTS HERE =====================");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("qaUrl"));
		log.info("Launching Application URL");
	}

	@Test(timeOut=150000)
	public void view_Challenge_Points() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		LoginPage login = new LoginPage(driver);

		// Entered mobile number
		login.getMobile().sendKeys("9441053222");
		log.info("Entered valid mobile number");

		// Entered password
		login.getPassword().sendKeys("12341234");
		log.info("Entered valid password");

		// Click on SIGN IN button
		login.Signin().click();
		log.info("Logged in");
		Thread.sleep(3000);

		// Get doctor name, get page title, and verify assertion
		log.info("Logged in Doctor is: " + login.physicianDetails().getText());
		Assert.assertEquals(login.getUsername().getText(), "KD");
		log.info("Logged in Doctor name is successfully verified");
		String title = driver.getTitle();
		log.info("The Page Title is: " + title);

		ViewChallengePointsPage points = new ViewChallengePointsPage(driver);

		// Hovering on admin tab
		WebElement target1 = driver.findElement(By.cssSelector("#navbar3 > ul:nth-child(1) > li.dropdown"));
		Actions action = new Actions(driver);
		action.moveToElement(target1).build().perform();
		log.info("Hovering on admin");

		// Click on Challenges from admin tab
		points.getChallenges().click();
		Thread.sleep(5000);
		log.info("Clicked on Challenges from admin");
		
		// Click Points tab
		points.getPointsTab().click();
		Thread.sleep(5000);
		
		//Select active challenge
		String activeChallegesDropdown = "/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[3]/div/div/div[1]/div/div/select";
		Select activeChallenge = new Select(driver.findElement(By.xpath(activeChallegesDropdown)));
		activeChallenge.selectByValue("70: Object");
		Thread.sleep(10000);
		log.info("Active Challenge has been selected to view the points");
		
}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("===================VIEW CHALLENGE POINTS TEST ENDS HERE=====================");
		System.out.println("##############################################################################################################################################");

	}

}

