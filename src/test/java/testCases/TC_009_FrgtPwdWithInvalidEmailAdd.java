package testCases;

import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgetPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_009_FrgtPwdWithInvalidEmailAdd extends BaseClass {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TC_009_FrgtPwdWithInvalidEmailAdd.class);
	
	@Test
	public void FrgtPwdWithInvalidEmailAdd() throws InterruptedException, IOException
	{
	
		logger.info("Starting TC_009_FrgtPwdWithInvalidEmailAdd");
	try
	{
	driver.get(rb.getString("file_appURL"));
	driver.manage().window().maximize();
	
	HomePage hp=new HomePage(driver);
	LoginPage lp=new LoginPage(driver);
	ForgetPasswordPage fp=new ForgetPasswordPage(driver);
	
	hp.clickMyAccount();
	hp.clickLogin();
	lp.ClickFrgtPwd();
	fp.setEmailAddrs(randomeString()+"@rediff.com");
	fp.clickContinue();
	
	String act_msg=fp.getFailedCnfMesg();
	String exp_msg="Warning: The E-Mail Address was not found in our records!";
	
	if(act_msg.equals(exp_msg))
	{
		logger.info("Got error message of Invalid Email");
		Assert.assertTrue(true);
	}
	else
	{
		captureScreen(driver, "FrgtPwdWithInvalidEmailAdd");
		Assert.assertTrue(false);
	}
	}
	catch (Exception e)
	{
		captureScreen(driver, "FrgtPwdWithInvalidEmailAdd");
		e.printStackTrace();
		Assert.fail();
	}
	
	}

}
