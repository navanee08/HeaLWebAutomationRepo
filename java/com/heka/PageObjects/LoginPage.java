package com.heka.PageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public static Logger log = LogManager.getLogger(ForgotPasswordPage.class.getName());

	public WebDriver driver;

	By mobile = By.xpath("//*[@id=\"loginbox\"]/div/div[2]/form/div[1]/div/input");
	By password = By.xpath("//*[@id=\"loginbox\"]/div/div[2]/form/div[2]/div/input");
	By signin = By.xpath("//*[@id=\"loginbox\"]/div/div[2]/form/div[4]/div/button");
	By username = By.xpath("//*[@id=\"navbar3\"]/ul[2]/li/a/div/span");
	By doctorDetails=By.xpath("//*[@id=\"navbar3\"]/ul[2]");
	By dashboard = By.xpath("//*[@id=\"navbar3\"]/ul[1]/li[1]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMobile() {
		return driver.findElement(mobile);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement Signin() {
		return driver.findElement(signin);
	}

	public WebElement getUsername() {
		return driver.findElement(username);
	}
	
	public WebElement getDashboard() {
		return driver.findElement(dashboard);
	}
	
	public WebElement physicianDetails() {
		return driver.findElement(doctorDetails);
	}
	
	public void switchToWindow() {
		Alert alert = driver.switchTo().alert();
		log.info("==========Alert message received==========: " + alert.getText());
		alert.accept();
	}

}
