package test;

import org.testng.annotations.Test;

import utils.Keywords;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.net.UrlChecker;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Scenario4 extends Base{

	Keywords kw;

	@BeforeClass

	public void beforeClass()
	{
		kw = new Keywords(driver);
	}

	@Parameters({"location","url"})
	@Test(priority = 1,enabled=true)
	public void s4(String location,String url) 
	{

		kw.clickHotels(url);
		kw.enterLocation(location);
		kw.checkIncheckOut();
		kw.selectGuests();

	}

	@Test(priority = 2,enabled=true)
	public void filterByPayAtHotel()
	{
		kw.filterPayAtHotel();
	}

	@Test(priority = 3,enabled=true)
	public void filterByPrice()
	{
		kw.filterByPrice();
	}

	@Test(priority = 4,enabled=true)
	public void filterByCustomerRating()
	{
		kw.filterByCustomerRating();
	}

	@Test(priority = 5,enabled=true)
	public void filterByStars()
	{
		kw.filterByStars();
	}


}
