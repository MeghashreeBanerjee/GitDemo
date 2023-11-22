import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3AddItemImplicitExplicirWait {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		//driver.manage().window().fullscreen();
		
		//implicit timeout
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//explicit timeout
		WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Filling-up Form
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.cssSelector("input[value='user']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']/p")));
		 System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']/p")).getText());
		driver.findElement(By.cssSelector("button#okayBtn")).click();
		WebElement staticDropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select stDropdown = new Select(staticDropdown);
		stDropdown.selectByValue("consult");
		  System.out.println(stDropdown.getFirstSelectedOption().getText());
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click(); 
		//putting explicit Wait based on the visibility of Check Out button
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='nav-link btn btn-primary']")));
		   
		
		//Adding items to cart
		String[] itemList= {"iphone X","Samsung Note 8","Nokia Edge","Blackberry"};
		addItemsOnCart(driver, itemList );
		//System.out.println(driver.findElement(By.cssSelector("h4[class='card-title']")).getText());
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		driver.close();
	}
	
	public static void addItemsOnCart(WebDriver driver, String[] itemList)
	{
		int j=0;
		List itemArrayList = Arrays.asList(itemList);
		 System.out.println(itemArrayList);
		
		List <WebElement> products = driver.findElements(By.cssSelector("h4[class='card-title']"));
		for(int i=0; i<products.size(); i++)
		{
			String itemName= products.get(i).getText();
		     System.out.println(itemName);
		     
		     if(itemArrayList.contains(itemName))
				{
					driver.findElements(By.cssSelector("button[class='btn btn-info']")).get(i).click();
					j++;
					
				    if(j == itemList.length)
					 break;
				}
		    
		}
		
		
	}
	
	

}
