import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestFrame 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		System.out.println((driver.findElements(By.tagName("iframe"))).size());
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		//System.out.println(driver.findElement(By.tagName("iframe")).Size());
		System.out.println(driver.findElement(By.id("draggable")).getText());
		
		WebElement source= driver.findElement(By.id("draggable"));
		WebElement target= driver.findElement(By.id("droppable"));
		
		System.out.println(driver.findElement(By.id("droppable")).getText());
		
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		
		System.out.println(driver.findElement(By.id("droppable")).getText());
		

	}

}
