package automationPractice.bhanu.screenShots;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import automationPractice.bhanu.testBase.TestBase;

public class ScreenShot extends TestBase implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult test) {
		
			try {
				Calendar cal= Calendar.getInstance();
				SimpleDateFormat dateFormet=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
				String name=test.getMethod().getMethodName();
				EventFiringWebDriver event=new EventFiringWebDriver(TestBase.driver);
				
				File srcFile=event.getScreenshotAs(OutputType.FILE);
				
				String storingScreenshotLoc=new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/automationPractice/bhanu/screenShot/failedTest/";
				 File destFile = new File((String)storingScreenshotLoc+name+"_"+dateFormet.format(cal.getTime())+".png");
				 FileUtils.copyFile(srcFile, destFile);
				 Reporter.log("<a href='" + destFile.getAbsolutePath() +"'><img src='" +destFile.getAbsolutePath()+"' height='100' width='100'/></a>");
			} catch (WebDriverException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult test) {
		try {
			Calendar cal= Calendar.getInstance();
			SimpleDateFormat dateFormet=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			String name=test.getMethod().getMethodName();
			EventFiringWebDriver event=new EventFiringWebDriver(TestBase.driver);
			
			File srcFile=event.getScreenshotAs(OutputType.FILE);
			
			String storingScreenshotLoc=new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/automationPractice/bhanu/screenShot/passedTest/";
			 File destFile = new File((String)storingScreenshotLoc+name+"_"+dateFormet.format(cal.getTime())+".png");
			 FileUtils.copyFile(srcFile, destFile);
			 Reporter.log("<a href='" + destFile.getAbsolutePath() +"'><img src='" +destFile.getAbsolutePath()+"' height='100%' width='100%'/></a>");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
