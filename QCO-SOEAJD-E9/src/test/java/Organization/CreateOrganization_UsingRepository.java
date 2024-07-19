package Organization;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriverUtility_new;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CreateOrganizationPage;
import Object_Repository.ValidationAndVerificationPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class CreateOrganization_UsingRepository {

	public static void main(String[] args) throws Throwable {
		File_utility flib = new File_utility();
		//WebDriverUtility_new wlib = new WebDriverUtility_new();
		WebDriver_Utility wlib = new WebDriver_Utility();
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		WebDriver driver;
		
		String BROWSER = flib.getKeyAndValueData("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			if(BROWSER.equalsIgnoreCase("edge"))
			{
				driver = new EdgeDriver();
			}
			else
			{
				if(BROWSER.equalsIgnoreCase("firefox"))
				{
					driver = new FirefoxDriver();
				}
				else
				{
					driver = new ChromeDriver();
				}
			}
		}
		wlib.maximizingWindow(driver);
		wlib.implicity_Wait(driver);
		
		String URL = flib.getKeyAndValueData("url");
		String USERNAME = flib.getKeyAndValueData("username");
		String PASSWORD = flib.getKeyAndValueData("password");
		
		driver.get(URL);
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVitigerApp(USERNAME, PASSWORD);
		
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickOrganizationLink();
		
		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
		orgPage.clickPlusImg();
		
		int ranNum = jlib.getRandomNum();
		String orgData = elib.getExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
		String phoneNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
		String emailId = elib.getExcelDataUsingDataFormatter("Organization", 2, 0);
		orgPage.enterOrganizationData(orgData, phoneNum, emailId);
		orgPage.clickOnSaveButton();
		
		ValidationAndVerificationPage orgValid = new ValidationAndVerificationPage(driver);
		orgValid.orgValidation(driver, orgData);
		
		home.logOut(driver);
		
		

	}

}
