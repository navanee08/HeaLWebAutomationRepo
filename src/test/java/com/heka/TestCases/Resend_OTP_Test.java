package com.heka.TestCases;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.ForgotPasswordPage;
import resources.base;

public class Resend_OTP_Test extends base {
	public static Logger log = LogManager.getLogger(Resend_OTP_Test.class.getName());

	@BeforeMethod
	public void setUp() throws IOException {

		log.info("============== RESEND OTP NEGATIVE TEST STARTS HERE ==================");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");
	}

	@Test
	public void resend_OTP() throws InterruptedException {

		String title = driver.getTitle();
		log.info("The Page Title is: " + title);

		ForgotPasswordPage forgotpw = new ForgotPasswordPage(driver);

		// Forgot Password link
		forgotpw.forgot_Password().click();
		log.info("Clicked on Forgot Password link");
		Thread.sleep(5000);

		// Enter mobile number to receive OTP
		forgotpw.enterMobileNumber().sendKeys("8099595915");
		log.info("Entered mobile number to receive OTP");

		// Click on Send OTP
		forgotpw.send_OTP().click();
		Thread.sleep(10000);
		log.info("Clicked on SEND OTP");

		// Click on RESEND OTP
		forgotpw.resend_OTP().click();
		Thread.sleep(5000);
		log.info("Clicked on RESEND OTP");

		// Click on Enter OTP
		forgotpw.enter_OTP().sendKeys("5678");
		log.info("Entered OTP which was received in mobile");

		// Click on Verify OTP
		forgotpw.verify_OTP();
		Thread.sleep(10000);
		log.info("Clicked on VERIFY OTP");

	}	

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is successfully closed");
		log.info("============== RESEND OTP NEGATIVE TEST ENDS HERE ====================");
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