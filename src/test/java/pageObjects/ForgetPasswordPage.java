package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordPage {
	
WebDriver driver;
	
	public ForgetPasswordPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement EmailAddress;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement ContinueBtn;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement FailedCnfMsg;
		
	
	public void setEmailAddrs(String EmailAdd)
	{
		EmailAddress.sendKeys(EmailAdd);
	}
	
	public void clickContinue()
	{
		ContinueBtn.click();
	}
	
	public String getFailedCnfMesg()
	{
		return FailedCnfMsg.getText();
	}
	

}
