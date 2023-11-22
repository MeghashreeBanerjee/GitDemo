import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5NestedFrame 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.linkText("Nested Frames")).click();
		
		WebDriver parentFrame= driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		
        parentFrame.switchTo().frame(driver.findElement(By.xpath("//frameset/frame[2]")));
        System.out.println(driver.findElement(By.id("content")).getText());
          
	}
}
