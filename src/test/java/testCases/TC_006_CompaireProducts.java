package testCases;

import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ComponentsPage;
import pageObjects.HomePage;
import pageObjects.ProductComparisonPage;
import testBase.BaseClass;

public class TC_006_CompaireProducts extends BaseClass {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TC_006_CompaireProducts.class);
	

	@Test
	public void CompaireProducts() throws InterruptedException {
		
		logger.info("Starting TC_006_CompaireProducts");
		try {
			
			driver.get(rb.getString("file_appURL"));
			driver.manage().window().maximize();

			HomePage hp = new HomePage(driver);
			hp.ClickProductCategorymntr();
			scrollingToEndPage();
			Thread.sleep(2000);
			ComponentsPage cp = new ComponentsPage(driver);
			cp.clickprod1();
			Thread.sleep(2000);
			cp.clickprod2();
			scrollingToStartPage();
			Thread.sleep(3000);
			cp.clickProdCmpr();

			String actl_prod1=cp.getTextprod1();
			String actl_prod2=cp.getTextprod2();
			
			ProductComparisonPage pc=new ProductComparisonPage(driver);
			
			String exp_prod1=pc.getTextItem1();
			String exp_prod2=pc.getTextItem2();
			
			if(actl_prod1.equals(exp_prod1) && actl_prod2.equals(exp_prod2))
			{
				logger.info("Itmes addedd in list");
				Assert.assertTrue(true);
			}
			else
			{
				captureScreen(driver, "CompaireProducts");
				Assert.assertTrue(false);
			}			

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

}
