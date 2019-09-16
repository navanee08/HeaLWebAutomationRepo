package com.heka.TestCases;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.heka.PageObjects.LoginPage;

import resources.base;

public class Login_Test extends base {
	public static Logger log = LogManager.getLogger(Login_Test.class.getName());
	LoginPage login = new LoginPage(driver);

	@BeforeMethod
	public void setUp() throws IOException {

		log.info("===================LOGIN TEST STARTS HERE===================");
		driver = initializeDriver();
		log.info("Launching browser");
		driver.get(prop.getProperty("prodUrl"));
		log.info("Launching Application URL");

	}

	@Test
	public void login_With_Valid_Mobile_Number() throws InterruptedException {
		LoginPage login = new LoginPage(driver);

		// Enter valid login details
		login.getMobile().sendKeys("9441053222");
		login.getPassword().sendKeys("12341234");
		login.Signin().click();
		log.info("Doctor has logged in");
		Thread.sleep(3000);
		Assert.assertEquals(login.getUsername().getText(), "KD");
		log.info("Doctor name is verified");
		String text = login.getDashboard().getText();
		System.out.println("After successful login, as expected, it has correctly displayed" + " " + text);
		Assert.assertEquals("Dashboard", text, "After login, Dashboard is not displayed");
		log.info("Dashboard is verified using assertion");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Driver is closed");
		log.info("===============LOGIN TEST ENDS HERE==================");
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