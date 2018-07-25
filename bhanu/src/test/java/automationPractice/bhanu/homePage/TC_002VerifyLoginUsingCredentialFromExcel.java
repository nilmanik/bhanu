package automationPractice.bhanu.homePage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationPractice.bhanu.excelReader.ExcelReader;
import automationPractice.bhanu.pageObject.HomePage;

import automationPractice.bhanu.testBase.TestBase;

public class TC_002VerifyLoginUsingCredentialFromExcel extends TestBase {
	HomePage homePage;
	ExcelReader excel;
	 
	/*@DataProvider(name="loginData") 
	public String[][] getTestData(){
		String[][] testRecords=getData("testData.xlsx", "loginTestData");
		return testRecords;
	}*/
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		
		 init();
		
	}
	
	
	@Test
	public void verifyLoginWithInvalidCredentials() throws Exception{
		excel=new ExcelReader();
		String user=excel.getParticularDataFromExcel("loginTestData", 1, 0);
		String pass=excel.getParticularDataFromExcel("loginTestData", 1, 1);
		homePage=new HomePage(driver); 
		homePage.loginMtd(user, pass);
		 String arg1="Invalid Email or Password";
		 
		 try {
			Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Invalid Email or Password']")).getText(),arg1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("login successfully :");
		}
	}
	
	
	@AfterMethod
	public void endTest(){
		driver.close();
	}
}
