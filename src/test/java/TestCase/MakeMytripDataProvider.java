package TestCase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utils.ExcelfileRead;

public class MakeMytripDataProvider {
	
	@DataProvider
	public Object[][] GetValidFlightSearchData() throws IOException
	{
		return ExcelfileRead.ExcelRead("ValidData");
	}
	
	@DataProvider
	public Object[][] GetsameCityFlightSearchData() throws IOException
	{
		return ExcelfileRead.ExcelRead("invalidData");
	}

}
