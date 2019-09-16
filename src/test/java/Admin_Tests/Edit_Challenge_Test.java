package Admin_Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.EditChallengePage;
import com.heka.PageObjects.LoginPage;
import resources.base;

public class Edit_Challenge_Test extends base {
	public static Logger log = LogManager.getLogger(Edit_Challenge_Test.class.getName());
	

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		log.info("=============== EDIT CHALLENGE TEST STARTS HERE =====================");
		driver = initializeDriver();
		log.info("Launching browser");
		Thread.sleep(10000);
		driver.get(prop.getProperty("qaUrl"));
		log.info("Launching Application URL");
	}

	@Test(timeOut=150000)
	public void edit_Challenge() throws IOException, InterruptedException {
		throw new SkipException("Skipping the test, will be executed as individual test");

		/*
		 * driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		 * 
		 * LoginPage login = new LoginPage(driver);
		 * 
		 * // Entered mobile number login.getMobile().sendKeys("9441053222");
		 * log.info("Entered valid mobile number");
		 * 
		 * // Entered password login.getPassword().sendKeys("12341234");
		 * log.info("Entered valid password");
		 * 
		 * // Click on SIGN IN button login.Signin().click(); log.info("Logged in");
		 * Thread.sleep(3000);
		 * 
		 * // Get doctor name, get page title, and verify assertion
		 * log.info("Logged in Doctor is: " + login.physicianDetails().getText());
		 * Assert.assertEquals(login.getUsername().getText(), "KD");
		 * log.info("Logged in Doctor name is successfully verified"); String title =
		 * driver.getTitle(); log.info("The Page Title is: " + title);
		 * 
		 * EditChallengePage challenge = new EditChallengePage(driver);
		 * 
		 * // Hovering on admin tab WebElement target1 =
		 * driver.findElement(By.cssSelector("#navbar3 > ul:nth-child(1) > li.dropdown")
		 * ); Actions action = new Actions(driver);
		 * action.moveToElement(target1).build().perform();
		 * log.info("Hovering on admin");
		 * 
		 * // Click on Challenges from admin tab challenge.getChallenges().click();
		 * log.info("Clicked on Challenges from admin");
		 * 
		 * // Click on Edit button to edit the challenge
		 * challenge.edit_Challenge().click();
		 * log.info("Edit button clicked to edit the Challenge"); Thread.sleep(15000);
		 * // Enter challenge description challenge.description().clear();
		 * challenge.description().sendKeys("5000_Steps_For_10_Points");
		 * Thread.sleep(10000);
		 * 
		 * log.info("Edited Challenge description");
		 * 
		 * // Run Autoit script to upload 5000 steps challenge image
		 * challenge.choose_File().click();// Click on "Choose file" button
		 * Thread.sleep(10000); String projectpath = System.getProperty("user.dir");
		 * Runtime.getRuntime().exec(projectpath +
		 * "\\src\\test\\java\\resources\\ChallengeImage.exe");
		 * challenge.upload_Image_Button().click(); challenge.switchToWindow();// Switch
		 * to confirmation pop up
		 * log.info("Steps challenge image uploaded successfully using Autoit");
		 * 
		 * // Challenge points challenge.challengePoints().clear();
		 * challenge.challengePoints().sendKeys("29"); Thread.sleep(3000);
		 * log.info("Points edited from 10 to 29");
		 * 
		 * // Challenge goal challenge.challengeStepsGoal().clear(); Thread.sleep(3000);
		 * challenge.challengeStepsGoal().sendKeys("6000"); Thread.sleep(3000);
		 * log.info("Steps goal edited from 5000 to 6000");
		 * 
		 * // Enter max challenge points challenge.maxChallengePoints().clear();
		 * Thread.sleep(3000); challenge.maxChallengePoints().sendKeys("999");
		 * Thread.sleep(3000);
		 * log.info("Maximum challenge points edited from 1000 to 999");
		 * 
		 * // Save the challenge challenge.save_Button().click(); Thread.sleep(10000);
		 * log.info("Challenge end date selected");
		 * 
		 * //Switch to pop up window challenge.switchToWindow(); Thread.sleep(3000);
		 */
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("=============== EDIT CHALLENGE TEST ENDS HERE ==============");
		System.out.println("##############################################################################################################################################");

	}

}

