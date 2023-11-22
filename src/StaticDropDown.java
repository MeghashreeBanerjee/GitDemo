import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class StaticDropDown {

	public static void main(String[] args) throws InterruptedException 
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		  
		  ///* Checkboxes *///
		  Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		 // System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()); //checking if checkbox is selected or not
		  driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click(); 
		 // driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click(); // when selected student, I couldn't choose loop dropdown for infant and child. it was disabled
		  Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		  //checking the size of checkbox OR how many checkboxes are there in that page with common locator
		  System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		  
		  
		  ///* CURRENCY DROPDOWN: STATIC DROPDOWN */
		 WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		  Select dropdown = new Select(staticDropdown);
		  
		  dropdown.selectByIndex(3);
		  System.out.println(dropdown.getFirstSelectedOption().getText());
		  dropdown.selectByVisibleText("AED");
		  System.out.println(dropdown.getFirstSelectedOption().getText());
		  dropdown.selectByValue("INR");
		  System.out.println(dropdown.getFirstSelectedOption().getText());  
		  
///* PASSENGER DROPDOWN :::: Updated lecture on latest Dropdown looping UI */
		  
		  driver.findElement(By.id("divpaxinfo")).click();
		  Thread.sleep(2000);
		 // System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		  for(int i = 1; i<4;i++)
		  {
		  driver.findElement(By.id("hrefIncAdt")).click();
		  }
		  //System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		  for(int j=0;j<2;j++)
		  {
		  driver.findElement(By.id("hrefIncChd")).click();
		  }
		  for(int j=0;j<2;j++)
		  {
		  driver.findElement(By.id("hrefIncInf")).click();
		  }
		  System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		  driver.findElement(By.cssSelector("input#btnclosepaxoption")).click();
		  Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"4 Adult, 2 Child, 2 Infant");
		  driver.close();

	}

}
