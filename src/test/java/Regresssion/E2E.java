package Regresssion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2E {

	
	@Test
	public void setup2() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\anilvsa\\eclipse\\Ref\\chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	
	driver.get("https://www.spicejet.com");
	driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	
	driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//a[@value='DEL']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
	driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
	
	driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
	driver.findElement(By.id("divpaxinfo")).click();
	Thread.sleep(2000);
	for (int i =1; i<5; i++)
	{
	driver.findElement(By.id("hrefIncAdt")).click();
	}
	driver.findElement(By.id("btnclosepaxoption")).click();
	Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
	System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	
	
	Select s= new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
	//Select s= new Select(driver.findElement(By.xpath("//*[@class='valid']")));
		s.selectByIndex(1);
	WebElement opt = s.getFirstSelectedOption();
	System.out.println(opt.getText());
	s.selectByValue("AED");
	opt = s.getFirstSelectedOption();
	System.out.println(opt.getText());
	s.selectByVisibleText("USD");
	opt = s.getFirstSelectedOption();
	System.out.println(opt.getText());
	
	if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
	{
		System.out.println("To is Disabled");
		Assert.assertTrue(true);
	}
	else
	{	
		System.out.println("To is Enabled");
		Assert.assertTrue(false);
	}
	
	driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	
	
	
	driver.close();
	}
}
