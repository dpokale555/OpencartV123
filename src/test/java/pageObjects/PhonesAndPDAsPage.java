package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class PhonesAndPDAsPage {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PhonesAndPDAsPage.class);
WebDriver driver;
	
	
	
	public PhonesAndPDAsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='product-list']//div[1]//div[1]//div[2]//form[1]//div[1]//button[2]//i[1]")
	WebElement Phone1WishBtn;
	
	
	@FindBy(xpath="//div[@id='product-list']//div[2]//div[1]//div[2]//form[1]//div[1]//button[2]//i[1]")
	WebElement Phone2WishBtn;
	
	public void clickPhone1WishBtn()
	{
		Phone1WishBtn.click();
	}
	
	public void clickPhone2WishBtn()
	{
		Phone2WishBtn.click();
	}
	
	
	@FindBy(xpath="//a[normalize-space()='HTC Touch HD']")
	WebElement prod1text;
	
	@FindBy(xpath="//img[@title='HTC Touch HD']")
	WebElement prod1img;
	
	@FindBy(xpath="//a[normalize-space()='iPhone']")
	WebElement prod2text;
	
	public String getTextprod1()
	{
		return prod1text.getText();
	}
	
	public String getTextprod2()
	{
		return prod2text.getText();
	}
	
	public void Scrollingprod1prod1img()
	{
		logger.info("Scrolling");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",prod1img);
		logger.info("Scrolled till the element");
	}
	
	public void ClickProd1prod1img()
	{
		prod1img.click();
	}

	
	@FindBy(xpath="//div[@id='content']//div[1]//div[1]//div[2]//form[1]//div[1]//button[1]")
	WebElement prod1CartButton;
	

	
	public void Clickprod1CartButton() throws InterruptedException
	{
		logger.info("inside the Clickprod1CartButton");
		Thread.sleep(3000);
		prod1CartButton.click();
		logger.info("done Clickprod1CartButton");
	}
	

}
