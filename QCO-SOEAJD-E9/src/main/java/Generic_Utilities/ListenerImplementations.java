package Generic_Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementations implements ITestListener  {
	ChromeDriver driver = new ChromeDriver();
	public void onTestFailure(ITestResult result)
	
	{
	TakesScreenshot srcShot = ((TakesScreenshot)driver);
	File src = srcShot.getScreenshotAs(OutputType.FILE);
	File dest = new File ("./Screenshot/"+".png");
	try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
