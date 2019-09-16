package com.heka.PageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewChallengePointsPage {
	public static Logger log = LogManager.getLogger(ViewChallengePointsPage.class.getName());

	public WebDriver driver;

	By admin = By.cssSelector("#navbar3 > ul:nth-child(1) > li.dropdown");
	By challenges = By.xpath("//a[contains(text(),'Challenges')]");
	By points = By.xpath("/html/body/app-root/app-challenge/div/mat-tab-group/mat-tab-header/div[2]/div/div/div[3]/div/b");
	By activechallenge = By.xpath("/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[3]/div/div/div[1]/div/div/select");
	                              

	public ViewChallengePointsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAdmin() {
		return driver.findElement(admin);
	}

	public WebElement getChallenges() {
		return driver.findElement(challenges);
	}

	public WebElement getPointsTab() {
		return driver.findElement(points);
	}

	public WebElement select_Active_Challenge() {
		return driver.findElement(activechallenge);
	}

}
