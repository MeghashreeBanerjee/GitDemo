import java.util.Set;
import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingChildWnidow 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click(); //click on blinking text
		
		//Telling Selenium the control is now in child window
		Set<String> windows= driver.getWindowHandles();
		java.util.Iterator<String> it = windows.iterator();
		String parentID=it.next();
		String childID= it.next();
		
		//Switching control to Child window
		driver.switchTo().window(childID);
		//String userName=driver.findElement(By.linkText("mentor@rahulshettyacademy.com")).getText();
		String userName= 
		driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
		
		//Switching back to Parent window
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(userName);
		

	}

}
