package test;

import org.testng.annotations.Test;

import utils.Keywords;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.net.UrlChecker;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Scenario2 extends Base{

	Keywords kw;

	@BeforeClass

	public void beforeClass()
	{
		kw = new Keywords(driver);
	}

	@Parameters({"location","url"})
	@Test(priority = 1,enabled=true)
	public void s2(String location,String url) 
	{

		kw.clickHotels(url);
		kw.enterLocation(location);
		kw.checkIncheckOut();
		kw.selectGuests();

		kw.clickhotelandverifyName();
		kw.clickSelectRoom();

	}

	@Test(priority = 2,enabled=true)
	public void verifySelectedCheckInDate() 
	{
		kw.verifySelectedCheckIn();;
	}

	@Test(priority = 3,enabled=true)
	public void verifySelectedCheckOutDate() 
	{
		kw.verifySelectedCheckOut();
	}

	@Test(priority = 4,enabled=true)
	public void verifySelectedGuestsNumber() 
	{
		kw.verifySelectedGuests();
	}

	@Parameters({"firstName","lastName","email","phone"})
	@Test(priority = 5,enabled=true)
	public void enterGuestDetails(String firstName, String lastName, String email, String phone) 
	{
		kw.fillGuestDetails(firstName,lastName,email,phone);
	}

	@Parameters({"cardNumber","nameOnCard","expiryDate","cvv"})
	@Test(priority = 6,enabled=true)
	public void enterCardDetails(String cardNumber, String nameOnCard, String expiryDate, String cvv) 
	{
		kw.fillCardDetails(cardNumber,nameOnCard,expiryDate,cvv);
	}

}
