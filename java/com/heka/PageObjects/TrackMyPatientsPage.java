package com.heka.PageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrackMyPatientsPage {
	public static Logger log = LogManager.getLogger(SignupPage.class.getName());

	public WebDriver driver;

	By trackmypatients = By.xpath("//*[@id=\"navbar3\"]/ul[1]/li[3]");
	By instanceMessageButton = By.xpath("/html/body/app-root/app-patients-list/div/data-table/div/div/table/tbody[7]/tr/td[13]/button");
	By instanceMessageBox = By.xpath("//*[@id=\"cdk-overlay-0\"]/mat-dialog-container/app-labtest/div[2]/textarea");
	By sendButton = By.xpath("//*[@id=\"cdk-overlay-0\"]/mat-dialog-container/app-labtest/div[2]/button");
	By diagnosisMessage = By.xpath("/html/body/app-root/app-patient-info/div/div[1]/div[5]/div[2]/textarea");
	By save = By.xpath("/html/body/app-root/app-patient-info/div/div[1]/div[5]/div[2]/button");
	
	public TrackMyPatientsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMyPatients() {
		return driver.findElement(trackmypatients);
	}

		
	public WebElement getInstanceMessage() {
		return driver.findElement(instanceMessageButton);
	}
	
	public WebElement getInstanceMessageBox() {
		return driver.findElement(instanceMessageBox);
	}
	
	public WebElement send_Button() {
		return driver.findElement(sendButton);
	}
	
	public WebElement diagnosis_Message() {
		return driver.findElement(diagnosisMessage);
	}
	
	public WebElement saveButton() {
		return driver.findElement(save);
	}
	
	public void switchToWindow() {
		Alert alert = driver.switchTo().alert();
		log.info("alert message: " +alert.getText());
		alert.accept();
	}
	
}
