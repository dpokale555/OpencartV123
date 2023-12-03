package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass

{
	@Test (groups= {"sanity","master"})
	public void test_user_login()
	{
		logger.info("Starting TC_002_Login");
		try 
		{
		driver.get(rb.getString("file_appURL"));
		driver.manage().window().maximize();
		logger.info("Homepage displayed");
		
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		lp.setLgnemail(rb.getString("file_email"));       //fetched data from config file
		lp.setLgnPassword(rb.getString("file_password")); //fetched data from config file
		lp.clicKLogin();
		
		boolean targetpage=lp.isMyAccountExist();
		
		if(targetpage)
		{
			logger.info("Loggin is Success");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Loggin is Failed");
			captureScreen(driver, "test_user_login");
			Assert.assertTrue(false);
		}
	}
	catch (Exception e)
		{
			Assert.fail();
		}
	}
}
	

