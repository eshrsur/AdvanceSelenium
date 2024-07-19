package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_utility {
	
	/**
	 * This Method is used for login to application
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author Shobha
	 */
	public String getKeyAndValueData(String key) throws Throwable
	{
	 FileInputStream fis = new FileInputStream("./src/test/resources/Vtiger.properties");
	 Properties pro = new Properties();
	 pro.load(fis);
	 String Value = pro.getProperty(key);
	 return Value;
	}

	public String getKeyAndValuePair(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getBROWSER()
	{
		Properties prop = null;
		if(prop.getProperty("browser") == null)
			return" ";
		return prop.getProperty("browser");
	}

	
}


