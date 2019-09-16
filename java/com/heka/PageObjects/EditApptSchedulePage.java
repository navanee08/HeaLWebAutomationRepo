package com.heka.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//import com.sun.org.apache.bcel.internal.generic.Select;

public class EditApptSchedulePage {

	public WebDriver driver;

	// Elements locators
	By dashboard = By.xpath("//*[@id=\"navbar3\"]/ul[1]/li[1]");
	By edit = By.xpath("/html/body/app-root/app-doctor-dashboard/div/div[2]/div[2]/table/tbody/tr/td[18]/button");
	By from = By.xpath("/html/body/div[2]/div/div[2]/mat-dialog-container/app-edit-schedule/div[3]/table/tbody[2]/tr/td[1]/select");
	By to = By.xpath("/html/body/div[2]/div/div[2]/mat-dialog-container/app-edit-schedule/div[3]/table/tbody[2]/tr/td[2]/select");
	By save = By.xpath("/html/body/div[2]/div/div[2]/mat-dialog-container/app-edit-schedule/div[2]/button[2]");

	// Constructor
	public EditApptSchedulePage(WebDriver driver) {
		this.driver = driver;
	}

	// Method declaration
	public WebElement mydashboard() {
		return driver.findElement(dashboard);		
	}
	
	public WebElement editSchedule() {
		return driver.findElement(edit);
	}		

	public WebElement select_from() {
		String fromElement ="/html/body/div[2]/div/div[2]/mat-dialog-container/app-edit-schedule/div[3]/table/tbody[2]/tr/td[1]/select";
		Select fromTime = new Select(driver.findElement(By.xpath(fromElement)));
		fromTime.selectByIndex(15);
		return null;		
	}

	public WebElement select_to() {
		String toElement = "/html/body/div[2]/div/div[2]/mat-dialog-container/app-edit-schedule/div[3]/table/tbody[2]/tr/td[2]/select";
		Select toTime = new Select(driver.findElement(By.xpath(toElement)));
		toTime.selectByIndex(16);
		return null;
		
	}

	public WebElement save_Button() {
		return driver.findElement(save);
	}

	public void switchToWindow() {
		Alert alert = driver.switchTo().alert();
		System.out.println("================Doctor has received confirmation message as: " +alert.getText());
		alert.accept();
	}

}
