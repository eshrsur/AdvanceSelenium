package Generic_Utilities;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Object_Repository.VtigerLoginPage;




public class BaseClass {
	public WebDriver driver;
	public  File_utility flib = new File_utility();
	public  WebDriver_Utility wlib = new WebDriver_Utility();
	public  Excel_Utility elib = new Excel_Utility();
	public  Java_Utility jlib = new Java_Utility();
	
	
	@BeforeSuite
	public void BS() throws Throwable
	{
		
		//Step1:- Register/ load the mysql database
				//Driver driverRef = new Driver();
				//DriverManager.registerDriver(driverRef);
		System.out.println("DataBase Connection Open");
	}
	
	@BeforeTest
	public void BT()
	{
		System.out.println("parallel execution start");
	}
	
	@Test
	public void BC() throws Throwable
	{  
	 
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

		System.out.println("Browser Launched");
	}
	@Parameters("BROWSER")
//@Parameters({"USERNAME","PASSWORD"})
	@BeforeMethod(groups = {"Smoke Test","Regression Test"})
	public void BM() throws Throwable
	{
		wlib.maximizingWindow(driver);
		wlib.implicity_Wait(driver);

		String URL = flib.getKeyAndValuePair("url");
		String USERNAME =flib.getKeyAndValuePair("username");
    	String PASSWORD = flib.getKeyAndValuePair("password");
		
		driver.get(URL);
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVitigerApp(USERNAME, PASSWORD);
		System.out.println("login to application");
	}
	
	@AfterMethod(groups = {"Smoke Test","Regression Test"})
	public void AM()
	{  VtigerHomePage home = new VtigerHomePage(driver);
		home.logOut(driver);
		System.out.println("logout from application");
	}
	@AfterClass(groups = {"Smoke Test","Regression Test"})
	public void AC()
	{
		driver.close();
		System.out.println("close the browser");
	}
	@AfterTest(groups = {"Smoke Test","Regression Test"})
	public void AT()
	{
		System.out.println("parallel execution done");
	}
	@AfterSuite(groups = {"Smoke Test","Regression Test"})
	public void AS() throws Throwable
	{
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_details","root" ,"root");
		//conn.close();
		System.out.println("Data base closed");
	}
}



