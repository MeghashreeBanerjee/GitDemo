import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class BrokenList 
{

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaclickacademy.com/practice.php");
		Thread.sleep(5000);
		
		//String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		//String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		List <WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		Thread.sleep(5000);
		SoftAssert sa =  new SoftAssert();
		
		for(WebElement link: links)
		{
			//System.out.println(link.getText());
			//java methods to call URL and then getting response code
			String url = link.getAttribute("href");
			HttpURLConnection conn =(HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int rCode = conn.getResponseCode();
			//System.out.println(rCode);
			
			/*if(rCode>400)
			{
				System.out.println("The text with link " + link.getText() + "is Broken with response code "+ rCode);
				Assert.assertTrue(false);
			}*/
			
			//Instead of If block we can use SoftAssert to avoid terminating code in the middle on the first occurance of broken link
			
			sa.assertTrue(rCode<400, "The text with link " + link.getText() + "is Broken with response code "+ rCode);
			
		}
		
		sa.assertAll();
		
		driver.close();
		
		
		
		
		/*//java methods to call URL and then getting response code
		HttpURLConnection conn =(HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int rCode = conn.getResponseCode();
		System.out.println(rCode);*/
		
	}

}
