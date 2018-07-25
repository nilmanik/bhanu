package automationPractice.bhanu.pageObject;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationPractice.bhanu.testBase.TestBase;


public class ProductDetailsPage {
//private static final String socialsharing_twitter_click = null;

WebDriver driver;
public final String twiter="socialsharing_twitter_click";
public final String facebook="socialsharing_facebook_click();";
public final String googlePlus="socialsharing_google_click();";
public final String pintarest="socialsharing_pinterest_click";

public static final Logger log=Logger.getLogger(ProductDetailsPage.class.getName());

	@FindBy(xpath="//div[@id='center_column']/div")
	WebElement productdetails;
	
	@FindBy(xpath="//div[contains(text(),'Log into your Facebook account to share.')]")
	WebElement facebookMessage;
	
	public ProductDetailsPage(WebDriver driver){
		//initialize the page driver to avoid null pointer exception
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void productDetails(){
	//
	String details=productdetails.getText();
	log.info("......details of the product ........\n"+details.toString());
	}
	
	public void linkCheckMtd(String linkName){
		Boolean check=driver.findElement(By.xpath("//button[contains(@onclick,'"+linkName+"')]")).isEnabled();
		System.out.println("***********************************************************************");
		log.info(linkName.toString()+" ... link is enable...."+check);
		driver.findElement(By.xpath("//button[contains(@onclick,'"+linkName+"')]")).click();
		log.info(linkName.toString()+": link has been selected crossponding page is opened in the new window");
	}
		
	
	public Boolean verifyfacebookMsg(){
		try {
			facebookMessage.isDisplayed();
			log.info("facebook page is displayed and fb messsage is :-"+facebookMessage.getText());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
