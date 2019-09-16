package com.heka.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TabsNavigationPage {

	public WebDriver driver;

	By dashboard = By.xpath("//*[@id=\"navbar3\"]/ul[1]/li[1]/a");
	By myschedule = By.xpath("//*[@id=\"navbar3\"]/ul[1]/li[2]");
	By trackmypatients = By.xpath("//*[@id=\"navbar3\"]/ul[1]/li[3]");
	By admin = By.cssSelector("#navbar3 > ul:nth-child(1) > li.dropdown");
	
	public TabsNavigationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getdashboard() {
		return driver.findElement(dashboard);
	}

	public WebElement getMySchedule() {
		return driver.findElement(myschedule);
	}

	public WebElement getTrackMyPatientsTab() {
		return driver.findElement(trackmypatients);
	}

	public WebElement getAdmin() {
		return driver.findElement(admin);
	}
	
	
}
