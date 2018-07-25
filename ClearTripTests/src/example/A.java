package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class A {
public static void main(String[] args) {
	WebDriver driver=new FirefoxDriver();
	driver.get("https://www.facebook.com/r.php");
	driver.findElement(By.name("firstname")).sendKeys("ajay");
	driver.findElement(By.name("lastname")).sendKeys("kumar");
	
}
}
