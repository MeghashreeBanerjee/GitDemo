import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

//import antlr.collections.List;

public class Calendar 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions/");
		Thread.sleep(8000);
		driver.manage().window().fullscreen();
	
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("window.scrollBy(0,1200)");	
		Thread.sleep(8000);
		driver.findElement(By.cssSelector("input[id='form-field-travel_comp_date']")).click();
		//System.out.println(driver.findElement(By.name("form_fields[travel_comp_date]")).getText());
		
		/*//Select Year
		while(!driver.findElement(By.cssSelector("input[class='numInput cur-year']")).getText().contains("2024"))
		{
			driver.findElement(By.xpath("//div/span[@class='arrowUp']")).click();
			break;
		}
		Thread.sleep(8000); */
		
		
		//select month 
		while(!driver.findElement(By.cssSelector("div[class='flatpickr-month'] div[class='flatpickr-current-month'] span[class='cur-month']")).getText().contains("February"))
		{
			driver.findElement(By.cssSelector("div[class='flatpickr-month'] span[class='flatpickr-next-month']")).click();
			break;
		}
		Thread.sleep(8000);
		
		
		//selecting date => store list of dates in a List, iterate it 
		List <WebElement> travelDate = driver.findElements(By.cssSelector("span.flatpickr-day "));
		 int count = driver.findElements(By.cssSelector("span.flatpickr-day ")).size();
		 
		 for(int i=0; i<count;i++)
		 {
			String text = travelDate.get(i).getText();
			
			if(text.equalsIgnoreCase("14"))
			{
				travelDate.get(i).click();
				break;
			}
			
		 }
		
		 //driver.close();
	}

}
