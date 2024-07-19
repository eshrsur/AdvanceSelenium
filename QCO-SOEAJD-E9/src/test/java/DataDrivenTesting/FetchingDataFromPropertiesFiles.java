package DataDrivenTesting;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;


public class FetchingDataFromPropertiesFiles {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\Surtush\\OneDrive\\Documents\\Propertiesfile.properties");
		FileInputStream fis = new FileInputStream("./src/test/resources/Propertiesfile.properties");
		Properties pro = new Properties();
		
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver .get(URL);
		driver.findElement(By.name("user-name")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.className("btn_action")).click();
		

	}

}
