package pom;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class HotelDetails 
{
	static WebDriver driver;
	ArrayList<String> tabs = new ArrayList<String>();

	@CacheLookup
	@FindBy(linkText = "Room Options")
	WebElement roomOptions;

	@CacheLookup
	@FindBy(id = "room-selection-table-header")
	WebElement roomOptionDisplayVerification;


	@CacheLookup
	@FindBy(xpath = "//img[@class = 'Roomstyles__RoomImageStyled-sc-1ivl7fs-6 kYOUlK']")
	WebElement roomImage;
	
	//"//img[contains(@src,'https://cdn1.goibibo.com/voy_ing/t_g/d38127f6400711e986840242ac110003.jfif')]"

	@CacheLookup
	@FindBy(linkText = "Location")
	WebElement locationDetails;

	@CacheLookup
	@FindBy(xpath = "//input[@placeholder = 'Find nearby attractions and other places near Hotel']")
	WebElement locationDisplayVerification;

	@CacheLookup
	@FindBy(linkText = "Guest Reviews")
	WebElement guestReviews;

	@CacheLookup
	@FindBy(xpath = "//h3[text() = 'Guest Reviews & Rating']")
	WebElement guestReviewsDisplayVerification;

	@CacheLookup
	@FindBy(linkText = "About Property")
	WebElement aboutProperty;

	@CacheLookup
	@FindBy(linkText = "Questions & Answers")
	WebElement qaSection;

	@CacheLookup
	@FindBy(xpath = "//input[@placeholder = 'SEARCH QUESTION']")
	WebElement qaSectionDisplayVerification;

	@CacheLookup
	@FindBy(linkText = "Hotel Policies")
	WebElement hotelPolicies;

	@CacheLookup
	@FindBy(xpath = "//div[text() = 'Hotel Policies']")
	WebElement hotelPoliciesDisplayVerification;


	public HotelDetails(WebDriver driver)
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}

	public void verifyRoomOptions()
	{
		tabs = new ArrayList<String>(driver.getWindowHandles()); 
		driver.switchTo().window(tabs.get(1));
		//System.out.println(driver.getTitle());

		roomOptions.click();

		assertTrue(roomOptionDisplayVerification.isDisplayed());

		File src=((TakesScreenshot)roomImage).getScreenshotAs(OutputType.FILE);

		File screenShotName= new File("/Users/anushaprashanth/eclipse-workspace/certification-project-p1-hybrid/test-output/roomImage.jpg");

		try {
			FileHandler.copy(src, screenShotName );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Reporter.log("<br><img src='"+screenShotName+"' height ='400' width = '400'/><br>");

		if(roomOptionDisplayVerification.isDisplayed())
			Reporter.log("SUCCESS  - The Room Options section is displayed.Verified display of an element in the Room options section");
		else
			Reporter.log("FAILURE  - Display of Room Options section failed");

	}

	public void verifyLocationDetails()
	{	
		locationDetails.click();

		assertTrue(locationDisplayVerification.isDisplayed());

		if(locationDisplayVerification.isDisplayed())
			Reporter.log("SUCCESS  - The Location section is displayed. Verified display of an element in the Location section");
		else
			Reporter.log("FAILURE  - Display of Location section failed");
	}

	public void verifyGuestReviews()
	{	
		guestReviews.click();

		assertTrue(guestReviewsDisplayVerification.isDisplayed());

		if(guestReviewsDisplayVerification.isDisplayed())
			Reporter.log("SUCCESS  - The Guest Review Section is displayed. Verified display of an element in the Guest Reviews section");
		else
			Reporter.log("FAILURE  - Display of Guest Reviews section failed");

	}

	public void verifyQASection()
	{	
		aboutProperty.click();

		qaSection.click();

		assertTrue(qaSectionDisplayVerification.isDisplayed());

		if(qaSectionDisplayVerification.isDisplayed())
			Reporter.log("SUCCESS  - The Q&A Section is displayed. Verified display of an element in the Q&A section");
		else
			Reporter.log("FAILURE  - Display of Q&A section failed");

	}

	public void verifyHotelPolicies()
	{	
		hotelPolicies.click();

		assertTrue(hotelPoliciesDisplayVerification.isDisplayed());

		if(hotelPoliciesDisplayVerification.isDisplayed())
			Reporter.log("SUCCESS  - The Hotel Policies Section is displayed. Verified display of an element in the Hotel Policies section");
		else
			Reporter.log("FAILURE  - Display of Hotel Policies section failed");

	}


}
