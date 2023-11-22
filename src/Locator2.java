import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;


public class Locator2 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String name= "Megha";
		String password = getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		

		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		
		//driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		System.out.println(driver.findElement(By.xpath("//*[text()='You are successfully logged in.']")).getText());  
		Assert.assertEquals(driver.findElement(By.xpath("//*[text()='You are successfully logged in.']")).getText(),"You are successfully logged in.");
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
		
		driver.findElement(By.className("logout-btn")).click();
		System.out.println("logged out");
		driver.close();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String pwdText=driver.findElement(By.cssSelector("form p")).getText();
		String[] pwdArray = pwdText.split("'");
		String pwd= pwdArray[1].split("'")[0];
		return pwd;
	}
	

}
