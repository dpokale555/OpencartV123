package testCases;

import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyWhishlistPage;
import pageObjects.PhonesAndPDAsPage;
import testBase.BaseClass;

public class TC_007_AddInWishlist extends BaseClass {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TC_007_AddInWishlist.class);
	
	@Test
	public void AddInWishlist() throws InterruptedException, IOException {
		
		logger.info("Starting TC_007_AddInWishlist");
		try {
		driver.get(rb.getString("file_appURL"));
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		PhonesAndPDAsPage pp=new PhonesAndPDAsPage(driver);
		MyWhishlistPage wp=new MyWhishlistPage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();		
		lp.setLgnemail(rb.getString("file_email"));
		lp.setLgnPassword(rb.getString("file_password"));
		lp.clicKLogin();
		Thread.sleep(3000);
		hp.ClickProductCategoryPhnPDA();
		scrollingToEndPage();
		Thread.sleep(2000);
		pp.clickPhone1WishBtn();
		Thread.sleep(2000);
		pp.clickPhone2WishBtn();
		scrollingToStartPage();
		Thread.sleep(5000);
		hp.ClickWishlistbtn();
		
		String act_prod1=pp.getTextprod1();
		String act_prod2=pp.getTextprod2();
		String exp_prod1=wp.getTextItem1();
		String exp_prod2=wp.getTextItem2();
		
		if(act_prod1.equals(exp_prod1) && (act_prod2.equals(exp_prod2)))
		{
			logger.info("Both items added in wishlist succefully");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "AddInWishlist");
			Assert.assertTrue(false);
		}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
		
	}

}
