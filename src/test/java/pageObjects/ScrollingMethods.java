package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class ScrollingMethods {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PhonesAndPDAsPage.class);
WebDriver driver;

PhonesAndPDAsPage pap=new PhonesAndPDAsPage(driver);
HomePage hp=new HomePage(driver);

public ScrollingMethods(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

//product page: PhonesAndPDAsPage products: 'HTC Touch HD'
public void Scrollingprod1CartButton()
{
	logger.info("Scrolling Scrollingprod1CartButton1");
	JavascriptExecutor js=(JavascriptExecutor)driver;
	logger.info("Scrolling Scrollingprod1CartButton2");
	js.executeScript("arguments[0].scrollIntoView();",pap.prod1CartButton);
	logger.info("Scrolled till the element - Scrollingprod1CartButton");
}


}
