package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelfileRead {
	
static String filePath = System.getProperty("user.dir")+"\\Input\\MakeMyTrip.xlsx";
	
	static Object[][] value;
	public static Object[][] ExcelRead(String sheetname) throws IOException
	{
	
		File F = new File(filePath);
		FileInputStream Fs = new FileInputStream(F);
		XSSFWorkbook wbk = new XSSFWorkbook(Fs);
		Sheet sheet = wbk.getSheet(sheetname);
		// get the totatl number of rows
		int totalRows = sheet.getPhysicalNumberOfRows();
		Row firstrow = sheet.getRow(1);
		int totalColumns = firstrow.getLastCellNum();
		value= new String[totalRows][totalColumns];
		for(int i=0;i<totalRows;i++)
		{
			Row row = sheet.getRow(i);
			int totalColumn = row.getLastCellNum();
			for(int j=0;j<totalColumn;j++)
			{
				Cell cell = row.getCell(j);
				value[i][j]=GetCellValue(cell);
			}
		}
		Fs.close();
		return value;
		
	}
	public static Object GetCellValue(Cell cellVal)
	{
		if(cellVal.getCellType().toString()=="STRING")
		{
			return cellVal.getStringCellValue();
		}
		else
		{
			DataFormatter data =  new DataFormatter();
			return data.formatCellValue(cellVal);
			//return cellVal.getNumericCellValue();
		}
	}
	
	
	public static void main(String[] args) throws IOException
	{
		ExcelfileRead E = new ExcelfileRead();
		E.ExcelRead("ValidData");
	}

}
