import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class genericCode {

	public static void main(String[] args) throws InterruptedException 
	{

		System.setProperty("webdriver.chrome.driver",
				"C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//expected veggie shopping list and convertion of veggieList to veggieArrayList
		String[] veggieList= {"Cucumber","Brocolli","Brinjal","Carrot"};
		List veggieArrayList = Arrays.asList(veggieList);
        System.out.println(veggieArrayList);
        System.out.println(veggieList.length);
		
		//getting list of product item from page//
		List <WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		
		int j=0;
		
		//clicking on 'add to cart' button only for a single item selected
		for(int i=0; i<products.size();i++)
		{
					String names = products.get(i).getText();
					String[] splittedNnames= names.split("-");
					String finalTrimmedName= splittedNnames[0].trim();
					
					//System.out.println(names);
					//System.out.println(finalTrimmedName);
					
					/*//for one item this code is fine
					if(names.contains("Cucumber"))
					{
						driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
						break;
					}  */
					
					
					/*For multiple items 
					  1. Make an array of expected items to be bought
					  2. Convert the array to array list for easy search
					  3. compare the value you get from product item loop with the array list*/
				
					
					if(veggieArrayList.contains(finalTrimmedName))
					{
						driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
						j++;
						
						
					
					if(j == veggieList.length)
						break;
					}
					
		}
	}
	
	
			
	}


