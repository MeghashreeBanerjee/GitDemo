import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Assgnment8AutoSuggestAutocompletePractice {

	public static void main(String[] args) throws InterruptedException 
	{
		
	System.setProperty("webdriver.chrome.driver",
			"C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://qaclickacademy.com/practice.php");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(By.id("autocomplete")).sendKeys("au");
	List <WebElement> place= driver.findElements(By.cssSelector("ul[id='ui-id-1'] li"));
	
	//Trainer Code
	driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
    System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 
	
    /*//My code// 
	driver.findElement(By.id("autocomplete")).sendKeys("au");
	List <WebElement> place= driver.findElements(By.cssSelector("ul[id='ui-id-1'] li"));
	for(WebElement opt :place)
	  {
		  if(opt.getText().equalsIgnoreCase("Macau"))
		  {
			  opt.click();
			  System.out.println(opt.getText());
			  System.out.println("Welcome to Macau");
			  break;
		  }

	  } */
	
	}
}



  