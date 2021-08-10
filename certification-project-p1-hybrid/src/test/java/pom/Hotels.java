package pom;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import utils.Keywords;

public class Hotels {

	static WebDriver driver;
	static String homepageurl;

	String CIDate;
	String CODate;

	String selectedCheckInDate;
	String selectedCheckOutDate;
	String selectedAdults;

	ArrayList<String> tabs = new ArrayList<String>();


	@CacheLookup
	@FindBy(xpath = "//input[@class='HomePageAutosuggeststyles__SearchInputStyles-sc-1v6s32j-1 euhecC']")
	WebElement hotelLocation;

	@CacheLookup
	@FindBy(xpath = "//li[@id = 'downshift-1-item-0']")
	WebElement selectLocation;

	@CacheLookup
	@FindBy(xpath = "//div[@data-testid = 'openCheckinCalendar']")
	WebElement checkIn;

	@CacheLookup
	@FindBy(xpath = "//span[@data-testid = 'calendarRightArrowBtn']")
	WebElement forwardArrow;

	@CacheLookup
	@FindBy(xpath = "//span[text() = '24']")
	WebElement checkInDate;

	@CacheLookup
	@FindBy(xpath = "//div[@data-testid='openCheckinCalendar']//child::h4")
	WebElement readCheckInDate;

	@CacheLookup
	@FindBy(xpath = "//span[text() = '28']")
	WebElement checkOutDate;

	@CacheLookup
	@FindBy(xpath = "//div[@data-testid='openCheckoutCalendar']//child::h4")
	WebElement readCheckOutDate;

	@CacheLookup
	@FindBy(xpath = "//span[text() = 'Guests & Rooms']")
	WebElement guests;

	@CacheLookup
	@FindBy(xpath = "//*[@class = 'PaxWidgetstyles__ContentWrapperDiv-sc-gv3w6r-1 gwNJlK']//child::div[2]/div/span[text() = '-']")
	WebElement selectAdultsNumber;

	@CacheLookup
	@FindBy(xpath = "//*[@class='PaxWidgetstyles__ContentWrapperDiv-sc-gv3w6r-1 gwNJlK']/div[2]//child::h4")
	WebElement selectedAdultsNumber;
	//"//input[contains(@value,'1 Guest')]"

	@CacheLookup
	@FindBy(xpath = "//button[@class = 'dwebCommonstyles__ButtonBase-sc-112ty3f-10 PaxWidgetstyles__ButtonWrapper-sc-gv3w6r-11 KETBj dIHxWr']")
	WebElement done;

	@CacheLookup
	@FindBy(xpath = "//button[@data-testid = 'searchHotelBtn']")
	WebElement searchButton;

	@CacheLookup
	@FindBy(xpath = "//div[@class = 'HotelCardstyles__HotelNameWrapperDiv-sc-1s80tyk-12 biniNQ']//child::h4[1]")
	WebElement hotelName;

	@CacheLookup
	@FindBy(xpath = "//h1[@itemprop = 'name']")
	WebElement clickedHotelName;

	@CacheLookup
	@FindBy(xpath = "//span[text() = 'Pay At Hotel Available']")
	WebElement filterbyPayAtHotel;

	@CacheLookup
	@FindBy(xpath = "//span[text() = '₹4001 - ₹6000']")
	WebElement filterByPriceRange;

	@CacheLookup
	@FindBy(xpath = "//div[@class = 'Filtersstyles__AverageReviewWrapper-sc-bkjigy-9 lkmokb']")
	WebElement filterByCustomerRating;

	@CacheLookup
	@FindBy(xpath = "//span[@class = 'Filtersstyles__StarRatingWrapperSpan-sc-bkjigy-7 paZbu'][1]")
	WebElement filterByStarRating;

	public Hotels(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}


	public void enterLocation(String location)
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		hotelLocation.clear();
		hotelLocation.sendKeys(location);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		selectLocation.click();
	}


	public void checkIncheckOutDate() 
	{
		//Click on check-in option
		checkIn.click();

		//Move out 3 months from current date

		forwardArrow.click();
		forwardArrow.click();
		forwardArrow.click();

		//Select the check in and check out dates

		checkInDate.click();

		selectedCheckInDate = readCheckInDate.getText();

		checkOutDate.click();

		selectedCheckOutDate = readCheckOutDate.getText();

	}

	public void selectGuestNumber()
	{
		String hotelName;

		//Click on Guests and Bedrooms

		guests.click();

		//change number of Adults from 2(which is the default value) to 1.

		selectAdultsNumber.click();

		selectedAdults = selectedAdultsNumber.getText();

		//Click on Done

		done.click();

		//Click on search hotels

		searchButton.click();

		hotelName = this.hotelName.getText();

		Reporter.log("HOTEL NAME IS: " + hotelName);
	}

	public void filterPayAtHotel()
	{
		//pay at hotel
		filterbyPayAtHotel.click();
	}

	public void filterByPrice()
	{
		//price range
		filterByPriceRange.click();
	}

	public void filterByCustomerRating()
	{
		//customer rating
		filterByCustomerRating.click();

	}


	public void filterByStarRating()
	{
		//Star rating
		filterByStarRating.click();

	}

	public ArrayList<String> getSelectedRequirements()
	{
		ArrayList<String> details = new ArrayList<String>();

		details.add(selectedCheckInDate);
		details.add(selectedCheckOutDate);
		details.add(selectedAdults);

		return details;
	}

	public ArrayList<String> clickHotelAndVerifyName()
	{

		ArrayList<String> verifyNames = new ArrayList<String>();

		String hotelName1 = hotelName.getText();

		hotelName.click();

		tabs = new ArrayList<String>(driver.getWindowHandles()); 

		driver.switchTo().window(tabs.get(1));

		String hotelName2 = clickedHotelName.getText();

		verifyNames.add(hotelName1);
		verifyNames.add(hotelName2);

		return verifyNames;
	}


}
