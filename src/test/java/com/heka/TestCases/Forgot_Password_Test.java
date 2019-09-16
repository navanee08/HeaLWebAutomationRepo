package com.heka.TestCases;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.ForgotPasswordPage;
import com.heka.PageObjects.LoginPage;
import resources.base;

public class Forgot_Password_Test extends base {
	public static Logger log = LogManager.getLogger(Forgot_Password_Test.class.getName());

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		log.info("==============FORGOT PASSWORD TEST STARTS HERE================");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		Thread.sleep(10000);
		log.info("Launching Application URL");
	}

	@Test
	public void forgot_Password() throws InterruptedException {

		LoginPage login = new LoginPage(driver);
		
		//Enter login details
		login.getMobile().sendKeys("9441053222");
		log.info("Entered mobile number");
		login.getPassword().sendKeys("12341233");
		log.info("Entered invalid password");
		login.Signin().click();
		Thread.sleep(3000);
		
		//Switch to error message alert window
		login.switchToWindow();
		log.info("Switched to error message alert window");
		
		ForgotPasswordPage forgotpw = new ForgotPasswordPage(driver);	
		
		//Click on Forgot Password button
		forgotpw.forgot_Password().click();
		Thread.sleep(5000);
		
		//Enter mobile number to receive OTP
		forgotpw.enterMobileNumber().sendKeys("8099595915");
		log.info("Entered mobile number to receive OTP");
		
		//Click on Send OTP
		forgotpw.send_OTP().click();
		Thread.sleep(10000);
		
		//Enter OTP
		forgotpw.enter_OTP().sendKeys("1234");
		Thread.sleep(5000);
		log.info("Entered invalid OTP");
		
		//Verify OTP
		forgotpw.verify_OTP().click();
		Thread.sleep(5000);	
		log.info("Error message received for entering invalid OTP");
		
		//Switch to alert and click on OK button
		forgotpw.switchToWindow();
		Thread.sleep(5000);
		log.info("Switched to alert and clicked on OK button");		

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is successfully closed");
		log.info("============== FORGOT PASSWORD TEST ENDS HERE =================");
		System.out.println("##############################################################################################################################################");

	}
}

//##########################################################################################################################################################################
/*
 * @DataProvider // supplying data for a test method. public Object[][]
 * getData() throws IOException, InvalidFormatException { // FileInputStream fis
 * = new // FileInputStream("C:\\Users\\19407\\Desktop\\Book1.xlsx"); // Your
 * .xlsx file // name along with path String excelPath =
 * "C:\\Users\\19407\\MyWorkspace\\HeaLWeb\\data\\LoginDataForSingleDoctor.xlsx";
 * File src = new File(excelPath); // Your .xlsx file name along with path fis =
 * new FileInputStream(src); excelWorkbook = new XSSFWorkbook(src); // Read
 * sheet inside the workbook by its name excelSheet =
 * excelWorkbook.getSheet("Sheet1"); // Your sheet name // Find number of rows
 * in excel file System.out.println("First Row Number/index:" +
 * excelSheet.getFirstRowNum() + " *** Last Row Number/index:" +
 * excelSheet.getLastRowNum()); int rowCount = excelSheet.getLastRowNum() -
 * excelSheet.getFirstRowNum() + 1; int colCount =
 * excelSheet.getRow(0).getLastCellNum(); System.out.println("Row Count is: " +
 * rowCount + " *** Column count is: " + colCount); Object data[][] = new
 * Object[rowCount - 1][colCount]; for (int rNum = 2; rNum <= rowCount; rNum++)
 * { for (int cNum = 0; cNum < colCount; cNum++) {
 * System.out.print(getCellData("Sheet1", cNum, rNum) + " "); // Your sheet name
 * data[rNum - 2][cNum] = getCellData("Sheet1", cNum, rNum); // Your sheet name
 * } System.out.println(); } return data; }
 * 
 * //Function will always used as below. It returns the data from a cell - No
 * need to make any changes public String getCellData(String sheetName, int
 * colNum, int rowNum) { try { if (rowNum <= 0) return ""; int index =
 * excelWorkbook.getSheetIndex(sheetName); if (index == -1) return "";
 * excelSheet = excelWorkbook.getSheetAt(index); row = excelSheet.getRow(rowNum
 * - 1); if (row == null) return ""; cell = row.getCell(colNum);
 * cell.setCellType(CellType.STRING); if (cell == null) return ""; if
 * (cell.getCellType() == CellType.STRING) { //
 * System.out.println("cellText :"+cell.getStringCellValue()); return
 * cell.getStringCellValue(); } else if (cell.getCellType() == CellType.NUMERIC
 * || cell.getCellType() == CellType.FORMULA) {
 * 
 * String cellText = String.valueOf(cell.getNumericCellValue()); //
 * System.out.println("cellText :"+cellText); return cellText; } else if
 * (cell.getCellType() == CellType.BLANK) return ""; else return
 * String.valueOf(cell.getBooleanCellValue()); } catch (Exception e) {
 * e.printStackTrace(); return "row " + rowNum + " or column " + colNum +
 * " does not exist in xls"; }
 * 
 * }
 * 
 * }
 */