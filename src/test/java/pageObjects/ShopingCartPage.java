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
	
	public ShopingCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//td[@class='text-start text-wrap']//a[contains(text(),'Apple Cinema 30\"')]")
	WebElement Moniter1txt;
	
	public String getTextMoniter1txt()
	{
		logger.info("inside the get text");
		return Moniter1txt.getText();
	}
}
