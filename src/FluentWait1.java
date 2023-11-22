import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

//import org.testng.Assert;
import junit.framework.Assert;

public class FluentWait1
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
	/*	//using WebDriverWait as Explicit Wait
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(6));
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='finish'] h4")));
		System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText(),"Hello World!");
	*/
		driver.findElement(By.xpath("//div[@id='start']/button")).click();
		//using FluentWait as Explicit Wait
		Wait<WebDriver> w= new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(4)).ignoring(NoSuchElementException.class);
		
		WebElement foo = w.until(new Function<WebDriver, WebElement>() 
		{
		     public WebElement apply(WebDriver driver) 
		     {
		    	 if(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed())
		    	 {
		    		 return driver.findElement(By.cssSelector("div[id='finish'] h4"));
		    	 }
		    	 else
		    		 return null;
		     }
		});
	System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed());	
	System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText());
	Assert.assertEquals(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText(),"Hello World!");
		
	}

}
