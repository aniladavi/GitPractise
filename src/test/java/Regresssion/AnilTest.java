package Regresssion;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnilTest {
	
	@Test
	public void setup()
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\anilvsa\\eclipse\\Ref\\chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	driver.get("http://www.learn-automation.com");
	Assert.assertTrue(driver.getTitle().contains("Selenium"));
	System.out.println("Test Completion - END");
	driver.close();
	}

}
