package com.heka.PageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VitalsRangeAndFrequencyEditPage {
	public static Logger log = LogManager.getLogger(VitalsRangeAndFrequencyEditPage.class.getName());

	public WebDriver driver;

	By vitalsEditButton = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[1]/span");
	By bpSystolicEdit = By.cssSelector("#cdk-overlay-1 > mat-dialog-container > app-vital-goal > div:nth-child(3) > div:nth-child(2) > div > input:nth-child(4)");
	By bpDiastolicEdit = By.xpath("//*[@id=\"cdk-overlay-5\"]/mat-dialog-container/app-vital-goal/div[2]/div[2]/div/input[4]");
	By hba1cLowerRange = By.xpath("//*[@id=\"cdk-overlay-5\"]/mat-dialog-container/app-vital-goal/div[2]/div[3]/div/input[2]");
	By hba1cHigherRange = By.xpath("//*[@id=\"cdk-overlay-5\"]/mat-dialog-container/app-vital-goal/div[2]/div[3]/div/input[3]");
	By tcLowerRange = By.xpath("//*[@id=\"cdk-overlay-5\"]/mat-dialog-container/app-vital-goal/div[2]/div[4]/div/input[2]");
	By tcHigherRange = By.xpath("//*[@id=\"cdk-overlay-5\"]/mat-dialog-container/app-vital-goal/div[2]/div[4]/div/input[3]");
	By trigLowerRange = By.xpath("//*[@id=\"cdk-overlay-5\"]/mat-dialog-container/app-vital-goal/div[2]/div[5]/div/input[2]");
	By trigHigherRange = By.xpath("//*[@id=\"cdk-overlay-5\"]/mat-dialog-container/app-vital-goal/div[2]/div[5]/div/input[3]");
	By save = By.cssSelector("#cdk-overlay-2 > mat-dialog-container > app-vital-goal > div:nth-child(4) > button");
	By handle=By.xpath("//*[@id=\"cdk-overlay-1\"]/mat-dialog-container");
	
	
	public VitalsRangeAndFrequencyEditPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement vitals_Edit_Button() {
		return driver.findElement(vitalsEditButton);
	}

	public WebElement bp_Systolic_Edit() {
		return driver.findElement(bpSystolicEdit);
	}

	public WebElement bp_Diastolic_Edit() {
		return driver.findElement(hba1cLowerRange);
	}

	public WebElement hba1ac_Lower_Range_Edit() {
		return driver.findElement(bpDiastolicEdit);
	}

	public WebElement hba1ac_Higher_Range_Edit() {
		return driver.findElement(hba1cHigherRange);
	}

	public WebElement totalCholesterol_Lower_Range_Edit() {
		return driver.findElement(tcLowerRange);
	}

	public WebElement totalCholesterol_Higher_Range_Edit() {
		return driver.findElement(tcHigherRange);
	}

	public WebElement triglycerides_Lower_Range_Edit() {
		return driver.findElement(trigLowerRange);
	}

	public WebElement triglycerides_Higher_Range_Edit() {
		return driver.findElement(trigHigherRange);
	}

	public WebElement save_Button() {
		return driver.findElement(save);
	}

	public void switchToWindow() {
		Alert alert = driver.switchTo().alert();
		log.info("alert message: " + alert.getText());
		alert.accept();
	}
	
	public void switchToVitalsWindow() throws InterruptedException {
		String currentWindow = driver.getWindowHandle();//Get current window
		System.out.println(currentWindow.toString());
		//ArrayList windows = new ArrayList (driver.getWindowHandles());//Get all opened windows list
		//System.out.println("Open windows: " +windows.size());// print the count of windows
		//Now you can switch into desired window in your case you want to switch into 3rd one so you have to pass the index 2 as it started from 0
		driver.switchTo().window(currentWindow);
		Thread.sleep(10000);

		}

}

