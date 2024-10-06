package utils;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class ReadExcel {
	
	String currDir = System.getProperty("user.dir");
	FileInputStream fs;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	
	public void setupWorksheet(String sheetName)
	{
		//Path to the Excel File
		try {
			fs = new FileInputStream(currDir + "/projectData .xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Creating a workbook
		
		try {
			workbook = new XSSFWorkbook(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
		
	}
	
	public XSSFSheet getWorksheet()
	{
		setupWorksheet("LoginPassword");
		return this.sheet;
	}
	
	public int rowCount()
	{
		return sheet.getPhysicalNumberOfRows();
	}
	
	public int columnCount(int rowNum)
	{
		return sheet.getRow(rowNum).getPhysicalNumberOfCells();
	}
	
	public String readCell(int rowNum, int colNum)
	{
		return workbook.getSheetAt(0).getRow(rowNum).getCell(colNum).toString();
		
	}
	
	public void closeWorkbook()
	{
		try {
			workbook.close();
			fs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
