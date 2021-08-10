package test;

import org.testng.annotations.Test;

import utils.Keywords;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.net.UrlChecker;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Scenario3 extends Base{

	Keywords kw;

	@BeforeClass

	public void beforeClass()
	{
		kw = new Keywords(driver);
	}

	@Parameters({"location","url"})
	@Test(priority = 1,enabled=true)
	public void s3(String location,String url) 
	{

		kw.clickHotels(url);
		kw.enterLocation(location);
		kw.checkIncheckOut();
		kw.selectGuests();

		kw.clickhotelandverifyName();

	}

	@Test(priority = 2,enabled=true)
	public void verifyRoomOptions()
	{
		kw.verifyRoomOptions();
	}

	@Test(priority = 3,enabled=true)
	public void verifyLocationDetails()
	{
		kw.verifyLocationDetails();
	}

	@Test(priority = 4,enabled=true)
	public void verifyGuestReviews()
	{
		kw.verifyGuestReviews();
	}

	@Test(priority = 5,enabled=true)
	public void verifyQASection()
	{
		kw.verifyQASection();
	}

	@Test(priority = 6,enabled=true)
	public void verifyhotelPolicies()
	{
		kw.verifyhotelPolicies();
	}

}
