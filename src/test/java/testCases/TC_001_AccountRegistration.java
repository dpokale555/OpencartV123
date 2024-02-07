package testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TC_001_AccountRegistration.class);

	@Test(groups= {"regression","master"})
	public void test_account_registration() throws InterruptedException, IOException 
	
	{
		logger.info("Starting TC_001_AccountRegistration");
		try
		{
		driver.get(rb.getString("file_appURL"));  //fetched data from config proeprties file
		driver.manage().window().maximize();
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();

		AccountRegisterationPage regpage = new AccountRegisterationPage(driver);
		
		logger.info("Providing customer Name");
		regpage.setFirstName("Jhon");
		logger.info("Providing customer Lastname");
		regpage.setlastName("Canedy");
		logger.info("Providing customer email Id");
		regpage.setEmail(randomeString()+"@gmail.com");
		logger.info("Providing customer Pswd");
		regpage.setPassword("Test123");
		logger.info("Scrolling Down");
		scrollingToEndPage();
		Thread.sleep(3000);
		logger.info("Accepting Privacy policy");
		regpage.setPrivacyPolicy();
		logger.info("Clicking on continue");
		regpage.clickContinue();
		logger.info("Validation started");
		String confrmsg=regpage.getConfirmationMsg();
		if(confrmsg.equals("Your Account Has Been Created!"))
		//if (driver.getTitle().equals("Your Account Has Been Created!")) 
			{
			logger.info("Registration Testcase and Validation passed");
			Assert.assertTrue(true);
			}
		else
			{
			captureScreen(driver, "test_account_registration");
			logger.error("Registration Testcase and Validation Failed");
			Assert.assertTrue(false);
			}
		}
		catch (Exception e)
		{
			captureScreen(driver, "test_account_registration");
			e.printStackTrace();
			Assert.fail();
		}
	}
}
