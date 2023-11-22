import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;

import junit.framework.Assert;

import java.util.List;

//import antlr.collections.List;

public class ScrollandTable {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaclickacademy.com/practice.php");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,530)"); // scrolling through page	
		Thread.sleep(6000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000"); // scrolling through content (or table here) 
		
		
        List <WebElement> column4 = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        
        int sum1=0;
        for(int i=0;i<column4.size();i++)
        {
        	//System.out.println(column4.get(i).getText());
        	sum1 += Integer.parseInt(column4.get(i).getText());
        }
        
        System.out.println(sum1);
        
        String totalAmntText = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
        int total= Integer.parseInt(totalAmntText);
       // System.out.println(totalAmntText);
        Assert.assertEquals(sum1,total);
	}

}
