package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductsPage;
import pageObjects.SerachPage;
import testBase.BaseClass;

public class TC_005_AddItemInCard extends BaseClass {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TC_007_AddInWishlist.class);
	
	@Test
	public void AddItemInCard() throws InterruptedException, IOException
	{
		logger.info("Starting TC_005_AddItemInCard");
		try
		{
		driver.get(rb.getString("file_appURL"));
		driver.manage().window().maximize();
		
		
		HomePage hp=new HomePage(driver);
		ProductsPage pd=new ProductsPage(driver);
		SerachPage sp=new SerachPage(driver);
		
		hp.searchBox("Canon EOS 5D");
		hp.clickSrchBtn();
		sp.ClickSrchItem();
		pd.SelectDrpdown();
		pd.clearQty();
		String randomQty=String.valueOf(randomNumber());
		Syso
		pd.SelectQty(randomQty);
		pd.ScrollingPage();
		pd.ClickAddBtn();
		Thread.sleep(2000);
		scrollingToStartPage();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	      
	    By notificationLocator= By.xpath("//div[@class='alert alert-success alert-dismissible']");
	 
	    WebElement notification=wait.until(ExpectedConditions.visibilityOfElementLocated(notificationLocator)); 
	    
		String act_NotificationText=notification.getText();
	    String expt_NotificationText="Success: You have added Canon EOS 5D to your shopping cart!";	 
	    
	    
	    if(act_NotificationText.equals(expt_NotificationText))
	    {
	    	logger.info("Items added in cart succefully");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	captureScreen(driver, "AddItemInCard");
			Assert.assertTrue(false);
	    }
	  }
		catch (Exception e)
		{
			captureScreen(driver, "AddItemInCard");
			e.printStackTrace();
			Assert.fail();
		}  
	
	}
	

}
