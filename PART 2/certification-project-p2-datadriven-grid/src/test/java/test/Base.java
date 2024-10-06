package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utils.Common;
import utils.ReadExcel;

import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Base
{
	WebDriver driver;
	ReadExcel re = new ReadExcel();
	static XSSFSheet sheet;
	Common common;

	@BeforeClass(groups = {"Grid"})
	@Parameters({"grid","browser","huburl"})
	public void beforeTest(String grid, String browser, String url) 
	{
		common = new Common();
		
		common.setUp(grid, browser, url);
		driver = common.getDriver();
		sheet = re.getWorksheet();
		
	}

	@AfterClass(groups = {"Grid"})
	public void afterTest() 
	{
		common.quitBrowser();
		re.closeWorkbook();

	}

}
