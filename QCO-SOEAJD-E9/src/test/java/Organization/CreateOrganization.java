package Organization;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateOrganization {

	public static void main(String[] args) throws InterruptedException, Throwable {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt=\'Create Organization...']")).click();
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		
		driver.findElement(By.name("accountname")).sendKeys("Surabhi"+ranNum);
		driver.findElement(By.id("phone")).sendKeys("8588960237");
		driver.findElement(By.id("email1")).sendKeys("surabhidipa113@gmail.com");
		driver.findElement(By.xpath("//input[@title= 'Save [Alt+S]']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
		

	}
	

}
