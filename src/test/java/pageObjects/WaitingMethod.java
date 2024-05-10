package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

public class WaitingMethod {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PhonesAndPDAsPage.class);
WebDriver driver;

HomePage hp=new HomePage(driver);

public WaitingMethod(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

//product page: PhonesAndPDAsPage products: 'HTC Touch HD'
public void wait_phnPDA() {
	try
	{
	WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement Wait_Elem_phnPDA=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Phones & PDAs']")));
	if (Wait_Elem_phnPDA.isDisplayed())
	{
		logger.info("inside if block");
		hp.ClickProductCategoryPhnPDA();
		logger.info("if block done");
	}
	}
	catch (Exception e)
	{
		System.out.println("Element Not Found");
	}
}




}
