package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utils.Common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Base {
	Common common;
	static WebDriver driver;

	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browser, String url) {

		common = new Common();
		common.setupBrowser(browser, url);
		driver = common.getDriver();
	}


	@AfterClass
	public void afterClass() 
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		common.quitBrowser();

	}

}
