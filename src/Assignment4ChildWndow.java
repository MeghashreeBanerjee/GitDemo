import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4ChildWndow {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> windows= driver.getWindowHandles(); 
		Iterator<String> it = windows.iterator();
		String parentID= it.next();
		String childID= it.next();
		driver.switchTo().window(childID);
		
		String childWindowMsg= driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		System.out.println(childWindowMsg);
		
		driver.switchTo().window(parentID);
		String parentWindowMsg= driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		System.out.println(parentWindowMsg);
		

	}

}
