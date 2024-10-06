package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.Login;
import pom.Search;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class certProjPart23 extends Base 
{	

	@Parameters({"searchTermHeadphone"})
	@Test(priority = 1,groups = {"Grid"})
	public void searchAndCountHeadphone(String searchTerm) 
	{
		Search search = new Search(driver);
		try {
			search.searchAndCountWithRobot(searchTerm);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
