package com.heka.PageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FoodLogPage {
	public static Logger log = LogManager.getLogger(FoodLogPage.class.getName());

	public WebDriver driver;

	By foodlog = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[6]/div[2]/button");
	By perioddropdown = By.cssSelector("#cdk-overlay-3 > mat-dialog-container > app-food-info > div.col-md-12.input-group.patients-period > select");
	By foodlogButton = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[6]/div[2]/button");
	By foodlogtab = By.xpath("//*[@id=\"mat-tab-label-1-0\"]");
	By selectPeriod = By.xpath("/html/body/div/div/div[2]/mat-dialog-container/app-food-info/div[2]/select");
	By detailedfoodlogtab = By.xpath("/html/body/div/div/div[2]/mat-dialog-container/app-food-info/mat-tab-group/mat-tab-header/div[2]/div/div/div[2]/b");
	
	By byWeek = By.xpath("");
	By byMonth = By.xpath("");
	
	
	public FoodLogPage(WebDriver driver) {
		this.driver = driver;
	}	

	public WebElement food_Log_Button() {
		return driver.findElement(foodlogButton);
	}
	
	
	public WebElement selectPeriodWeek() {
		String selectPeriod = "/html/body/div/div/div[2]/mat-dialog-container/app-food-info/div[2]/select";
		Select select = new Select(driver.findElement(By.xpath(selectPeriod)));
		select.selectByIndex(0);
		return null;
	}
	
	public WebElement selectPeriodMonth() {
		String selectPeriod = "/html/body/div/div/div[2]/mat-dialog-container/app-food-info/div[2]/select";
		Select select = new Select(driver.findElement(By.xpath(selectPeriod)));
		select.selectByIndex(1);
		return null;
	}
	
	public WebElement food_Log_Tab() {
		return driver.findElement(foodlogtab);
	}
	
	public WebElement detailed_Food_Log_Tab() {
		return driver.findElement(detailedfoodlogtab);
	}

}
