package pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Search {

	static WebDriver driver;

	@CacheLookup
	@FindBy(xpath = "//input[@placeholder = 'What is on your mind today?']")
	WebElement searchBox;

	@CacheLookup
	@FindBy(xpath = "//a[text() = 'Search']")
	WebElement searchButton;

	//"//a[@class = 'srch_action btn orange']"
	@CacheLookup
	@FindBy(xpath = "//div[@class = 'row']/div//child::h2[1]")
	WebElement firstListedItem;

	@CacheLookup
	@FindBy(xpath = "//span[text() =  'Please enter valid email id or mobile number.']")
	WebElement errorMessage;

	@CacheLookup
	@FindBy(xpath = "//i[@id = 'instdcnt']")
	WebElement count;

	@CacheLookup
	@FindBy(xpath = "//button[@class = 'moe-chrome-style-notification-btn moe-btn-close moe-block-class']")
	WebElement dontAllowOffers;


	public Search(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void firstSearchItem(String searchTerm)
	{

		searchBox.clear();
		searchBox.sendKeys(searchTerm);

		dontAllowOffers.click();
		searchButton.click();

		Reporter.log(firstListedItem.getText());
		Reporter.log(driver.findElement(By.xpath("//span[@class = 'p_price'][1]")).getText());
	}

	public void subsequentSearchItems(String searchTerm)
	{

		searchBox.clear();
		searchBox.sendKeys(searchTerm);
		searchButton.click();

		Reporter.log(firstListedItem.getText());
		Reporter.log(driver.findElement(By.xpath("//span[@class = 'p_price'][1]")).getText());
	}

	public void searchAndCountWithRobot(String searchTerm) throws AWTException
	{

		Robot robot = new Robot();
		WebDriverWait wait = new WebDriverWait(driver,10);


		searchBox.clear();
		searchBox.sendKeys(searchTerm);
		dontAllowOffers.click();
		

//		***********UNABLE TO RUN THIS COMMENTED PART OF ROBOT CLASS IMPLEMENTATION ON MAC BIG SUR************************

//		Point location = wait.until(ExpectedConditions.visibilityOf(searchButton)).getLocation();
//
//		int x = searchButton.getLocation().getX();
//		int y = searchButton.getLocation().getY();
//
//		System.out.println("x and y coordinates: " + x + "\n" + y);
//		robot.mouseMove(x, y);
//		robot.delay(1000);
//		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

		
//		******************************************************************************************************************
		
		searchButton.click();
		
		String resultCount = wait.until(ExpectedConditions.visibilityOf(count)).getText();

		Reporter.log("Total search results for search term 'headphone' is: " + resultCount);

	}
}
