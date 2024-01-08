package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa-solid fa-user']")
	WebElement lnkMyaccount;
	
	@FindBy(linkText="Register")
	WebElement lnkRegister;
	
	@FindBy(linkText="Login")
	WebElement lnklogin;
	
	public void clickMyAccount()
	{
	lnkMyaccount.click();
	}

	public void clickRegister()
	{
	lnkRegister.click();
	}

	public void clickLogin()
	{
	lnklogin.click();
	}

	@FindBy(name="search")
	WebElement searchBox;
	
	public void searchBox(String serachTxt)
	{
		searchBox.sendKeys(serachTxt);
	}
	
	@FindBy(xpath="//button[@class='btn btn-light btn-lg']")
	WebElement searchBtn;
	
	public void clickSrchBtn()
	{
		searchBtn.click();
	}
	
	@FindBy(xpath="//div[@class='description']//h4")
	WebElement msgFoundItem;
	
	public String getmsgFoundItem()
	{
		try 
		{
			return (msgFoundItem.getText());
		}
		catch (Exception e)
		{
			return (e.getMessage());
		}
		
	}
	
	public void AlrtSwitch() {
	Alert confmMsg=driver.switchTo().alert();
	String cnfMsg=confmMsg.getText();
	System.out.println(cnfMsg);

	}
	
	@FindBy(xpath="//a[normalize-space()='Desktops']")
	WebElement Dxtp;
	
	@FindBy(xpath="//a[normalize-space()='Laptops & Notebooks']")
	WebElement lptNote;
	
	@FindBy(xpath="//a[normalize-space()='Components']")
	WebElement cmpnt;
	
	@FindBy(xpath="//a[normalize-space()='Monitors (2)']")
	WebElement mntr;
	
	@FindBy(xpath="//a[normalize-space()='Tablets']")
	WebElement tblt;
	
	@FindBy(xpath="//a[normalize-space()='Software']")
	WebElement sftwr;
	
	@FindBy(xpath="//a[normalize-space()='Phones & PDAs']")
	WebElement phnPDA;
	
	public void ClickProductCategorymntr() {
		Actions act=new Actions(driver);
		act.moveToElement(Dxtp).moveToElement(lptNote).moveToElement(cmpnt).moveToElement(mntr).click().build().perform();
	}
	
	public void ClickProductCategoryPhnPDA() {
		Actions act=new Actions(driver);
		act.moveToElement(Dxtp).moveToElement(lptNote).moveToElement(cmpnt).moveToElement(tblt).moveToElement(sftwr).moveToElement(phnPDA).click().build().perform();
	}
	
	@FindBy(xpath="//span[normalize-space()='Wish List (2)']")
	WebElement WishListBtn;
	
	public void ClickWishlistbtn() {
		WishListBtn.click();
	}
	
}
