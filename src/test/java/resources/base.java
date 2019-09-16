package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public static WebDriver driver;
	public Properties prop;
	String projectpath = System.getProperty("user.dir");
	String propertiesPath =projectpath + "\\src\\test\\java\\resources\\data.properties";

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(propertiesPath);

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectpath +"\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectpath + "/drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", projectpath + "/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;

	}

	/*
	 * public void getScreenshot(String result) throws IOException { File src =
	 * ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 * FileUtils.copyFile(src, new File( "C:\\Users\\19407\\Desktop\\Screens" +
	 * result + "screenshot.png"));
	 * 
	 * }
	 */
	
}
