package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWhishlistPage {
	
WebDriver driver;

	public MyWhishlistPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(xpath="//a[normalize-space()='HTC Touch HD']")
    WebElement item1text;
    
    @FindBy(xpath="//a[normalize-space()='iPhone']")
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
