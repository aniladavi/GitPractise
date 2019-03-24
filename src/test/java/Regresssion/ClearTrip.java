package Regresssion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

public class ClearTrip {
	
	
	
	@Test
	public void setup1() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","C:\\Anil_Sumtotal\\D_Drive\\sts3.9.2workspace\\chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	
	driver.get("https://www.cleartrip.com/");
	driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	driver.findElement(By.id("OneWay")).click();
	
	
	WebElement source = driver.findElement(By.id("FromTag"));
	Thread.sleep(5000);
	source.sendKeys("New");
	Thread.sleep(6000);
	source.sendKeys(Keys.ARROW_DOWN);
	source.sendKeys(Keys.ENTER);
	
	WebElement source1 = driver.findElement(By.id("ToTag"));
	Thread.sleep(5000);
	source1.sendKeys("Chia");
	Thread.sleep(6000);
	source1.sendKeys(Keys.ARROW_DOWN);
	source1.sendKeys(Keys.ENTER);
	
	
	//calendar

	driver.findElement(By.id("DepartDate")).click();
	driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active ")).click();

	//DD1

	WebElement adult=driver.findElement(By.id("Adults"));
	Select s =new Select(adult);
	s.selectByIndex(2);

	//DD2

	WebElement ch=driver.findElement(By.id("Childrens"));
	Select s1 =new Select(ch);
	s1.selectByIndex(2);


	driver.findElement(By.xpath("//a[@title='More search options']")).click();
	driver.findElement(By.id("AirlineAutocomplete")).sendKeys("indigo");
	driver.findElement(By.id("SearchBtn")).click();

	//validate error message
	//System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());



	
	}
}
