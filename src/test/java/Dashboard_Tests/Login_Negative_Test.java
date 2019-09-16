package Dashboard_Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.LoginPage;
import resources.Library;
import resources.base;


public class Login_Negative_Test extends base {		
	public static Logger log = LogManager.getLogger(Login_Negative_Test.class.getName());
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		log.info("=================LOGIN NEGATIVE TEST STARTS HERE==================");
		driver = initializeDriver();
		log.info("Launching browser");		
		driver.get(prop.getProperty("prodUrl"));		
		log.info("Launching Application URL");
	}

	@Test(timeOut=60000)
	public void login_With_Invalid_Mobile_Number() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		LoginPage login = new LoginPage(driver);

		//Enter invalid login details
		Library.sendKeys(driver, login.getMobile(), 10, "9441053222");
		Library.sendKeys(driver, login.getPassword(), 10, "asdf1234");
		Library.click(driver, login.Signin(), 10);
		Thread.sleep(5000);
		
		// Switch to alert and accept
		login.switchToWindow();
		System.out.println("Login failed due to entering invalid mobile number");
		

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("=================LOGIN NEGATIVE TEST ENDS HERE==================");
		System.out.println("##############################################################################################################################################");

	}
}

//##########################################################################################################################################################################
