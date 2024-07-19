package Generic_Utilities;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;



public class WebDriver_Utility {
	
	
	public void  maximizingWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void implicity_Wait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
     * pass enter Key appertain in to Browser
     * @param driver
     */
	public void passEnterKey(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	//public void alertAccept(WebDriver driver)
	{
		//driver.switchTo().alert().accept();
	}
	
	public void windowHandling(WebDriver driver, String particalTitle)
	{
		Set<String> wins = driver.getWindowHandles();
		Iterator<String> it = wins.iterator();
		while(it.hasNext())
		{
			String win = it.next();
			driver.switchTo().window(win);
			String currentTitle = driver.getTitle();
			if(currentTitle.contains(particalTitle))
			{
				break;
			
			}
		}
	}

}
