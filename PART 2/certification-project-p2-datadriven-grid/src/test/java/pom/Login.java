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

public class Login {

	static WebDriver driver;

	@CacheLookup
	@FindBy(xpath = "//input[@id = 'main_user_login']")
	WebElement email;

	@CacheLookup
	@FindBy(xpath = "//input[@class = 'label_jump password_txt' and @tabindex = '2']")
	WebElement pass;
	
	@CacheLookup
	@FindBy(id = "sign-in")
	WebElement signIn;
	
	@CacheLookup
	@FindBy(xpath = "//button[@class = 'moe-chrome-style-notification-btn moe-btn-close moe-block-class']")
	WebElement dontAllowOffers;
	
	@CacheLookup
	@FindBy(xpath = "//span[text() =  'Please enter valid email id or mobile number.']")
	WebElement errorMessage;
	
	public Login(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickSignIn()
	{
		
		WebDriverWait wait = new WebDriverWait(driver,15);
		
//		if(dontAllowOffers.isDisplayed())
//			dontAllowOffers.click();
//		if (driver.findElement(By.cssSelector("span#btnCloseInfo")).isDisplayed())
//			driver.findElement(By.cssSelector("span#btnCloseInfo")).click();
		
		wait.until(ExpectedConditions.visibilityOf(signIn)).click();
		
	}

	public void loginShopclues(String username,String password)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(email)).clear();
		wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(username);

		pass.clear();
		pass.sendKeys(password);
		
		Reporter.log("Username: "+ username);
		Reporter.log("Password: " + password);
	//	Reporter.log("ERROR MESSAGE: " + errorMessage.getText());
	}
}
