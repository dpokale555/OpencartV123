package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.LoggerFactory;

public class ShopingCartPage {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ShopingCartPage.class);
	WebDriver driver;
	
	PhonesAndPDAsPage pap=new PhonesAndPDAsPage(driver);
	
	public ShopingCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//td[@class='text-start text-wrap']//a[contains(text(),'Apple Cinema 30\"')]")
	WebElement Moniter1txt;
	
	@FindBy(xpath="//button[normalize-space()='Estimate Shipping & Taxes']")
	WebElement EstShipTxesBar;
	
	@FindBy(xpath="//select[@id='input-country']")
	WebElement EstShipTxesBarCountry;
	
	@FindBy(xpath="//select[@id='input-zone']")
	WebElement EstShipTxesBarState;
	
	
	public String getTextMoniter1txt()
	{
		logger.info("inside the get text");
		return Moniter1txt.getText();
	}
	
	public void clickEstShipTxesBar()
	{
		EstShipTxesBar.click();
	}
	
	public void DrpDownEstShipTxesBarCountry() throws InterruptedException
	{
		Select cntry=new Select(EstShipTxesBarCountry);
		Thread.sleep(3000);
		cntry.selectByVisibleText("India");
		logger.info("Country selected");
		Thread.sleep(3000);
		logger.info("waiting aa");
	}
	
	public void DrpDownEstShipTxesBarState()
	{
		Select cntry=new Select(EstShipTxesBarState);
		cntry.selectByVisibleText("Maharashtra");
	}
	

}
