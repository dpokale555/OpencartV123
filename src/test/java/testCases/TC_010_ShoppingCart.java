package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ComponentsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.ShopingCartPage;
import testBase.BaseClass;

public class TC_010_ShoppingCart extends BaseClass {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TC_010_ShoppingCart.class);
	
	@Test
	public void ShoppingCart() throws IOException
	{
		try
		{
		logger.info("Starting TC_010_ShoppingCart");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("file_appURL"));
		driver.manage().window().maximize();
		 
		
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		ComponentsPage cp=new ComponentsPage(driver);
		ProductsPage pp=new ProductsPage(driver);
		ShopingCartPage sp=new ShopingCartPage(driver);
		
		logger.info("Starting Login");
		hp.clickMyAccount();
		hp.clickLogin();
		lp.setLgnemail(rb.getString("file_email"));
		lp.setLgnPassword(rb.getString("file_password"));
		lp.clicKLogin();
		Thread.sleep(3000);
		hp.ClickProductCategorymntr();
		Thread.sleep(3000);
	//	scrollingToEndPage();
		cp.clickMoniter1Img();
		pp.ClickMoniter1RadioBtn();
		pp.ClickMoniter1CheckBox3();
		pp.SetMoniter1TextBox1("Apple Monitor");
		pp.DropDwnMoniter1();
		pp.SetMoniter1TextBox2("Apple Products");
		logger.info("Text2");
		pp.setMoniter1FileUploadBtn();
		logger.info("uploaded succefully");
		Thread.sleep(5000);
		pp.setMoniter1DatePicker();
		pp.setMoniter1TimePicker();
		pp.setMoniter1DateTimePicker("2012-01-19 18:17");
		pp.setMoniter1QtyBox("1");
		pp.ScrollingMoniter1AddCartBtn();
		Thread.sleep(3000);
		pp.clickMoniter1AddCartBtn();
		logger.info("Added in cart succefully");
		scrollingToStartPage();
		logger.info("Scrolling Up");
		Thread.sleep(3000);
		hp.ClickShopingCartBtn();
		logger.info("Click on Shopping cart");
	
		System.out.println(sp.getTextMoniter1txt());
		String act_text=sp.getTextMoniter1txt();
		String exp_text="Apple Cinema 30";
		if(act_text.equals(exp_text))
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}
		else
		{
			captureScreen(driver, "ShoppingCart");
			Assert.assertTrue(false);
			logger.info("Test Case Failed");
		}
		
		}
		catch (Exception e)
		{
			captureScreen(driver, "ShoppingCart");
			e.printStackTrace();
			Assert.fail();
			logger.info("Got Exception");
		}
	}

}
