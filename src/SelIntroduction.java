import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		//FOR CHROME BROWSER --> CHROMEDRIVER
		//System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		//FOR FIREFOX BROWSER --> GECKODRIVER
		System.setProperty("webdriver.gecko.driver", "C:\\ProgramData\\firefoxdriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
				

		
		driver.get("https:\\rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.getPageSource();
		//driver.quit();

	}

}
