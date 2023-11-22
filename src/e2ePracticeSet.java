import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class e2ePracticeSet {

	public static void main(String[] args) throws InterruptedException 
	{
		  System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		  
		//=============================================================================================//
		//===========AutoSuggestive Dropdown: typing keyword, dropdown opens with suggestion===========//
		  
          driver.findElement(By.id("autosuggest")).sendKeys("ind");
		  Thread.sleep(3000);
		  List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		  for(WebElement opt :options)
		  {
			  if(opt.getText().equalsIgnoreCase("India"))
			  {
				  opt.click();
				  break;
			  }

		  }
		  
       //==============================================================================================//
	   //==============================================================================================//  
	   //=================== Dynamic Dropdown: Selecting To and From destination ======================// 
		  
		  driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		  System.out.println( driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getText());
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//a[@value='HBX']")).click();
		  Thread.sleep(4000);
		  // driver.findElement(By.xpath("(//a[@value='CCU'])[2]")).click();
		  //driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='CCU']")).click();
		  driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		  
		//==============================================================================================//
	    //==============================================================================================//  
		//==============Chapter 63: choosing or selecting current date as departure date================//
		  
			 driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
			 
	    //==============================================================================================//
	    //==============================================================================================//
        //===================== Radio button clicked for round trip ===================================//
			 
			/*	 System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
					 driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
					 System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled()); */
					 
					 
					 driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
					 if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
					 	{
						 System.out.println("Enabled");
						 Assert.assertTrue(true);
					 	}
					 else
					    {
						 System.out.println("Disabled");
						 Assert.assertTrue(false);
					 	}
			
		 
		  //==============================================================================================//
		  //==============================================================================================// 
		  ///======================================= Checkboxes for Discount=============================///
		  
		  Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		 // System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected()); //checking if checkbox is selected or not
		  driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click(); 
		 // driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click(); // when selected student, I couldn't choose loop dropdown for infant and child. it was disabled
		  Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		  //checking the size of checkbox OR how many checkboxes are there in that page with common locator
		  System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		  
		//==============================================================================================//
		//==============================================================================================//
        ///============ PASSENGER DROPDOWN :::: Updated lecture on latest Dropdown looping UI ===========//
		  
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
		  
		//==============================================================================================//
		//==============================================================================================//
		//========================= CURRENCY DROPDOWN: STATIC DROPDOWN ============================//
			 WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
			 Select dropdown = new Select(staticDropdown);
			  
			  dropdown.selectByIndex(3);
			  System.out.println(dropdown.getFirstSelectedOption().getText());
			  dropdown.selectByVisibleText("AED");
			  System.out.println(dropdown.getFirstSelectedOption().getText());
			  dropdown.selectByValue("INR");
			  System.out.println(dropdown.getFirstSelectedOption().getText());  
		  
			//==============================================================================================//
			//==============================================================================================//
		  
		 driver.close(); 
		  
	}

}
