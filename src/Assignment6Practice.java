import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6Practice 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaclickacademy.com/practice.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Handling CheckBox
		driver.findElement(By.id("checkBoxOption2")).click();
		String dynamicOption = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		System.out.println("CheckBox:" +dynamicOption);
		
		//Handling DropDown
		WebElement st = driver.findElement(By.id("dropdown-class-example"));
		Select staticDropdown = new Select(st);
		staticDropdown.selectByVisibleText(dynamicOption);
		System.out.println("DropDown:" +staticDropdown.getFirstSelectedOption().getText());
		
		
		
		//Handling Alert Section
		driver.findElement(By.id("name")).sendKeys(dynamicOption);
		Thread.sleep(5000);
		driver.findElement(By.id("alertbtn")).click();
		String alertMsg = driver.switchTo().alert().getText();
		System.out.println(alertMsg);
		driver.switchTo().alert().accept();
		
		if(alertMsg.contains(dynamicOption))
		{
			System.out.println("Assignment complete!");
		}	

	}

}
