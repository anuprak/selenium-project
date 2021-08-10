package pom;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookingDetails 
{
	static WebDriver driver;
	ArrayList<String> tabs = new ArrayList<String>();

	@CacheLookup
	@FindBy(xpath = "//div[@class='DurationBlockNew__DurationInnerWrapDiv-sc-1977hwn-0 kNHxPL']//child::div[1]/p")
	WebElement verifyCheckIn;

	@CacheLookup
	@FindBy(xpath = "//div[@class='DurationBlockNew__DurationInnerWrapDiv-sc-1977hwn-0 kNHxPL']//child::div[2]/p")
	WebElement verifyCheckOut;

	@CacheLookup
	@FindBy(xpath = "//p[contains(text(),'1 Guest')]")
	WebElement verifyGuestNumber;
	//"//div[@class='DurationBlockNew__DurationInnerWrapDiv-sc-1977hwn-0 kNHxPL']//child::div[3]/p"

	@CacheLookup
	@FindBy(xpath = "//div[@class = 'RoomFlavorstyles__RoomFlavorColumn-sc-1btnl3r-0 ktNvWP']//child::button")
	WebElement selectRoom;

	@CacheLookup
	@FindBy(css = "select.PersonalProfile__NameEnterSelect-sc-1r9ak8b-7.hkMeMW")
	WebElement selectGender;

	@CacheLookup
	@FindBy(xpath = "//input[@placeholder = 'Enter First Name']")
	WebElement enterFirstName;

	@CacheLookup
	@FindBy(xpath = "//input[@placeholder = 'Enter Last Name']")
	WebElement enterLastName;

	@CacheLookup
	@FindBy(xpath = "//input[@placeholder = 'Enter Email Address']")
	WebElement enterEmail;

	@CacheLookup
	@FindBy(xpath = "//input[@placeholder = 'Enter Phone Number']")
	WebElement enterPhone;

	@CacheLookup
	@FindBy(xpath = "//button[@class = 'dwebCommonstyles__ButtonBase-sc-112ty3f-10 GuestDetailsBlockstyles__CustomButton-sc-1rzm4ar-6 KETBj blGWwt']")
	WebElement proceedToPayment;

	@CacheLookup
	@FindBy(xpath = "//div[@class = 'col-md-12 col-sm-12 col-xs-12 ']//child::input[1]")
	WebElement enterCardNumber;

	@CacheLookup
	@FindBy(xpath = "//div[@class = 'col-md-5 col-sm-5 col-xs-12 pad0 cr_crd_name_p']//child::input[1]")
	WebElement enterNameOnCard;

	@CacheLookup
	@FindBy(xpath = "//div[@class = 'col-md-6 col-sm-6 col-xs-6 pad0 cr_crd_exp_p']//child::input[1]")
	WebElement enterExpiryDate;

	@CacheLookup
	@FindBy(xpath = "//div[@class = 'width100 fl posRel']//child::input[1]")
	WebElement enterCVV;

	@CacheLookup
	@FindBy(xpath = "//div[@class = 'col-md-8 col-sm-8 col-xs-8 marginT5']//child::button[1]")
	WebElement pay;



	public BookingDetails(WebDriver driver)
	{	
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}

	public void clickSelectRoom()
	{
		tabs = new ArrayList<String>(driver.getWindowHandles()); 
		driver.switchTo().window(tabs.get(1));

		driver.findElement(By.xpath("//button[@class='dwebCommonstyles__ButtonBase-sc-112ty3f-10 BookingWidgetstyles__ViewRoomOptionsButton-sc-1tsb1-10 KETBj iiLDmi']")).click();
		selectRoom.click();
	}

	public ArrayList<String> getDisplayedDetails()
	{

		ArrayList<String> details = new ArrayList<String>();
		details.add(verifyCheckIn.getText());
		details.add(verifyCheckOut.getText());
		details.add(verifyGuestNumber.getText());

		return details;

	}

	public void enterGuestDetails(String firstName, String lastName, String email, String phone)
	{

		Select gender = new Select(selectGender);
		gender.selectByValue("2");

		enterFirstName.sendKeys(firstName);

		enterLastName.sendKeys(lastName);

		enterEmail.sendKeys(email);

		enterPhone.sendKeys(phone);

		proceedToPayment.click();

	}

	public void enterCardDetails(String cardNumber, String nameOnCard, String expiryDate, String cvv)
	{

		System.out.println(driver.getTitle());

		enterCardNumber.clear();
		enterCardNumber.sendKeys(cardNumber);

		enterNameOnCard.clear();
		enterNameOnCard.sendKeys(nameOnCard);

		enterExpiryDate.clear();
		enterExpiryDate.sendKeys(expiryDate);

		enterCVV.clear();
		enterCVV.sendKeys(cvv);

		pay.click();


	}

}
