package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Homepage {

	static WebDriver driver;
	static String homepageurl;

	@CacheLookup
	@FindBy(xpath = "//span[@class='header-sprite nav-icon-hotels gr-append-right5']")
	WebElement hotel;

	@CacheLookup
	@FindBy(xpath = "//input[@class='HomePageAutosuggeststyles__SearchInputStyles-sc-1v6s32j-1 euhecC']")
	WebElement hotelLocation;

	public Homepage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void clickHotels(String url)
	{

		homepageurl = url;
		driver.navigate().to(homepageurl);

		hotel.click();

	}

}
