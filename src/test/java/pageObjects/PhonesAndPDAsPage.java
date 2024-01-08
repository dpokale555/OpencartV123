package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhonesAndPDAsPage {
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
	
	
	
	

}
