package utils;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.zip.CheckedOutputStream;

import org.openqa.selenium.WebDriver;

import pom.BookingDetails;
import pom.Homepage;
import pom.HotelDetails;
import pom.Hotels;

public class Keywords extends Common
{

	WebDriver driver;
	Homepage hp;
	Hotels hotel;
	BookingDetails bd;
	HotelDetails hd;

	public Keywords(WebDriver driver)
	{
		this.driver = driver;
		hp = new Homepage(driver);
		hotel = new Hotels(driver);

	}

	public String getPageTitle()
	{
		return driver.getTitle();
	}

	public String getCurrentPageUrl()
	{
		return driver.getCurrentUrl();
	}

	public void compareStrings(String expected,String actual,String Message)
	{
		assertTrue(expected.equals(actual),Message);
	}



	public void clickHotels(String url) 
	{
		hp.clickHotels(url);
	}

	public void enterLocation(String location) 
	{
		
		hotel.enterLocation(location);

	}

	public void checkIncheckOut() 
	{
		hotel.checkIncheckOutDate();;

	}

	public void selectGuests()
	{
		hotel.selectGuestNumber();
	}

	public void clickhotelandverifyName()
	{
		ArrayList<String> verifyNames = new ArrayList<String>();
		verifyNames = hotel.clickHotelAndVerifyName();

		//System.out.println(verifyNames);

		String name1 = verifyNames.get(0);
		String name2 = verifyNames.get(1);

		compareStrings(name1, name2, "The clicked hotel is not the same as the first hotel on results list");

	}

	public void clickSelectRoom()
	{
		bd = new BookingDetails(driver);

		bd.clickSelectRoom();
	}

	public void verifySelectedCheckIn()
	{

		ArrayList<String> detailsSelected = new ArrayList<String>();
		detailsSelected = hotel.getSelectedRequirements();

		ArrayList<String> detailsDisplayed = new ArrayList<String>();
		detailsDisplayed = bd.getDisplayedDetails();

		compareStrings(detailsSelected.get(0), detailsDisplayed.get(0),"The selected and the displayed check in dates do not match");

	}
	public void verifySelectedCheckOut()
	{

		ArrayList<String> detailsSelected = new ArrayList<String>();
		detailsSelected = hotel.getSelectedRequirements();

		ArrayList<String> detailsDisplayed = new ArrayList<String>();
		detailsDisplayed = bd.getDisplayedDetails();

		compareStrings(detailsSelected.get(1), detailsDisplayed.get(1),"The selected and the displayed check out dates do not match");

	}

	public void verifySelectedGuests()
	{

		ArrayList<String> detailsSelected = new ArrayList<String>();
		detailsSelected = hotel.getSelectedRequirements();

		ArrayList<String> detailsDisplayed = new ArrayList<String>();
		detailsDisplayed = bd.getDisplayedDetails();
		
		if(detailsDisplayed.get(2).contains(detailsSelected.get(2)))
		{
			compareStrings("True","True","The selected and the displayed guest number does not match");
		}


	}

	public void fillGuestDetails(String firstName, String lastName, String email, String phone)
	{
		bd.enterGuestDetails(firstName,lastName,email,phone);
	}

	public void fillCardDetails(String cardNumber, String nameOnCard, String expiryDate, String cvv) 
	{
		bd.enterCardDetails(cardNumber, nameOnCard, expiryDate, cvv);

	}

	public void verifyRoomOptions() 
	{
		hd = new HotelDetails(driver);

		hd.verifyRoomOptions();

	}

	public void verifyLocationDetails()
	{
		hd.verifyLocationDetails();
	}

	public void verifyGuestReviews()
	{
		hd.verifyGuestReviews();
	}

	public void verifyQASection()
	{
		hd.verifyQASection();
	}

	public void verifyhotelPolicies()
	{
		hd.verifyHotelPolicies();
	}

	public void filterPayAtHotel()
	{
		hotel.filterPayAtHotel();
	}

	public void filterByPrice()
	{
		hotel.filterByPrice();
	}

	public void filterByStars()
	{
		hotel.filterByStarRating();
	}

	public void filterByCustomerRating()
	{
		hotel.filterByCustomerRating();
	}


}

