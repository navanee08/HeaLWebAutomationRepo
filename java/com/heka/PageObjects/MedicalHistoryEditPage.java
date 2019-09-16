package com.heka.PageObjects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MedicalHistoryEditPage {
	public static Logger log = LogManager.getLogger(MedicalHistoryEditPage.class.getName());

	public WebDriver driver;

	By thyroidSelf = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[2]/app-medical-history/div/table/tbody/tr[1]/td[1]/img");
	By thyroidFamily = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[2]/app-medical-history/div/table/tbody/tr[1]/td[2]/img");
	By diabetesSelf = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[2]/app-medical-history/div/table/tbody/tr[2]/td[1]/img");
	By diabetesFamily = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[2]/app-medical-history/div/table/tbody/tr[2]/td[2]/img");
	By heartDiseasesSelf = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[2]/app-medical-history/div/table/tbody/tr[3]/td[1]/img");
	By heartDiseasesFamily = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[2]/app-medical-history/div/table/tbody/tr[3]/td[2]/img");
	By footProblemsSelf = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[2]/app-medical-history/div/table/tbody/tr[4]/td[1]/img");
	By footProblemsFamily = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[2]/app-medical-history/div/table/tbody/tr[4]/td[2]/img");
	By kidneyDiseasesSelf = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[2]/app-medical-history/div/table/tbody/tr[5]/td[1]/img");
	By kidneyDiseasesFamily = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[2]/app-medical-history/div/table/tbody/tr[5]/td[2]/img");
	By highCholesterolSelf = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[2]/app-medical-history/div/table/tbody/tr[6]/td[1]/img");
	By highCholesterolFamily = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[2]/app-medical-history/div/table/tbody/tr[6]/td[2]/img");
	By dentalProblemsSelf = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[2]/app-medical-history/div/table/tbody/tr[7]/td[1]/img");
	By dentalProblemsFamily = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[2]/app-medical-history/div/table/tbody/tr[7]/td[2]/img");
	By hypertensionSelf = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[2]/app-medical-history/div/table/tbody/tr[8]/td[1]/img");
	By hypertensionFamily = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[2]/app-medical-history/div/table/tbody/tr[8]/td[2]/img");
	By save = By.xpath("/html/body/app-root/app-patient-info/div/div[2]/div/div[3]/div[1]/button");
	
	public MedicalHistoryEditPage(WebDriver driver) {
		this.driver = driver;
	}
	
	

	public WebElement thyroid_By_Self() {
		return driver.findElement(thyroidSelf);
	}

	public WebElement thyroid_By_Family() {
		return driver.findElement(thyroidFamily);
	}
	
	public WebElement diabetes_By_Self() {
		return driver.findElement(diabetesSelf);
	}

	public WebElement diabetes_By_Family() {
		return driver.findElement(diabetesFamily);
	}
	
	public WebElement heartDiseases_By_Self() {
		return driver.findElement(heartDiseasesSelf);
	}

	public WebElement heartDiseases_By_Family() {
		return driver.findElement(heartDiseasesFamily);
	}
	
	public WebElement footProblems_By_Self() {
		return driver.findElement(footProblemsSelf);
	}

	public WebElement footProblems_By_Family() {
		return driver.findElement(footProblemsFamily);
	}
	
	public WebElement kidneyDiseases_By_Self() {
		return driver.findElement(kidneyDiseasesSelf);
	}

	public WebElement kidneyDiseases_By_Family() {
		return driver.findElement(kidneyDiseasesFamily);
	}
	
	public WebElement highCholesterol_By_Self() {
		return driver.findElement(highCholesterolSelf);
	}

	public WebElement highCholesterol_By_Family() {
		return driver.findElement(highCholesterolFamily);
	}
	
	public WebElement dentalProblems_By_Self() {
		return driver.findElement(dentalProblemsSelf);
	}

	public WebElement dentalProblems_By_Family() {
		return driver.findElement(dentalProblemsFamily);
	}
	
	public WebElement hypertension_By_Self() {
		return driver.findElement(hypertensionSelf);
	}

	public WebElement hypertension_By_Family() {
		return driver.findElement(hypertensionFamily);
	}
	
	public WebElement save_Button() {
		return driver.findElement(save);
	}
	
	public void switchToWindow() {
		Alert alert = driver.switchTo().alert();
		log.info("Success message received: " + alert.getText());
		alert.accept();
	}



}
