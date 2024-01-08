package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
	WebDriver driver;
	
	public ProductsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@id='input-option-226']")
	WebElement drpProdOptn;
	
	public void SelectDrpdown()
	{
		Select drpOptn=new Select(drpProdOptn);
		drpOptn.selectByVisibleText("Blue");
	}
	
	@FindBy(name="quantity")
	WebElement ProdQty;
	
	public void SelectQty(String Qty)
	{
		ProdQty.sendKeys(Qty);
	}

	@FindBy(xpath="//button[@id='button-cart']")
	WebElement AddCartBtn;
	
	public void ClickAddBtn()
	{
		AddCartBtn.click();
	}
	
	public void ScrollingPage() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",AddCartBtn);
		Thread.sleep(3000);
		System.out.println("Waiting");
	}
	
	
	
}
