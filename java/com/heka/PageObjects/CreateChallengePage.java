package com.heka.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateChallengePage {

	public WebDriver driver;

	By admin = By.cssSelector("#navbar3 > ul:nth-child(1) > li.dropdown");
	By challenges = By.xpath("//a[contains(text(),'Challenges')]");
	By desc = By.xpath("//*[@id=\"desc\"]");
	By upload = By.xpath("//*[@id=\"mat-tab-content-1-0\"]/div/div/div[2]/div[2]/div[1]/div/div[2]/button");
	By challengetype = By.xpath("/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/div[1]/div[2]/select");
	By challengefreq = By.xpath("/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/div[1]/div[3]/select");
	By item = By.xpath("");
	By goal = By.xpath("//input[@id='goal' and @type='number']");
	By goalInGramsOrSteps = By.xpath("/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/div[1]/div[4]/div/div[2]/select");
	By sdate = By.xpath("/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/div[1]/div[5]/input");
	By selectsdate = By.xpath("//*[@id=\"mat-datepicker-0\"]/div[2]/mat-month-view/table/tbody/tr[5]/td[5]/div");
	By choosefile = By.xpath("//*[@id=\"photo\"]");
	By edate = By.xpath("//*[@id=\"mat-tab-content-1-0\"]/div/div/div[2]/div[2]/div[5]/mat-datepicker-toggle/button/span/mat-icon/svg/path[2]");
	By selectedate = By.xpath("//*[@id=\"mat-datepicker-1\"]/div[2]/mat-month-view/table/tbody/tr[5]/td[6]/div");
	By exerciseItem = By.xpath("//*[@id=\"type\"]");
	By points = By.xpath("//input[@id='points' and @type='number']");
	By maxpoints = By.xpath("/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/div[2]/div[4]/input");
	By save = By.xpath("/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[1]/div[2]/button[1]");
	
	
	public CreateChallengePage(WebDriver driver) {
		this.driver = driver;
	}

	
	public WebElement getAdmin() {
		return driver.findElement(admin);
	}
	
	public WebElement getChallenges() {
		return driver.findElement(challenges);
	}
	
	public WebElement description() {
		return driver.findElement(desc);
	}
	
	public WebElement upload_Image_Button() {
		return driver.findElement(upload);
	}
	
	public void challengeType() {
		String challengeType = "/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/div[1]/div[2]/select";
		Select select1 = new Select(driver.findElement(By.xpath(challengeType)));
		select1.selectByVisibleText("Exercise");
	}
	
	public void enterAndSelectItemType() {
		String itemType = "//*[@id=\"type\"]";
		driver.findElement(By.xpath(itemType)).sendKeys("steps");
		driver.findElement(By.xpath(itemType)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath(itemType)).sendKeys(Keys.ENTER);
	}
	
	public void challengeFreq() {
		String challengefreq = "/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/div[1]/div[3]/select";
		Select select = new Select(driver.findElement(By.xpath(challengefreq)));
		select.selectByVisibleText("Daily");
	}
	
	public WebElement challengeStepsGoal() {
		return driver.findElement(goal);
	}
	
	public void goal_In_Grams_Or_Steps() {
		String goalInGramsOrSteps = "/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/div[1]/div[4]/div/div[2]/select";
		Select select3 = new Select(driver.findElement(By.xpath(goalInGramsOrSteps)));
		select3.selectByVisibleText("Steps");		
	}
	
	public void challengeStartDate() throws InterruptedException {
		String calendar = "/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/div[1]/div[5]/mat-datepicker-toggle";
		String selectSDate = ".mat-calendar-body-active";
		driver.findElement(By.xpath(calendar)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(selectSDate)).click();		
	}
	
	public void challengeEndDate() throws InterruptedException {
		String calendar1 = "/html/body/app-root/app-challenge/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[2]/div[2]/div[5]/mat-datepicker-toggle";
		String selectEDate = ".mat-calendar-body > tr:nth-child(5) > td:nth-child(7)";
		driver.findElement(By.xpath(calendar1)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(selectEDate)).click();		
	}
		
	public WebElement choose_File() {
		return driver.findElement(choosefile);
	}
	
	
	public WebElement exercise() {
		return driver.findElement(exerciseItem);
	}
	
	public WebElement challengePoints() {
		return driver.findElement(points);
	}
	
	public WebElement maxChallengePoints() {
		return driver.findElement(maxpoints);
	}
	
	public WebElement save_Button() {
		return driver.findElement(save);
	}
	
	public void switchToWindow() {
		Alert alert = driver.switchTo().alert();
		System.out.println("Confirm message received as: " +alert.getText());
		alert.accept();
	}
	
	
}
