package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComponentsPage {
	
	WebDriver driver;

	
	public ComponentsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Apple Cinema 30\"']")
	WebElement prod1text;
	
	@FindBy(xpath="//a[normalize-space()='Samsung SyncMaster 941BW']")
	WebElement prod2text;

	@FindBy(xpath="/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/button[3]")
	WebElement Moniter1;
	
	@FindBy(xpath="/html[1]/body[1]/main[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/form[1]/div[1]/button[3]")
	WebElement Moniter2;
	
	@FindBy(xpath="//a[@id='compare-total']")
	WebElement prodcomprbtn;
	
	
	public void clickprod1()
	{
		Moniter1.click();
	}
	
	public void clickprod2()
	{
		Moniter2.click();
	}
	
	public void clickProdCmpr()
	{
		prodcomprbtn.click();
	}
	
	public String getTextprod1()
	{
		return prod1text.getText();
		
	}

	public String getTextprod2()
	{
		return prod2text.getText();
	}
	

	
}
