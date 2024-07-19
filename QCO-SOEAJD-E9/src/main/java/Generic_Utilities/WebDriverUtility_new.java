package Generic_Utilities;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility_new {
	/**
	*it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
	* @param driver
    */
	public void waitForElementInDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	/**
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 */
	public void waitForPage(WebDriver driver , String partailPageURL) 
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.urlContains(partailPageURL));
	}
	
	/**
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @param driver
	 * @param partailPageURL
	 */
	public void waitForElement (WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 *  used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext())
		{
			String wID = it.hasNext();
			driver.switchTo().window(wID);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	
	
	/**
	 * this method is used to accept the alert popup
	 * @param driver
	 */
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	
	/** this method is used to dismiss the alert popup
	 * 
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver Driver , int index)
	{
		Driver.switchTo().frame(index);
	}
	
	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver ,  String id_name_attribute)
	{
		driver.switchTo().frame(id_name_attribute);
	}
	
	
	/**
	 * used to select the value from the dropDwon  based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element , int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * used to select the value from the dropDwon  based on value / option avlaible in GUI
	 * @param element
	 * @param value
	 */
	public void select (WebElement element , String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOverOnElement(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * 	 used to right click  on specified element

	 * @param driver
	 * @param elemnet
	 */
	public void rightClickOnElement(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * 
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver , String JavaScript)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(JavaScript, null);
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
	
	/**
	 * This method is used to move the cursor to a particular element
	 * @param driver
	 * @param ele
	 */
	public void moveToElement(WebDriver driver , WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	

	public void maximizingWindow(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void implicity_Wait(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
