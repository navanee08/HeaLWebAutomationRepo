package com.heka.PageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	public static Logger log = LogManager.getLogger(ForgotPasswordPage.class.getName());

	public WebDriver driver;

	By forgotpassword = By.xpath("//*[@id=\"loginbox\"]/div/div[2]/form/a");
	By mobilenumber = By.xpath("//*[@id=\"loginbox\"]/div/div[2]/form/div[1]/div/input");
	By sendotp = By.xpath("//*[@id=\"loginbox\"]/div/div[2]/form/div[2]/div/button");
	By enterotp = By.xpath("//*[@id=\"loginbox\"]/div/div[2]/form/div[2]/div/input");
	By verifyotp=By.xpath("//button[contains(text(),'Verify OTP')]");
	By resendotp=By.xpath("//*[@id=\"loginbox\"]/div/div[2]/form/div[3]/div/button[1]");	
	

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement forgot_Password() {
		return driver.findElement(forgotpassword);
	}

	public WebElement enterMobileNumber() {
		return driver.findElement(mobilenumber);
	}

	public WebElement send_OTP() {
		return driver.findElement(sendotp);
	}

	public WebElement enter_OTP() {
		return driver.findElement(enterotp);
	}
	
	public WebElement verify_OTP() {
		return driver.findElement(verifyotp);
	}
	
	public WebElement resend_OTP() {
		return driver.findElement(resendotp);
	}
	
	public void switchToWindow() {
		Alert alert = driver.switchTo().alert();
		log.info("Alert message received : " + alert.getText());
		alert.accept();
	}

}
