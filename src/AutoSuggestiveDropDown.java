import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class AutoSuggestiveDropDown {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		  
		  driver.findElement(By.id("autosuggest")).sendKeys("br");
		  
		  Thread.sleep(3000);
		  List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		  
		  for(WebElement opt :options)
		  {
			  if(opt.getText().equalsIgnoreCase("Gibraltar"))
			  {
				  opt.click();
				  break;
			  }

		  }

	}

}
