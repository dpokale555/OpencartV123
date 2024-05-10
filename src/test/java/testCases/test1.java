package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test1 {
	
	public void test() {
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://uat.omniumpay.io/pay-link/link/pl_2eUhZmdLm3fUhsvyMfnBECVREk1");
	driver.findElement(By.xpath("//a[@id='pn_id_1_header_action']")).click();
	}
}


