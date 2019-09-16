package com.heka.PageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddPrescriptionPage {
	public static Logger log = LogManager.getLogger(AddPrescriptionPage.class.getName());

	public WebDriver driver;

	By addprescription = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[5]/div[1]/button");
	By newmedicinebutton = By.xpath("//*[@id=\"cdk-overlay-0\"]/mat-dialog-container/app-prescription-details/div[2]/div[2]/button/span");
	By medicine = By.id("mat-input-1");
	By dose = By.xpath("//*[@id=\"cdk-overlay-0\"]/mat-dialog-container/app-prescription-details/div[2]/div[3]/div[1]/app-prescription/div[1]/a[2]/div/div[2]/input");
	By frequencydropdown = By.xpath("//*[@class='form-control ng-pristine ng-valid ng-touched']");
	By duration = By.xpath("//*[@id=\"cdk-overlay-0\"]/mat-dialog-container/app-prescription-details/div[2]/div[3]/div[1]/app-prescription/div[1]/a[2]/div/div[4]/input");
	By notes = By.xpath("//*[@id=\"cdk-overlay-0\"]/mat-dialog-container/app-prescription-details/div[2]/div[3]/div[1]/app-prescription/div[1]/a[2]/div/div[5]/input");
	By afterbreakfastbutton = By.xpath("//*[@id=\"mat-radio-3\"]/label/div[1]/div[1]");
	By save = By.xpath("//*[@id=\"cdk-overlay-0\"]/mat-dialog-container/app-prescription-details/div[2]/div[1]/div[2]/button");
	By close = By.xpath("//*[@id=\"cdk-overlay-5\"]/mat-dialog-container/app-prescription-details/div[1]/button");
	By delete = By.xpath("//*[@id=\"cdk-overlay-2\"]/mat-dialog-container/app-prescription-details/div[2]/div[3]/div/app-prescription/div/a[2]/div/div[6]/div[2]/button");
	By saveAfterDelete = By.xpath("//*[@id=\"cdk-overlay-0\"]/mat-dialog-container/app-prescription-details/div[2]/div[1]/div[2]/button");
	
	public AddPrescriptionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	

	public WebElement add_Button() {
		return driver.findElement(addprescription);
	}

	public WebElement new_Medicine_Button() {
		return driver.findElement(newmedicinebutton);
	}

	public WebElement enter_Medicine_Name() {
		return driver.findElement(medicine);		
	}
	
	public WebElement dose() {
		return driver.findElement(dose);
	}

	public WebElement frequency_Dropdown() {
		return driver.findElement(frequencydropdown);
	}

	public WebElement duration() {
		return driver.findElement(duration);
	}

	public WebElement notes() {
		return driver.findElement(notes);
	}
	
	public WebElement after_Breakfast_Radio_Button() {
		return driver.findElement(afterbreakfastbutton);
	}

	public WebElement save() {
		return driver.findElement(save);
	}
	
	public WebElement close() {
		return driver.findElement(close);
	}
	
	public WebElement deleteMedication() {
		return driver.findElement(delete);
	}
	
	public WebElement save_After_Delete() {
		return driver.findElement(saveAfterDelete);
	}

	public void switchToWindow() {
		Alert alert = driver.switchTo().alert();
		log.info("Success message received: " + alert.getText());
		alert.accept();
	}

}
