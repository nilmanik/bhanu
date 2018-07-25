package automationPractice.bhanu.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationPractice.bhanu.testBase.TestBase;

public class HomePage {
	public final String women="Women";
	public final String dresses="Dresses";
	public final String tshirts="T-shirts";
	public final String tops="Tops";
	public final String blouses="Blouses";
	public final String summerDresses="Summer Dresses";
	
	public static final Logger log=Logger.getLogger(HomePage.class.getName());
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='login']")
	WebElement clickOnLogin;
	
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailBox;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement pwdBox ;
	
	@FindBy(xpath="//button[@id='SubmitLogin']//span")
	WebElement signInBtn;
	
	@FindBy(xpath="//div[@id='center_column']/div[1]")
	WebElement authenticationFailed;
	
	@FindBy(xpath="//a[@class='logout']")
	WebElement clickOnLogout;
	
	@FindBy(xpath="//a[@title='Women']")
	WebElement clickOnWomanSection;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginMtd(String email,String password){
		clickOnLogin.click();
		log.info("login link of the home page is clicked successfully :-"+clickOnLogin.toString());
		emailBox.sendKeys(email);
		log.info("emailid enter is  :-"+email);
		pwdBox.sendKeys(password);
		log.info("password enter is   :-"+password);
		signInBtn.click();
		log.info("login botton  clicked successfully :-"+signInBtn.toString());
		System.out.println("login successfully");
		
		
	}
	public void logoutMtd(){
		clickOnLogout.click();
		log.info("loout successfully and the object is :-"+clickOnLogout.toString());
	}
	public void clickOnNavigationMenu(String selectSection){
		//(//ul[@class='tree dynamized'])[1]/li/a[contains(text(),'Tops')]/../span
		
		driver.findElement(By.xpath("(//ul[@class='tree dynamized'])[1]/li/a[contains(text(),'"+selectSection+"')]/../span")).click();
		log.info("+ navigation button clicked of ::"+selectSection.toString()+":: section");
	}
	
	public void menuSelection(String menu){
		//div[@id='block_top_menu']/ul/li/a[@title='Dresses']
		driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li/a[@title='"+menu+"']")).click();
		
		log.info(menu.toString() +":- cateogary selected successfully");
	}
	
	public void selectProduct(String section,String productName){
		//(//ul[@class='tree dynamized'])[1]/li/a[contains(text(),'Tops')]/following-sibling::ul/child::li/a[contains(text(),'Blouses')]
		
		WebElement ele=driver.findElement(By.xpath("(//ul[@class='tree dynamized'])[1]/li/a[contains(text(),'"+section+"')]/following-sibling::ul/child::li/a[contains(text(),'"+productName+"')]"));
		TestBase.waitForElement(30, ele);
		ele.click();
		log.info(productName.toString()+":- product select of the :- "+section.toString()+" -:cateogary");
	}
	
}
