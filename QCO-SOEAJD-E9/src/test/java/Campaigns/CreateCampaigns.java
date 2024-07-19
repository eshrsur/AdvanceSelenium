package Campaigns;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.VtigerHomePage;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CreateCampaignPage;
import Object_Repository.VtigerLoginPage;

public class CreateCampaigns {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		
        File_utility flib = new File_utility();
        WebDriver_Utility wlib = new WebDriver_Utility();
        Excel_Utility elib = new Excel_Utility();
        Java_Utility jlib = new Java_Utility();
       
        WebDriver drive;
      String BROWSER = flib.getKeyAndValueData("browser");
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
       String URL = flib.getKeyAndValueData("url");
	   String USERNAME =flib.getKeyAndValueData("username");
   	   String PASSWORD = flib.getKeyAndValueData("password");
		
		driver.get(URL);
//		driver.findElement(http://By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(http://By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(http://By.id("submitButton")).click();
		
		VtigerLoginPage login = new VtigerLoginPage(driver);
//		login.getUserTextField().sendKeys(USERNAME);
//       login.getPasswWordTextField().sendKeys(PASSWORD);
//       login.getLoginButton().click();
		
		login.loginToVitigerApp(USERNAME, PASSWORD);
		
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickCampaignsLink();
		
		CreateCampaignPage campPage = new CreateCampaignPage(driver);
        campPage.clickOnPlusSign();
       
		
		//driver.findElement(By.linkText("More")).click();
		//driver.findElement(By.linkText("Campaigns")).click();
		
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

		int ranNum = jlib.getRandomNum();
		
        String campData = elib.getExcelDataUsingDataFormatter("Campaigns", 0, 0)+ranNum;
        campPage.enterCampaignName(campData);
	    campPage.clickOnSaveButton();
		
		//driver.findElement(By.name("campaignname")).sendKeys(campData);
		
       // driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();
		
		home.clickAdmImg();
		home.clickOnSignOut();
	}


	}


