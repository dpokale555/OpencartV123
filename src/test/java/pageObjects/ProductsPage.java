package pageObjects;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.LoggerFactory;

import testCases.TC_010_ShoppingCart;

public class ProductsPage {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProductsPage.class);
	WebDriver driver;
	
	public ProductsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//product page : 
	@FindBy(xpath="//select[@id='input-option-226']")
	WebElement drpProdOptn;
	
	public void SelectDrpdown()
	{
		Select drpOptn=new Select(drpProdOptn);
		drpOptn.selectByVisibleText("Blue");
	}
	
	@FindBy(name="quantity")
	WebElement ProdQty;
	
	public void clearQty()
	{
		ProdQty.clear();
	}
	
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
	
	//product page : Apple Cinema 30"
	@FindBy(xpath="//input[@id='input-option-value-6']")
	WebElement Moniter1RadioBtnMedum;
	
	@FindBy(xpath="//input[@id='input-option-value-10']")
	WebElement Moniter1CheckBox3;
	
	@FindBy(xpath="//input[@id='input-option-208']")
	WebElement Moniter1TextBox1;
	
	@FindBy(xpath="//select[@id='input-option-217']")
	WebElement Moniter1DrpDown;
	
	@FindBy(xpath="//textarea[@id='input-option-209']")
	WebElement Moniter1TextBox2;
	
	@FindBy(xpath="//button[@id='button-upload-222']")
	WebElement Moniter1FileUploadBtn;
	
	@FindBy(xpath="//input[@id='input-option-219']")
	WebElement Moniter1DatePicker;
	
	@FindBy(xpath="//input[@id='input-option-221']")
	WebElement Moniter1TimePicker;
	
	@FindBy(xpath="//input[@id='input-option-220']")
	WebElement Moniter1DateTimePicker;
	
	@FindBy(xpath="//div[9]//div[1]//div[1]//i[1]")
	WebElement Moniter1DateTimePickerClosed;
	
	
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement Moniter1QtyBox;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement Moniter1AddCartBtn;
	
	public void ClickMoniter1RadioBtn()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",Moniter1RadioBtnMedum);
	}
	
	public void ClickMoniter1CheckBox3()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",Moniter1CheckBox3);
	}
	
	public void SetMoniter1TextBox1(String text)
	{
		Moniter1TextBox1.sendKeys(text);
	}
	
	public void DropDwnMoniter1()
	{
		Select dropOptn=new Select(Moniter1DrpDown);
		dropOptn.selectByIndex(2);
	}
	
	public void SetMoniter1TextBox2(String text)
	{
		Moniter1TextBox2.sendKeys(text);
	}
	
	public void ScrollingMoniter1FileUploadBtn()
	{
		logger.info("Scrolling");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",Moniter1FileUploadBtn);
		logger.info("Scrolled till the element");
	}
	
	public void setMoniter1FileUploadBtn() throws InterruptedException
	{
		//Moniter1FileUploadBtn.sendKeys(Keys.ENTER);
		logger.info("inside the fileupload");
		Moniter1FileUploadBtn.sendKeys("C:\\Users\\dhananjay.pokale\\Desktop\\sample.txt");
		Thread.sleep(10000);
		logger.info("checking path");
		/*Alert myalert=driver.switchTo().alert();
		logger.info("switched to alert poppup");
		myalert.accept();
		logger.info("alert accepted");*/
	}
	
	
	//Datepicker
	@FindBy(xpath="//input[@id='input-option-219']")
	WebElement DatePickerBox;
	
	@FindBy(xpath="//div[@class='drp-calendar left single']//th[@class='next available']")
	WebElement DatePickerNextBtn;
	
	@FindBy(xpath="//div//th[@class='month']")
	WebElement MonthYearTxt;
	
	@FindBy(xpath="//th[@class='prev available']//span")
	WebElement DatePickerPrveiousBtn;
	
	@FindBy(xpath="//tbody//tr//td")
	List <WebElement> All_dates;
	
	public void setMoniter1DatePicker()
	{
		DatePickerBox.click();
		while(true) {
		String MonthYr=MonthYearTxt.getText();
		String Desire_MonthYr="Apr 2012";
		
			if(MonthYr.equals(Desire_MonthYr))
				{
					break;
				}
			DatePickerNextBtn.click();
		}
		
		
		
		for (WebElement dt:All_dates)
		{
			if(dt.getText().equals("15"))
			{
				dt.click();
				break;
			}
		}				
	}
	
	
	//TimePicker	
	@FindBy(xpath="//div[@class='drp-calendar left single']//select[@class='hourselect']")
	WebElement TimerHrBox;
	
	@FindBy(xpath="//div[@class='drp-calendar left single']//select[@class='minuteselect']")
	WebElement TimerMinuteBox;
	
	@FindBy(xpath="//div[@class='daterangepicker ltr single opensright show-calendar']//button[@type='button'][normalize-space()='Apply']")
	WebElement TimerApplyBtn;
	
	public void setMoniter1TimePicker()
	{
		Moniter1TimePicker.click();
		String Hour="13";
		String Minute="19";
		
		TimerHrBox.click();
		Select drphour=new Select(TimerHrBox);
		drphour.selectByVisibleText(Hour);
		TimerMinuteBox.click();
		Select drpMinute=new Select(TimerMinuteBox);
		drpMinute.selectByVisibleText(Minute);
		TimerApplyBtn.click();
	}

	public void setMoniter1DateTimePicker(String dtTime)
	{
		Moniter1DateTimePicker.clear();
		Moniter1DateTimePicker.sendKeys(dtTime);
		Moniter1DateTimePickerClosed.click();
	}
	
	public void setMoniter1QtyBox(String Qty)
	{
		Moniter1QtyBox.clear();
		Moniter1QtyBox.sendKeys(Qty);
	}
	
	public void ScrollingMoniter1AddCartBtn()
	{
		logger.info("Scrolling");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",Moniter1AddCartBtn);
		logger.info("Scrolled till the element");
	}
	
	public void clickMoniter1AddCartBtn()
	{
		logger.info("element searching");
		Moniter1AddCartBtn.click();
		logger.info("Element found and click");
	}
	
	
	
	
	
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[4]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
	WebElement rrrrt1;
	
	@FindBy(xpath="//input[@name='http_submit']")
	WebElement rrrrt2;
	
	
	public void setrrrrt1() throws InterruptedException
	{
		//Moniter1FileUploadBtn.sendKeys(Keys.ENTER);
		logger.info("inside the fileupload");
		rrrrt1.sendKeys("C:\\Users\\dhananjay.pokale\\Desktop\\sampletest.txt");
		Thread.sleep(5000);
		logger.info("checking path");
		rrrrt2.click();
		Thread.sleep(5000);		
	}
	
	
	
	
	
	
	
	
	
}
