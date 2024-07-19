package Product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;

import Object_Repository.VtigerHomePage;

public class CreateProduct_UsingRepository {
	public static void main(String[] args) throws Throwable {
		
		File_utility flib = new File_utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();

		WebDriver driver;
		String BROWSER = flib.getKeyAndValuePair("browser");
		  if(BROWSER.equalsIgnoreCase("chrome"))
		  {
		 	 driver=new ChromeDriver();
		  }
		  else
		  {
		  if(BROWSER.equalsIgnoreCase("edge"))
		 	 {
		 		 driver=new EdgeDriver();
		 	 }
			 else
		 	 {
		 if(BROWSER.equalsIgnoreCase("firefox"))
		 		{
		 			driver=new FirefoxDriver();
		 		}
		 else
		 		{
		 			driver=new ChromeDriver();
		 		}
		 	 }
		  }
				wlib.maximizingWindow(driver);
				wlib.implicity_Wait(driver);
				

				String URL = flib.getKeyAndValuePair("url");
				String USERNAME =flib.getKeyAndValuePair("username");
		    	String PASSWORD = flib.getKeyAndValuePair("password");
				
				driver.get(URL);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				driver.findElement(By.linkText("Products")).click();
		        driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		        
		        int ranNum = jlib.getRandomNum();
		       String prdData = elib.getExcelData("Product", 0, 0)+ranNum;
				
		        driver.findElement(By.name("productname")).sendKeys(prdData);
		        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				Thread.sleep(3000);
				VtigerHomePage home = new VtigerHomePage(driver);
				home.logOut(driver);
				//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				//driver.findElement(By.linkText("Sign Out")).click();
			}

		}


