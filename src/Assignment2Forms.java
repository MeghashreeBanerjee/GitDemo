import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class Assignment2Forms 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Meghashree");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("megha@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("abcd");
		driver.findElement(By.id("exampleCheck1")).click();
		
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		driver.findElement(By.xpath("//select/option[2]")).click();
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("10-10-90");
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("div[class*='alert']")).getText());
		driver.close();
		
		//Assert.assertEquals(driver.findElement(By.cssSelector("div[class*='alert']")).getText(), "[×\r\n"
			//	+ "] Success! The Form has been submitted successfully!.");
	}

}
