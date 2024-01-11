package testCases;

import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ForgetPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_008_ForgetPassword extends BaseClass {

private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TC_008_ForgetPassword.class);
	
	@Test
	public void ForgetPassword() throws InterruptedException, IOException {
		
		logger.info("Starting TC_008_ForgetPassword");
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
		fp.setEmailAddrs(rb.getString("file_email1"));
		fp.clickContinue();
		
		String act_CnfmMsg=lp.getFrgtPswdCnfrmMsg();
		String exp_CnfmMsg="Success: Your password has been successfully updated.";
		
		if (act_CnfmMsg.equals(exp_CnfmMsg))
		{
			logger.info("Password Updated Succefully");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "ForgetPassword");
			Assert.assertTrue(false);
		}
		}
		catch (Exception e)
		{
			captureScreen(driver, "ForgetPassword");
			e.printStackTrace();
			Assert.fail();
		}	
		
	}	

}
