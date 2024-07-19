package DDT;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RDFPF {
	public static void main(String[] args) throws Throwable
	{
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	
	FileInputStream fis = new FileInputStream("./src/test/resources/Propertiesfile.properties");

//step2:-Create an object to properties class to load all the keys	
	Properties pro = new Properties();
	pro.load(fis);
	
//step3:-
	String URL = pro.getProperty("url");
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");
	
	driver.get(URL);
	driver.findElement(By.id("user-name")).sendKeys(USERNAME);
	driver.findElement(By.id("password")).sendKeys(PASSWORD);
	driver.findElement(By.id("login-button")).click();
	
	

}
}
