package com.heka.PageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddUsersToChallengePage {
	public static Logger log = LogManager.getLogger(AddUsersToChallengePage.class.getName());

	public WebDriver driver;

	By admin = By.cssSelector("#navbar3 > ul:nth-child(1) > li.dropdown");
	By challenges = By.xpath("//a[contains(text(),'Challenges')]");
	By addusers = By.xpath("/html/body/app-root/app-challenge/div/mat-tab-group/mat-tab-header/div[2]/div/div/div[2]/div/b");
	By activechallenge = By.xpath("/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[2]/div/div/div[1]/div/div/select");
	By getallusers = By.xpath("/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[2]/div/div/div[2]/div[1]/div/div/div[1]/button[1]");
	By selectalluserscheckbox = By.xpath("/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[2]/div/div/div[3]/table/thead/tr/th[2]/input");
	By getallusersbutton = By.xpath("/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[2]/div/div/div[2]/div[2]/div/div/div[2]/button[1]");
	By adduserstochallenge = By.xpath("/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[2]/div/div/div[2]/div[2]/div/div/div[1]/button");
	By run = By.xpath("/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[2]/div/div/div[2]/div[2]/div/div/div[2]/button[2]");
	
	
	public AddUsersToChallengePage(WebDriver driver) {
		this.driver = driver;
	}

	
	public WebElement getAdmin() {
		return driver.findElement(admin);
	}
	
	public WebElement getChallenges() {
		return driver.findElement(challenges);
	}
	
	public WebElement add_Users_Tab() {
		return driver.findElement(addusers);
	}
	
	public WebElement select_Active_Challenge() {
		return driver.findElement(activechallenge);
	}
	
	public WebElement get_All_Users_Button() {
		return driver.findElement(getallusers);
	}
	
	public WebElement select_All_Users() {
		return driver.findElement(selectalluserscheckbox);
	}
	
	public WebElement get_All_Users_In_Challenge() {
		return driver.findElement(getallusersbutton);
	}
	
	public WebElement add_Users_To_Challenge() {
		return driver.findElement(adduserstochallenge);
	}
	
	public WebElement run_Challenge() {
		return driver.findElement(run);
	}
	
	public void switchToWindow() {
		Alert alert = driver.switchTo().alert();
		log.info("Success message received: " + alert.getText());
		alert.accept();
	}
	
	
}
