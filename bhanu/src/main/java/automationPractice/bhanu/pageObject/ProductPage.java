package automationPractice.bhanu.pageObject;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public final String tshirtName="Faded Short Sleeve T-shirts";
	
	public static final Logger log=Logger.getLogger(ProductPage.class.getName());
WebDriver driver;
	
	@FindBy(xpath="//span[@class='cat-name']")
	WebElement showingSelectedCategoryName;
	
	@FindBy(xpath="//span[@class='heading-counter']")
	WebElement noOfProductAvailable;
	
	@FindBy(xpath="//div[@id='center_column']/div")
	WebElement productdetails;
	
	@FindBy(xpath="//ul[@class='product_list grid row']//following::h5/a")
	List<WebElement> llistofProduct;
	
	public ProductPage(WebDriver driver){
		//initialize the page driver to avoid null pointer exception
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectProductFromProductPage(String productName){
	//a[contains(text(),'Faded Short Sleeve T-shirts')]
	driver.findElement(By.xpath("//a[contains(text(),'"+productName+"')]")).click();	
	log.info("select the single product and product name is :-"+productName.toString());
	}
	public void selectProductFromProductPage(){
		List<WebElement> elements=llistofProduct;
		log.info("get all the product in a particular choosed section :-"+llistofProduct.toString());
		Iterator<WebElement> itr=elements.iterator();
		while(itr.hasNext()){
			elements.add(itr.next());
		}
		for(int i=0;i<elements.size();i++){
			int j=i+1;
		System.out.println(j+"."+elements.get(i).getText());
		}
				
	}
	
}
