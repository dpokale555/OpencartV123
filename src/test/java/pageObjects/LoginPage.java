package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	WebElement lognname;
	
	@FindBy(name="password")
	WebElement lognpassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnlogin;
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	public void setLgnemail(String lgname)
	{
		lognname.sendKeys(lgname);
	}
	
	public void setLgnPassword(String lgnpwd)
	{
		lognpassword.sendKeys(lgnpwd);
	}
	
	public void clicKLogin()
	{
		btnlogin.click();
	}

	public boolean isMyAccountExist()
	{
		try
		{
		return(msgHeading.isDisplayed());
		}
		catch (Exception e)
		{
			return(false);
		}
	}

}
