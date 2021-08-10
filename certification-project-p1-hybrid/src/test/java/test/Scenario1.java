package test;

import org.testng.annotations.Test;

import utils.Keywords;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.net.UrlChecker;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Scenario1 extends Base{

	Keywords kw;

	@BeforeClass

	public void beforeClass()
	{
		kw = new Keywords(driver);
	}

	@Parameters({"location","url"})
	@Test(enabled = true)
	public void s1(String location,String url) 
	{

		kw.clickHotels(url);
		kw.enterLocation(location);
		kw.checkIncheckOut();
		kw.selectGuests();

	}	

}
