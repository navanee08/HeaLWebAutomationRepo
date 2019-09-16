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

public class Forgot_Password_Negative_Test extends base {
	public static Logger log = LogManager.getLogger(Forgot_Password_Negative_Test.class.getName());

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		log.info("==============FORGOT PASSWORD TEST STARTS HERE================");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));		
		log.info("Launching Application URL");
	}

	@Test(timeOut=60000)
	public void forgot_Password() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		LoginPage login = new LoginPage(driver);
		
		// Enter login details
		Library.sendKeys(driver, login.getMobile(), 10, "9441053222");
		Library.sendKeys(driver, login.getPassword(), 10, "asdf1234");
		Library.click(driver, login.Signin(), 10);
		Thread.sleep(5000);
				
		
		//Switch to error message alert window
		login.switchToWindow();
		log.info("Switched to error message alert window");
		
		ForgotPasswordPage forgotpw = new ForgotPasswordPage(driver);	
		
		//Click on Forgot Password button
		Library.click(driver, forgotpw.forgot_Password(), 10);
		Thread.sleep(3000);
		
		//Enter mobile number to receive OTP
		Library.sendKeys(driver, forgotpw.enterMobileNumber(), 10, "8099595915");
		Thread.sleep(3000);
		log.info("Entered mobile number to receive OTP");
		Thread.sleep(3000);
		
		//Click on Send OTP
		Library.click(driver, forgotpw.send_OTP(), 10);
		Thread.sleep(5000);
				
		
		//Enter OTP
		Library.sendKeys(driver, forgotpw.enter_OTP(), 10, "1234");
		Thread.sleep(5000);
		log.info("Entered invalid OTP");
		
		//Verify OTP
		Library.click(driver, forgotpw.verify_OTP(), 15);
		Thread.sleep(10000);
		log.info("Error message received for entering invalid OTP");
		
		//Switch to alert and click on OK button
		//forgotpw.switchToWindow();		
		//log.info("Switched to alert and clicked on OK button");		

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is successfully closed");
		log.info("============== FORGOT PASSWORD TEST ENDS HERE =================");
		System.out.println("##############################################################################################################################################");

	}
}

