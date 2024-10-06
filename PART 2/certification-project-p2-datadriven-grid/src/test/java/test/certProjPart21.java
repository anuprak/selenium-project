package test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pom.Login;

import org.testng.annotations.Test;
import java.util.ArrayList;

import org.testng.annotations.Test;

public class certProjPart21 extends Base {
	
	@Test(priority = 1,groups = {"Grid"})
	public void loginCombinations() 
	{
		Login login = new Login(driver);
		int rowCount = re.rowCount();
		int columnCount;
		ArrayList<String> rowData = new ArrayList<String>();
		String userName,password;
		login.clickSignIn();
		
		for(int row = 1;row < rowCount;row++)
		{
			columnCount = re.columnCount(row);
			for(int column = 0;column<columnCount;column++)
			{
				rowData.add(re.readCell(row, column));

			}
			if(!(rowData.isEmpty()))
			{
				userName = rowData.get(1);
				password = rowData.get(2);
				System.out.println("USENAME: " + userName + "PASSWORD: " + password);
				login.loginShopclues(userName, password);
				rowData.clear();
			}
		}
	}
}
