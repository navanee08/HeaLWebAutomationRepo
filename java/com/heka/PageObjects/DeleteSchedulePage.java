package com.heka.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.sun.org.apache.bcel.internal.generic.Select;

public class DeleteSchedulePage {

	public WebDriver driver;

	// Elements locators
	By myScheduleTab = By.xpath("//*[@id=\"navbar3\"]/ul[1]/li[2]/a");
	By select_year = By.xpath("//*[@id=\"section1\"]/div/div[2]/div[1]/div/select");
	By select_month = By.xpath("//*[@id=\"section1\"]/div/div[2]/div[2]/div/select");
	By select_day = By.xpath("//*[@id=\"section1\"]/div/div[2]/div[3]/div/select");
	By date = By.xpath("//*[@class='mat-button-toggle-label-content']");
	By deleteApptButton=By.xpath("//*[@id=\"section2\"]/div/div[2]/div/div/table/tbody/tr[2]/td[4]/button/span");
	By save = By.xpath("/html/body/app-root/app-doctor-scheduler/div/div/div[2]/div[2]/div/div[1]/button");	
	

	// Constructor
	public DeleteSchedulePage(WebDriver driver) {
		this.driver = driver;
	}

	// Method declaration
	public WebElement myScheduleTab() {
		return driver.findElement(myScheduleTab);
	}

	public WebElement select_year() {
		Select stat = new Select(driver.findElement(select_year));
		stat.selectByVisibleText("2019");
		return null;
	}

	public WebElement select_month() {
		Select stat = new Select(driver.findElement(select_month));
		stat.selectByVisibleText("December");
		return null;
	}

	public WebElement select_day() {
		Select stat = new Select(driver.findElement(select_day));
		stat.selectByVisibleText("Friday");
		return null;
	}

	public WebElement getDate() {
		return driver.findElement(date);
	}

	public WebElement deleteAppointment() {
		return driver.findElement(deleteApptButton);
	}
	
	public WebElement save_Button() {
		return driver.findElement(save);
	}

	public void switchToWindow() {
		Alert alert = driver.switchTo().alert();
		System.out.println("================Confirmation message received as : " +alert.getText());
		alert.accept();

	}	

}
