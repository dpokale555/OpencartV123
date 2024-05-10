package testCases;

import java.io.IOException;
import java.time.Duration;

import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ComponentsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PhonesAndPDAsPage;
import pageObjects.ProductsPage;
import pageObjects.ScrollingMethods;
import pageObjects.ShopingCartPage;
import pageObjects.WaitingMethod;
import testBase.BaseClass;

public class TC_011_Checkout extends BaseClass {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TC_011_Checkout.class);
	
	@Test
	public void Checkout() throws InterruptedException, IOException
	{
		
		try
		{
		driver.get(rb.getString("file_appURL"));
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		ComponentsPage cp=new ComponentsPage(driver);
		ProductsPage pp=new ProductsPage(driver);
		ShopingCartPage sp=new ShopingCartPage(driver);
		PhonesAndPDAsPage pap=new PhonesAndPDAsPage(driver);
		ScrollingMethods sm=new ScrollingMethods(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		lp.setLgnemail(rb.getString("file_email"));
		lp.setLgnPassword(rb.getString("file_password"));
		lp.clicKLogin();
		Thread.sleep(3000);
		hp.ClickProductCategoryPhnPDA();
		Thread.sleep(2000);
		scrollingToEndPage();
		pap.Clickprod1CartButton();
		scrollingToStartPage();
		Thread.sleep(5000);
		hp.ClickShopingCartBtn();
		Thread.sleep(3000);
		scrollingToEndPage();
		Thread.sleep(3000);
		sp.clickEstShipTxesBar();
		sp.DrpDownEstShipTxesBarCountry();
		logger.info("clicked on Region / State");
		sp.DrpDownEstShipTxesBarState();
		logger.info("State selected");
		sp.SetEstShipTxesBarPostCode("444701");
		sp.clickEstShipTxesBarGetQuotes();
		sp.Enable_EstShip_ShipingMethod_RadioBtn();
		logger.info("radio selected");
		
		}
		catch (Exception e)
		{
			captureScreen(driver, "Checkout");
			e.printStackTrace();
			Assert.fail();
			logger.info("Got Exception");
		}		
	}

}
