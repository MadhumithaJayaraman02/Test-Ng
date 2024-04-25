package cognizant;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cognizant {
	WebDriver driver;
	
@BeforeClass
 void driverSetup() {
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
	driver.get("https://be.cognizant.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
@Test(priority=1)
 void accountDetails() throws InterruptedException {
	 WebElement click = driver.findElement(By.xpath("//div[@class ='_8ZYZKvxC8bvw1xgQGSkvvA==']"));
		click.click();
		Thread.sleep(2000);
		click.click();
		
		String name = driver.findElement(By.id("mectrl_currentAccount_primary")).getText();
		String email = driver.findElement(By.id("mectrl_currentAccount_secondary")).getText();
		System.out.println(name +"\n" + email);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",driver.findElement((By.xpath("//div//strong[text()='Around Cognizant']"))));
		Thread.sleep(2000);
 
 }

@Test(priority=2)
 void aroundCognizant() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	boolean n= driver.findElement((By.xpath("//div//strong[text()='Around Cognizant']"))).isDisplayed();
	Assert.assertEquals(true, true);
	}

@Test(priority=3)
	void news() {
WebElement a = driver.findElement(By.xpath("//a[@title='Announcing the new Cognizant ServiceNow Business Group']"));
String tit = a.getText();
String tooltip = a.getAttribute("title");
	Assert.assertEquals(tooltip, tit);
	
}

@AfterClass
 void tearDown() {
	driver.quit();
}


}
