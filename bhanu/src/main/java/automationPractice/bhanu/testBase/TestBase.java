package automationPractice.bhanu.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.FileChooserUI;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import automationPractice.bhanu.excelReader.ExcelReader;
import automationPractice.bhanu.pageObject.HomePage;


public class TestBase {
	ExcelReader excel;
	public static String path="E:\\framework28-04-2018\\bhanu\\src\\main\\java\\automationPractice\\bhanu\\data\\testData1.xlsx";
	public static WebDriver driver=null;
	String url="http://automationpractice.com";
	String browser="chrome";
	String  driverPath="E:\\framework28-04-2018\\bhanu\\drivers_&_other_resource\\chromedriver.exe";
	public static List<String> windows=new ArrayList<String>();
	
	public static final Logger log=Logger.getLogger(HomePage.class.getName());
	
	
	public void init(){
		selectBrowser();
		getUrl(url);
		String log4jpath="log4j.properties";
		PropertyConfigurator.configure(log4jpath);
	}
	
	public void selectBrowser(){
		if(browser.equalsIgnoreCase("chrome")){
			log.info("choosed browser is :-"+browser.toString());
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers_&_other_resource/chromedriver.exe" );
			 driver = new ChromeDriver();
		}
		
	}
	
	public void getUrl(String url){
				driver.get(url);
				log.info("url passed in the browser is :-"+url.toString());
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		
		
		
	}
	
	@DataProvider(name="empLogin")
	public Object[][] loginData() {
		path="E:\\framework28-04-2018\\bhanu\\src\\main\\java\\automationPractice\\bhanu\\data\\testData1.xlsx";
		excel=new ExcelReader();
		Object[][] arrayObject = excel.getExcelData(path,"loginTestData");
		return arrayObject;
	}
	@DataProvider(name="empLogin1")
	public void loginData1() throws Exception {
		excel=new ExcelReader();
		Object user = excel.getCellData("loginTestData", 1, 0);
		Object pass = excel.getCellData("loginTestData", 1, 1);
		//return arrayObject;
	}
	
	/*public String[][] getData(String excelName,String sheetName){
		//String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\test\\automation\\uiAutomation\\"+excelName;
		String path="E:\\framework28-04-2018\\uiAutomation\\src\\main\\java\\com\\test\\automation\\uiAutomation\\data\\testData.xlsx";
		System.out.println(path);
		excel=new ExcelReader(path);
		String[][] data=excel.getExcelData(excelName, sheetName);
		return data;
	}*/
	
	public static void waitForElement(int timeInSeconds,WebElement element){
		WebDriverWait wait=new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("wait for "+element.getText()+"-: element");
	}
	
	public static void getAllWindowId(){
		Set<String> ids = driver.getWindowHandles();
		//Set<String> window=TestBase.getAllWindowId();
		Iterator<String> itr=ids.iterator();
		while(itr.hasNext()){
			windows.add(itr.next());
		}
		log.info("number of window opened is :-"+ids.size());
		
		
	}
	

}
