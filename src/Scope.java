import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaclickacademy.com/practice.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//printing total no. of links on the page
		System.out.println("Total no. of link in the page is:" + driver.findElements(By.tagName("a")).size());
		
		//printing total no. of links on the footer section of page
		WebElement footerDriver= driver.findElement(By.id("gf-BIG")); // limiting webDriver's scope
		System.out.println("Total no. of link in the footer section of page is:" + footerDriver.findElements(By.tagName("a")).size());
		
		
		//printing total no. of links on the footer section of page
		WebElement footerFirstColumnDriver= footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")); // limiting webDriver's scope
		System.out.println("Total no. of link in the 1st column of footer section is:" + footerFirstColumnDriver.findElements(By.tagName("a")).size());
				
		//click on each link of the first footer column
		
		for(int i=1; i<footerFirstColumnDriver.findElements(By.tagName("a")).size();i++)
		{
			String linksToClick = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerFirstColumnDriver.findElements(By.tagName("a")).get(i).sendKeys(linksToClick);
			System.out.println("clicked" + i);
			Thread.sleep(5000);
			
		}
		
		// navigate to child windows and get the titles
					Set<String> windows= driver.getWindowHandles(); 
					Iterator<String> it = windows.iterator();
					
					while(it.hasNext())
					{
						driver.switchTo().window(it.next());
						System.out.println(driver.getTitle());
					}
			
	
	}	
	

}
