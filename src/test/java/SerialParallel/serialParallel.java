package SerialParallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class serialParallel {
	WebDriver driver;
	@BeforeClass
   void setup() throws InterruptedException {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	   driver.manage().window().maximize();
	   Thread.sleep(2000);
	   }
	@Test(priority=1)
	void login() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
	}
	@Test(priority=2, dependsOnMethods={"login"})
    void imagevalidation() {
    	 Boolean img = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
    	 Assert.assertEquals(img, false);
    }
	@Test(priority=3)
	void successlogin() {
		boolean login = driver.findElement(By.xpath("//a[text()='Shopping cart']")).isDisplayed();
		Assert.assertEquals(login, true);
	}
	@AfterClass
	void close() {
		driver.quit();
	}
	 
}
