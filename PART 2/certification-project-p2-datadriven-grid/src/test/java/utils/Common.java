package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

public class Common 
{
	static WebDriver driver;
	String pageURL = "https://www.shopclues.com/";

	public void setUp(String grid,String browser,String url)
	{
		if(Boolean.parseBoolean(grid))
		{
			gridSetUp(browser,url);	
		}
		else
		{
			setupBrowser(browser);
		}

		driver.manage().window().maximize();

		if(pageURL!="")
			driver.get(pageURL);
		else
			driver.get("about:blank");

	}

	public void gridSetUp(String browserType,String url)
	{
		DesiredCapabilities cap = null;

		if(browserType.equals("firefox"))
		{
			cap=DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
		}
		else if(browserType.equals("chrome"))
		{
			cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
		}
		else
		{
			System.out.println("Valid browser not provided, hence quitting the automation run");
			System.exit(0);
		}

		//Any capabilities added here should also be included while configuring the node at the terminal.

		try {
			driver = new RemoteWebDriver(new URL(url),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void setupBrowser(String browser) 
	{
		String currDir = System.getProperty("user.dir");

		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", currDir + "/drivers/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", currDir + "/drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Valid browser not provided, hence quitting the automation run");
			System.exit(0);
		}

	}

	public WebDriver getDriver()
	{
		return this.driver;
	}

	public void closeBrowser()
	{
		driver.close();
	}

	public void quitBrowser()
	{
		driver.quit();
	}

}
