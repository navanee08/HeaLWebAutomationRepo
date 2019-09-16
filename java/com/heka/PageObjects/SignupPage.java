package com.heka.PageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.heka.TestCases.Login_With_Data_Driven_Test;

public class SignupPage {
	public static Logger log = LogManager.getLogger(SignupPage.class.getName());

	public WebDriver driver;

	// Elements locators
	By register = By.linkText("Register Here");
	By fname = By.xpath("//*[@id=\"signupbox\"]/div/div[2]/form/div[1]/div/div[2]/input");
	By lname = By.xpath("//*[@id=\"signupbox\"]/div/div[2]/form/div[2]/div/input");
	By degree = By.xpath("//*[@id=\"signupbox\"]/div/div[2]/form/div[3]/div/input");
	By title = By.xpath("//*[@id=\"signupbox\"]/div/div[2]/form/div[4]/div/input");
	By mobile = By.xpath("//*[@id=\"signupbox\"]/div/div[2]/form/div[5]/div/input");
	By email = By.xpath("//*[@id=\"signupbox\"]/div/div[2]/form/div[6]/div/input");
	By password = By.xpath("//*[@id=\"signupbox\"]/div/div[2]/form/div[7]/div/input");
	By signupButton = By.xpath("//*[@id=\"signupbox\"]/div/div[2]/form/div[8]/div/button");
	By text = By.cssSelector("#appt > div.panel-body > h4");
	By nameHead = By.cssSelector("#navbar3 > ul.nav.navbar-nav.navbar-right.ng-star-inserted > li > a > div > span");

	// Constructor
	public SignupPage(WebDriver driver) {
		this.driver = driver;
	}

	// Method declaration
	public WebElement getRegister() {
		return driver.findElement(register);
	}

	public WebElement getFname() {
		return driver.findElement(fname);
	}

	public WebElement getLname() {
		return driver.findElement(lname);
	}

	public WebElement getDegree() {
		return driver.findElement(degree);
	}

	public WebElement getDesignation() {
		return driver.findElement(title);
	}

	public WebElement getMobile() {
		return driver.findElement(mobile);
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement SignUpButton() {
		return driver.findElement(signupButton);
	}

	public WebElement getTitle() {
		return driver.findElement(text);
	}

	public WebElement getDoctorName() {
		return driver.findElement(nameHead);
	}
	public void switchToWindow() {
		Alert alert = driver.switchTo().alert();
		log.info("Alert message as: " +alert.getText());
		alert.accept();
	}

}
