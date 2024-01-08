package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductComparisonPage {
	
WebDriver driver;

	
	public ProductComparisonPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//strong[normalize-space()='Apple Cinema 30\"']")
	WebElement item1text;
	
	@FindBy(xpath="//strong[normalize-space()='Samsung SyncMaster 941BW']")
	WebElement item2text;
	
	public String getTextItem1()
	{
		return item1text.getText();
		
	}

	public String getTextItem2()
	{
		return item2text.getText();
	}

}
