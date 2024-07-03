package TestCase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BrowserDriver.Browsers;
import ElementUtils.Elements;
import Pages.MakeMyTripSearchPage;
import Pages.SearchResultPage;
import Utils.ExcelfileRead;
import Utils.PropertyFileRead;

public class MakeMyTripSearchTestcase extends Browsers {
	
	String exepectedError ="NETWORK PROBLEM";
	String expectedSameCityError= "From & To airports cannot be the same";
	
	@BeforeSuite
	public void OpenTheBrowser() throws IOException
	{
		LaunchTheBrowser();
	}
	
	@BeforeTest
	public void EnterURL() throws IOException
	{

		String url = PropertyFileRead.GetDataFromPropFile().getProperty("url");
		driver.get(url);
		
	}
	
	
	@Test(priority=0, dataProvider="GetValidFlightSearchData",dataProviderClass=MakeMytripDataProvider.class)
	public void SearchWithValidValues(String from, String to, String date) throws IOException
	{
		test = extent.createTest("SearchWithValidValues Testcase");
		/*
		 * Enter the url
		 * Select From location
		 * 
		 * Select To location
		 * Select Date
		 * click on Search
		 * Then validate the search result
		 */
		MakeMyTripSearchPage M = new MakeMyTripSearchPage(driver);
		test.log(Status.INFO, "Select From location");
		M.ClickFromLocation();
		M.SelectValueFromList(from);
		test.log(Status.INFO, "Select To location");
		M.ClickToLocation();
		M.SelectValueFromList(to);
		test.log(Status.INFO, "Select Date");
		M.SelectDate(date);
		test.log(Status.INFO, "Click On Search");
		M.ClickOnSearchButton();
		test.log(Status.INFO, "Then validate the search result");
		SearchResultPage s = new SearchResultPage(driver);
		Assert.assertEquals(exepectedError, s.GetSearchResultText());
		Elements.ClickBackButton(driver);
		
	}
	
	
	@Test(priority=1, dataProvider="GetsameCityFlightSearchData",dataProviderClass=MakeMytripDataProvider.class)
	public void SearchWithinValidValues(String from, String to) throws IOException, InterruptedException
	{
		test = extent.createTest("SearchWithInValidValues Testcase");
		/*
		 * Enter the url
		 * Select From location
		 * Select To location as from location
		 * Then validate the same city error
		 */
		//test.log(Status.INFO, "Enter Url");
		MakeMyTripSearchPage M = new MakeMyTripSearchPage(driver);
		test.log(Status.INFO, "Select From location as: "+from );
		M.ClickFromLocation();
		M.SelectValueFromList(from);
		test.log(Status.INFO, "Select To location as same as from location: "+to);
		M.ClickToLocation();
		Thread.sleep(1000);
		M.SelectValueFromList(to);
		Assert.assertEquals(expectedSameCityError, M.GetSameCityError());
		test.log(Status.INFO, "Then validate the same city error message");
		//test.log(Status.PASS, "Testcase passed")
		
		
	}
	
	@AfterMethod
	public void WriteInReport(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.SUCCESS) {
			String filePath = Elements.GetScreenshot(driver,result.getName());
		     test.log(Status.INFO,test.addScreenCaptureFromPath(filePath).toString());
            test.log(Status.PASS,"Test Method named as : "+ result.getName()+" is passed");

        }else if(result.getStatus()==ITestResult.FAILURE) {
            test.log(Status.PASS,"Test Method named as : "+ result.getName()+" is FAILED");
            String filePath = Elements.GetScreenshot(driver,result.getName());
            test.log(Status.INFO,test.addScreenCaptureFromPath(filePath).toString());
            test.log(Status.FAIL,"Test failure : "+ result.getThrowable());
        }
        else if(result.getStatus()==ITestResult.SKIP) {
            test.log(Status.PASS,"Test Method named as : "+ result.getName()+" is skipped");
        }
	}
	
	
	
	
	@AfterSuite
	public void TearDown()
	{
		CloseTheBrowser();
	}
	
	

}
