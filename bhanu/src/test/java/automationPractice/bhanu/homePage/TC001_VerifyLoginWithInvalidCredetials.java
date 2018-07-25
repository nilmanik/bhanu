package automationPractice.bhanu.homePage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automationPractice.bhanu.testBase.TestBase;
import automationPractice.bhanu.pageObject.HomePage;

public class TC001_VerifyLoginWithInvalidCredetials extends TestBase {
	HomePage homePage;
 
@BeforeTest
public void setup() throws InterruptedException{
	
	 init();
	
}
@Test(priority=1)
public void verifyLoginWithInvalidCredentials(){
	homePage=new HomePage(driver); 
	homePage.loginMtd("user@phptravels.com", "demouser");
	 String arg1 = "There is 1 error Authentication failed.";
	 //arg1.contains("Authentication failed.");
	 
	/* try {
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/div[1]")).getText(),arg1.contains("Authentication failed."));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("login successfully :");
	}*/
}
@AfterClass
public void endTest(){
	driver.close();
}
}
