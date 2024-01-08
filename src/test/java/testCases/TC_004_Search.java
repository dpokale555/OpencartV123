package testCases;

import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_004_Search extends BaseClass
{
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TC_004_Search.class);
	
	@Test
	public void search_fetaure() throws IOException
	{
		logger.info("Starting TC_004_Search");
		try {
		driver.get(rb.getString("file_appURL"));
		driver.manage().window().maximize();

		
		HomePage hp=new HomePage(driver);
		hp.searchBox("Canon EOS 5D");
		hp.clickSrchBtn();
		
		String msgItemFound=hp.getmsgFoundItem();
		if(msgItemFound.equals("Canon EOS 5D"))
		{
			logger.info("Item Found");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "search_fetaure");
			Assert.assertTrue(false);
		}
	}
		catch(Exception e)
		{
			captureScreen(driver, "search_fetaure");
			Assert.fail();
		}
	}
		
		
	
	

}
