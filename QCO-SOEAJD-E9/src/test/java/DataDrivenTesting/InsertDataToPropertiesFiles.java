package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertDataToPropertiesFiles {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("./src/test/resources/Propertiesfile.properties");
		Properties pro = new Properties();
		
		pro.load(fis);
		
		pro.setProperty("URL", "https://www.saucedemo.com/v1/");
		pro.setProperty("UserName", "standard_user");
		pro.setProperty("PassWord", "secret_sauce");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Propertiesfile.properties");
		pro.store(fos,"CommonData");
		System.out.println("Data added Suceesfully");
		
	//------------------------------------------------------------------------------------------------------
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Propertiesfile.properties");
		Properties pro1 = new Properties();
		pro1.load(fis1);
		String URL1 = pro1.getProperty("URL");
		String USERNAME1 = pro1.getProperty("UserName");
		String PASSWORD1 = pro1.getProperty("PassWord");
		
		WebDriver driver = new ChromeDriver();
		driver .get(URL1);
		driver.findElement(By.name("user-name")).sendKeys(USERNAME1);
		driver.findElement(By.name("password")).sendKeys(PASSWORD1);
		driver.findElement(By.className("btn_action")).click();
		
		driver.close();
		
		

	}

}
