package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportManager implements ITestListener 

{
	public ExtentSparkReporter sparkReporter;   
	public ExtentReports extent;      
	public ExtentTest test;  
	
	String repName;
	
	public void onStart(ITestContext testContext)
	{
		/*
		 * SimpleDateFormat sd=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 * String timeStamp=sd.format(dt);
		 * Date dt=new Date();
		*/
		
		//We can either write like above 3 lines or below single statement for timestamp
		String timeStamp =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp
		repName="Test-Report-"+timeStamp+".html";
	
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);  //specify location to the report
 		
		sparkReporter.config().setDocumentTitle("Opencart Automation Report"); //Title of the report
		sparkReporter.config().setReportName("Opencart Functional Testing");  //name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application Name", "Opencart");
	//	extent.setSystemInfo("Module", "Admin");
	//	extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Enviornment", "QA");
		extent.setSystemInfo("Tester Name", "Dhananjay");	
		
	}
	
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());       //create a new entry in the report
		test.log(Status.PASS, "Test PASSED is: "+result.getName());  //update status passed/failed/skiped
	}
	
	
	public void onTestFailure(ITestResult result)
	{
		test= extent.createTest(result.getName());
		test.log(Status.FAIL, "Test FAILED is: "+result.getName());
		test.log(Status.FAIL, "Test FAILED cause is: "+result.getThrowable().getMessage());
		
		//To add screenshot into the report in case for failure
		try
		{
			String ScreenshotPath=System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png";
			test.addScreenCaptureFromPath(ScreenshotPath);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public void onTestSkipped(ITestResult result)
	{
		test =extent.createTest(result.getName());   //test=extent.createTest(result.getTestContext().getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test case SKIPPED is: "+result.getName());
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestContext Context)
	{
		extent.flush();
	
		/*try
		{
			URL url=new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
			
		//Create the email message
			ImageHtmlEmail email=new ImageHtmlEmail();
			email.setDataSourceResolver(new DataSourceUrlResolver(url));
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("abcd12@gmail.com", "Test@123"))
			email.setSSLOnConnect(true);
			email.setFrom("abcd12@gmail.com");     //sender
			email.setSubject("Test Result");
			email.setMsg("Please find the Attached Report...");
			email.addTo("dpokale555@gmail.com");   //Receiver
			email.attach(url, "extent report", "please check report..");
			email.send();   //send the email		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}*/
	}
	
	
}
