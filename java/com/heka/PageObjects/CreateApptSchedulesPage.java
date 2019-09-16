package com.heka.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//import com.sun.org.apache.bcel.internal.generic.Select;

public class CreateApptSchedulesPage {

	public WebDriver driver;

	// Elements locators
	By myScheduleTab = By.xpath("//*[@id=\"navbar3\"]/ul[1]/li[2]/a");
	By select_year = By.xpath("//*[@id=\"section1\"]/div/div[2]/div[1]/div/select");	
	By select_month = By.xpath("//*[@id=\"section1\"]/div/div[2]/div[2]/div/select");	                  
	By select_day = By.xpath("//*[@id=\"section1\"]/div/div[2]/div[3]/div/select");
	By date = By.xpath("//*[@class='mat-button-toggle-label-content']");
	By from = By.xpath("//*[@id=\"section2\"]/div/div[2]/div/div/table/tbody/tr[2]/td[1]/select");
	By to = By.xpath("//*[@id=\"section2\"]/div/div[2]/div/div/table/tbody/tr[2]/td[2]/select");
	By save = By.xpath("//*[@id=\"section2\"]/div/div[1]/button");
	By dashboard = By.xpath("//*[@id=\"navbar3\"]/ul[1]/li[1]");

	// Constructor
	public CreateApptSchedulesPage(WebDriver driver) {
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

	public String select_month() {
		Select stat = new Select(driver.findElement(select_month));
		stat.selectByVisibleText("September");
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

	public WebElement select_from() {
		Select stat = new Select(driver.findElement(from));
		stat.selectByVisibleText("12:00 PM");
		return null;
	}

	public WebElement select_to() {
		Select stat = new Select(driver.findElement(to));
		stat.selectByVisibleText("01:00 PM");
		return null;
	}

	public WebElement getSave() {
		return driver.findElement(save);
	}

	public void switchToWindow() {
		Alert alert = driver.switchTo().alert();
		System.out.println("Doctor has verified success message: " +alert.getText());
		alert.accept();
	}
	public WebElement getDashboard() {
		return driver.findElement(dashboard);
	}

}
