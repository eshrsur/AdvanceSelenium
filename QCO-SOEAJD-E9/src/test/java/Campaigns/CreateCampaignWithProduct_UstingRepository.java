package Campaigns;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CampWithPrdWindowSwitching;
import Object_Repository.CreateCampaignPage;
import Object_Repository.CreateProductPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class CreateCampaignWithProduct_UstingRepository {
public static void main(String[] args) throws Throwable {
		
        File_utility flib = new File_utility();	
        Java_Utility jlib = new  Java_Utility();
        Excel_Utility elib = new Excel_Utility();
        WebDriver_Utility wlib = new WebDriver_Utility();
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
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVitigerApp(USERNAME, PASSWORD);
		
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickProductLink();
		
		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickOnPlusSign();
	      
	    int ranNum = jlib.getRandomNum();
	     
	    String prdData = elib.getExcelData("Product", 0, 0)+ ranNum;  
			         
	    prdPage.enterProductName(prdData);
	    prdPage.clickOnSaveButton();
	        
	    home.clickMoreLink();
	    home.clickCampaignsLink();
		
		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.clickOnPlusSign();
	
		String campData = elib.getExcelData("Campaigns", 0, 0)+ranNum;
		campPage.enterCampaignName(prdData);

		CampWithPrdWindowSwitching Switching = new CampWithPrdWindowSwitching(driver);
		Switching.clickOnPrdPlusSign();
		
        wlib.windowHandling(driver, "Products&action");
	    
        Switching.enterPrdName(prdData);
        Switching.searchPrdName();
        
	//  driver.findElement(By.xpath("//a[text()='Bluetooth202']")).click();
	    
	 //   driver.findElement(By.xpath("//a[text()='"+prdData+"']")).click();
        Switching.prdDynamicElement(driver, prdData);
	
	    wlib.windowHandling(driver, "Campaigns&action");
	    
	    campPage.clickOnSaveButton();
			
		Thread.sleep(2000);
		home.logOut(driver);
		}

}


