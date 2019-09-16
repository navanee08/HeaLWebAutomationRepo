package com.heka.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientsDetailsPage {

	public WebDriver driver;

	By detailsButton = By.xpath("/html/body/app-root/app-patients-list/div/data-table/div/div/table/tbody[7]/tr/td[14]/a");
	By selectPeriodDropdownField = By.xpath("/html/body/app-root/app-patient-info/div/div[1]/div[2]/select");

	public PatientsDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement patientDetailsButton() {
		return driver.findElement(detailsButton);
	}

	public WebElement selectPeriodDropdownField() {
		return driver.findElement(selectPeriodDropdownField);
	}

}
