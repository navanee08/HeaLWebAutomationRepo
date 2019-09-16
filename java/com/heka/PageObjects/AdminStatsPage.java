package com.heka.PageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminStatsPage {
	public static Logger log = LogManager.getLogger(AdminStatsPage.class.getName());

	public WebDriver driver;

	By admin = By.cssSelector("#navbar3 > ul:nth-child(1) > li.dropdown");
	By stats = By.xpath("//*[@id=\"navbar3\"]/ul[1]/li[4]/ul/li[6]/a");
	By duration = By.xpath("/html/body/app-root/app-avg-stats/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/div/input");
	By runstats = By.xpath("/html/body/app-root/app-avg-stats/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/div/button");
	By quadrant = By.xpath("//*[@id=\"mat-tab-label-1-1\"]");
	By browse = By.xpath("/html/body/app-root/app-avg-stats/mat-tab-group/div/mat-tab-body[2]/div/div[1]/tbody/tr/td[2]/input");
	By selectweekfrom = By.cssSelector("#mat-tab-content-1-1 > div > div:nth-child(1) > tbody > tr > td:nth-child(3) > select");
	By fromWeek = By.xpath("#mat-tab-content-1-1 > div > div:nth-child(1) > tbody > tr > td:nth-child(3) > select");
	By toWeek =By.xpath("/html/body/app-root/app-avg-stats/mat-tab-group/div/mat-tab-body[2]/div/div[1]/tbody/tr/td[4]/select");
	By run = By.xpath("/html/body/app-root/app-avg-stats/mat-tab-group/div/mat-tab-body[2]/div/div[1]/tbody/tr/td[5]/button");
	
	
	public AdminStatsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAdmin() {
		return driver.findElement(admin);
	}
	
	public WebElement stats_Dropdown_Value() {
		return driver.findElement(stats);
	}
	
	public WebElement StatsDuration() {
		return driver.findElement(duration);
	}
	
	public WebElement runStats() {
		return driver.findElement(runstats);
	}
	
	public void switchToWindow() {
		Alert alert = driver.switchTo().alert();
		log.info("Success message received: " + alert.getText());
		alert.accept();
	}
	
	public WebElement runQuadrants() {
		return driver.findElement(quadrant);
	}
	
	public WebElement browse_Button() {
		return driver.findElement(browse);
	}
	
	
	public WebElement select_Week_From() {		
		return driver.findElement(fromWeek);		
	}	
	
	
	public WebElement select_Week_To() {
		return driver.findElement(toWeek);		
	}	
	
	public WebElement run() {
		return driver.findElement(run);
	}
	
	
}
