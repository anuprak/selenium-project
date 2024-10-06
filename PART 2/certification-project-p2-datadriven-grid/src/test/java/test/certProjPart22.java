package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.Login;
import pom.Search;

import org.testng.annotations.Test;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class certProjPart22 extends Base 
{	

	@Parameters({"searchTermNike"})
	@Test(priority = 1,groups = {"Grid"})
	public void searchNike(String searchTerm) 
	{
		Search search = new Search(driver);
		search.firstSearchItem(searchTerm);
	}
	@Parameters({"searchTermSamsung"})
	@Test(priority = 2,groups = {"Grid"})

	public void searchFastrack(String searchTerm) 
	{
		Search search = new Search(driver);
		search.subsequentSearchItems(searchTerm);
	}
	@Parameters({"searchTermApple"})
	@Test(priority = 3,groups = {"Grid"})

	public void searchApplePhone(String searchTerm) 
	{
		Search search = new Search(driver);
		search.subsequentSearchItems(searchTerm);
	}
	
}
