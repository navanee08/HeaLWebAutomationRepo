package Dashboard_Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.ForgotPasswordPage;
import com.heka.PageObjects.LoginPage;

import resources.Library;
import resources.base;

public class Resend_OTP_Test extends base {
	public static Logger log = LogManager.getLogger(Resend_OTP_Test.class.getName());

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		log.info("============== RESEND OTP NEGATIVE TEST STARTS HERE ==================");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test(timeOut=60000)
	public void resend_OTP() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		ForgotPasswordPage forgotpw = new ForgotPasswordPage(driver);
		LoginPage login = new LoginPage(driver);

		// Forgot Password link
		Library.click(driver, forgotpw.forgot_Password(), 10);
		log.info("Clicked on Forgot Password link");

		// Enter mobile number to receive OTP
		Library.sendKeys(driver, login.getMobile(), 10, "8099595915");
		Thread.sleep(3000);
		log.info("Entered mobile number to receive OTP");

		// Click on Send OTP
		Library.click(driver, forgotpw.send_OTP(), 10);
		log.info("Clicked on SEND OTP");
		Thread.sleep(3000);

		// Click on RESEND OTP
		Library.click(driver, forgotpw.resend_OTP(), 10);
		Thread.sleep(3000);
		log.info("Clicked on RESEND OTP");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is successfully closed");
		log.info("============== RESEND OTP NEGATIVE TEST ENDS HERE ====================");
		System.out.println("##############################################################################################################################################");

	}
}
