package testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_003_login_DataDriven_Testing extends BaseClass
{
	@Test(dataProvider="LoginTest", groups= {"ddt"})
	public void login_DataDriven(String email, String pwd, String exp)
	{
		System.out.println(email + pwd + exp);
		try
		{
		logger.info("open URL");
		driver.get(rb.getString("file_appURL"));
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		logger.info("click on myAccount");
		hp.clickMyAccount();
		logger.info("click on Login");
		hp.clickLogin();
		
		logger.info("entering user details");
		LoginPage lp=new LoginPage(driver);
		logger.info("entering user email");
		lp.setLgnemail(email);
		logger.info("entering user password");
		lp.setLgnPassword(pwd);
		logger.info("Clicked on login");
		lp.clicKLogin();
		
		boolean targetpage=lp.isMyAccountExist();
		
		if(exp.equals("Valid"))
		{
			if(targetpage==true)
			{
				MyAccountPage myaccpage=new MyAccountPage(driver);
				myaccpage.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
				MyAccountPage myaccpage=new MyAccountPage(driver);
				myaccpage.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
			}
		catch (Exception e)
			{
			logger.fatal("login failed");
			Assert.assertTrue(false);
	}
		
		
}
	
	
	
	
	 @DataProvider(name="LoginTest")
	 public String [][] getData() throws IOException
	 {
		 String path=".\\testData\\test_data.xlsx";
		 XLUtility xlutil=new XLUtility(path);
		 logger.info("file path reading");
		int totalrows=xlutil.getRowCount("Data1");
		logger.info("sheet reading");
		
		
		int totalcols=xlutil.getCellCount("Data1", 1);
		logger.info("sheet1 cell data captured");
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)	   
		{
			logger.info("row captured");
			for(int j=0;j<totalcols;j++)       
			{
				logger.info("celled captured");
				logindata[i-1][j]=xlutil.getCellData("Data1", i, j);    
			}
		}
		return logindata;
	 }
}
