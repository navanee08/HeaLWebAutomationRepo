package com.heka.PageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MedicationLogPage {
	public static Logger log = LogManager.getLogger(MedicationLogPage.class.getName());

	public WebDriver driver;

	By medicationlog = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[5]/div[2]/button");
	By patientmedication = By.xpath("//*[@id=\"cdk-overlay-3\"]/mat-dialog-container/app-prescription-details/div[2]/div");
	By close = By.xpath("//*[@id=\"cdk-overlay-3\"]/mat-dialog-container/app-prescription-details/div[1]/button");
	
	
	public MedicationLogPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	

	public WebElement medication_log_Button() {
		return driver.findElement(medicationlog);
	}
	
	public WebElement patient_Medication_Window_Title() {
		return driver.findElement(patientmedication);//Window name
	}
	
	public WebElement close_Button() {
		return driver.findElement(close);
	}

}
