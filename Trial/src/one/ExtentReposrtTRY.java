package one;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReposrtTRY {

	
	public static void main(String[] args) throws IOException {

		
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("extent.html");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		
		// test 
		
		ExtentTest test1 = extent.createTest("my first test " , "description");
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new  ChromeDriver();
		
		driver.get("https://oxyninja.com/");
			
		test1.log(Status.INFO, "starting test case ");

		
		driver.findElement(By.id("link_text-124-2516")).click();
		test1.pass("click Pass");
		
		driver.findElement(By.id("link_text-39-2516")).click();
		test1.fail("click failed");
		
		 TakesScreenshot ts = (TakesScreenshot)driver;
			
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 
//		 String dest = System.getProperty("user.dir")+"/screenshots" + screenshotName+".png";
		 
		 FileHandler.copy(source , new File(System.getProperty("user.dir")+"/screenshotss" +".png"));
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.quit();
		
		test1.pass("browse closed");

		test1.log(Status.INFO, "test completed ");
		
		extent.flush();


	}

}
