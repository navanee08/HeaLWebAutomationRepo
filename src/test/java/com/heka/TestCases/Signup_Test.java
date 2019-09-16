//ALWAYS ENTER NEW MOBILE NUMBER FOR SIGN UP POSITIVE TEST
package com.heka.TestCases;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.base;

public class Signup_Test extends base {
	public static Logger log = LogManager.getLogger(Signup_Test.class.getName());

	@BeforeMethod
	public void setUp() throws IOException {
		log.info("============ SIGN UP TEST STARTS HERE =========");
		driver = initializeDriver();
		log.info("Browser is launched");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Application URL is launched");

	}

	@Test
	public void signUp_Test() {
		throw new SkipException("Skipping this test as it cannot be scheduled because it will create multiple users in the system");
		
	}

		/*SignupPage signup = new SignupPage(driver);
throw new SkipException("Skipping Sign Up test as this test cannot be scheduled in Production as this will create multiple users");
		// Click on Register Here link
		signup.getRegister().click();
		log.info("Clicked on Register Here link");

		// Enter SIGN UP details
		signup.getFname().sendKeys("Ankaiah");
		signup.getLname().sendKeys("Swensa");
		signup.getDegree().sendKeys("MD");
		signup.getDesignation().sendKeys("General Medicine");
		signup.getMobile().sendKeys("9502781721");
		signup.getEmail().sendKeys("vn65@hotmail.com");
		signup.getPassword().sendKeys("12341234");
		log.info("Entered signup details");

		// Click on SIGN UP button
		signup.SignUpButton().click();
		log.info("Clicked on SIGN UP button");
		Thread.sleep(5000);

		// Switch on to confirmation pop up window and say OK
		signup.switchToWindow();
		Thread.sleep(2000);

	}
*/
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Browser is closed");
		log.info("============ SIGN UP TEST ENDS HERE ==========");
		System.out.println("###############################################################################################################################################");

	}
}

//########################################################################################################

/*
 * @DataProvider // supplying data for a test method. public Object[][]
 * getData() throws IOException, InvalidFormatException { // FileInputStream fis
 * = new // FileInputStream("C:\\Users\\19407\\Desktop\\Book1.xlsx"); // Your
 * .xlsx file // name along with path File src = new
 * File("C:\\Apps\\HeaLMobileAutomation\\DataFiles\\LoginDataSingle.xlsx"); //
 * Your .xlsx file name // along with path fis = new FileInputStream(src);
 * excelWorkbook = new XSSFWorkbook(src); // Read sheet inside the workbook by
 * its name excelSheet = excelWorkbook.getSheet("Sheet1"); // Your sheet name //
 * Find number of rows in excel file
 * System.out.println("First Row Number/index:" + excelSheet.getFirstRowNum() +
 * " *** Last Row Number/index:" + excelSheet.getLastRowNum()); int rowCount =
 * excelSheet.getLastRowNum() - excelSheet.getFirstRowNum() + 1; int colCount =
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

//################################################# E N D  O F  C O D E ##################################################################
