package testNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testng { 
	@BeforeClass
	void login() {
		System.out.println("logged in");
	}
	@Test(priority = 1, groups={"login"})
	void input() {
		System.out.println("Entered details");
	}
	@Test(priority=2 ,groups = {"login"} )
	void clickmethods() {
		System.out.println("submit");
	}
	@AfterClass
	void logout() {
		System.out.println("logged out");
	}
	
	
}
