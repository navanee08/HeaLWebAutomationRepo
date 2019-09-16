package com.heka.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DeleteChallengePage {

	public WebDriver driver;

	By admin = By.cssSelector("#navbar3 > ul:nth-child(1) > li.dropdown");
	By challenges = By.xpath("//a[contains(text(),'Challenges')]");
	By delete = By.xpath("/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[3]/div[2]/table/tbody/tr[75]/td[12]/span");
	

	public DeleteChallengePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAdmin() {
		return driver.findElement(admin);
	}

	public WebElement getChallenges() {
		return driver.findElement(challenges);
	}

	public WebElement delete_Challenge() {
		return driver.findElement(delete);
	}

	public void switchToDeleteConfirmPopUP() {
		Alert alert = driver.switchTo().alert();
		System.out.println("Delete Confirm message received as: " + alert.getText());
		alert.accept();
	}
	
	public void switchToDeleteSuccessPopup() {
		Alert alert1 = driver.switchTo().alert();
		System.out.println("Delete success message received as: " + alert1.getText());
		alert1.accept();
	}

}
