package automationPractice.bhanu.homePage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import automationPractice.bhanu.excelReader.ExcelReader;
import automationPractice.bhanu.pageObject.HomePage;
import automationPractice.bhanu.pageObject.ProductDetailsPage;
import automationPractice.bhanu.pageObject.ProductPage;
//import automationPractice.bhanu.pageObject.HomePage;
import automationPractice.bhanu.testBase.TestBase;

@Listeners(automationPractice.bhanu.screenShots.ScreenShot.class)
public class TC_004selectItemBasedOnNavigationMenu extends TestBase{
	HomePage homePage;
	ExcelReader excel;
	ProductPage prodPage;
	ProductDetailsPage prodDeailPage;
	@BeforeClass
	public void setup() throws InterruptedException{
		
		 init();
		
	}
	
	@BeforeMethod
	public void login() throws InterruptedException{
		excel=new ExcelReader();
		homePage=new HomePage(driver);
		 homePage.loginMtd(excel.user, excel.pass);
		
	}
	/*@Test
	public void selectItem(){
		homePage=new HomePage(driver);
		homePage.menuSelection(homePage.women);
		homePage.clickOnNavigationMenu(homePage.tops);
		homePage.selectProduct(homePage.tops,homePage.tshirts);
		prodPage=new ProductPage(driver);
		prodPage.selectProductFromProductPage(prodPage.tshirtName);
		prodDeailPage=new ProductDetailsPage(driver);
		prodDeailPage.productDetails();
		
	}*/
	@Test
	public void VerifyShareLinkIsWorkingInProductDetailsPage(){
		homePage=new HomePage(driver);
		homePage.menuSelection(homePage.women);
		homePage.clickOnNavigationMenu(homePage.tops);
		log.info("navigate to the tops navigation menu sucrssfully");
		homePage.selectProduct(homePage.tops,homePage.tshirts);
		log.info("tshirt selected sucessfully");
		prodPage=new ProductPage(driver);
		prodPage.selectProductFromProductPage(prodPage.tshirtName);
		log.info("product details of tshirt shown sucessfully");
		prodDeailPage=new ProductDetailsPage(driver);
		//prodDeailPage.productDetails();
		prodDeailPage.linkCheckMtd(prodDeailPage.facebook);
		log.info("click on facebook sucessfully");
		TestBase.getAllWindowId();
		log.info("getting all id of the opening window sucessfully ");
		driver.switchTo().window(TestBase.windows.get(1));
		log.info("driver control move to the 2nd window sucessfully");
		boolean msg=prodDeailPage.verifyfacebookMsg();
		log.info("msg verification done");
		driver.switchTo().window(TestBase.windows.get(0));
		log.info("control move back to parent or 1st window");
		Assert.assertEquals(true, msg);
	}
	/*@Test
	public void getTheListOfTotalProductOfSelectedCateogary(){
		homePage=new HomePage(driver);
		homePage.menuSelection(homePage.women);
		homePage.clickOnNavigationMenu(homePage.dresses);
		homePage.selectProduct(homePage.dresses,homePage.summerDresses);
		prodPage=new ProductPage(driver);
		prodPage.selectProductFromProductPage();
		
	}*/
	@AfterMethod
	public void logout(){
		homePage.logoutMtd();
		
	}
	
	@AfterClass
	public void endTest(){
		driver.close();
		log.info("driver closed");
	}
	
}
