
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.w3c.dom.Document;

	import junit.framework.Assert;

	import java.util.List;

	//import antlr.collections.List;

public class Assignment7Tables 
{
		public static void main(String[] args) throws InterruptedException 
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://qaclickacademy.com/practice.php");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,530)"); // scrolling through page	
			Thread.sleep(6000);
			//js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000"); // scrolling through content (or table here) 
			
			List <WebElement> row = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));
			List <WebElement> column = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th"));
			
			System.out.println("No. of row " + row.size());
			System.out.println("No. of column " + column.size());
			
			for(int i=1;i<row.size();i++)
			{
				//row.get(i).getText();
				
				if(i==2)
				{
				System.out.println(row.get(i).getText());
				break;
				}
			}
		
		}

	
}
