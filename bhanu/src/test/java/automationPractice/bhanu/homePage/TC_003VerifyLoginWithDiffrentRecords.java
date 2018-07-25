package automationPractice.bhanu.homePage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import automationPractice.bhanu.excelReader.ExcelReader;
import automationPractice.bhanu.pageObject.HomePage;
import automationPractice.bhanu.testBase.TestBase;
@Listeners(automationPractice.bhanu.screenShots.ScreenShot.class)
public class TC_003VerifyLoginWithDiffrentRecords extends TestBase {
	HomePage homePage;
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		
		 init();
		
	}
	
	
	@Test(dataProvider="empLogin",dataProviderClass=TestBase.class)
	public void verifyLoginWithInvalidCredentials(String username,String password){
		
		//uname=
		homePage=new HomePage(driver); 
		homePage.loginMtd(username, password);
		//getScreenShotMethod("verifyLoginWithInvalidCredentials---"+username+"---"+password);
		 String arg1="Invalid Email or Password";
		 
		 /*try {
			Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Invalid Email or Password']")).getText(),arg1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("login successfully :");
		}*/
	}
	
	
	@AfterMethod
	public void endTest(){
		driver.close();
	}
}
