package DDT;


import java.io.FileOutputStream;
import java.util.Properties;

public class IDTPF {

	public static void main(String[] args) throws Throwable {
		Properties pro = new Properties();
		pro.setProperty("username", "standard_user");
		pro.setProperty("password", "secret_sauce");
		pro.setProperty("url", "https://www.saucedemo.com/v1/");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Propertiesfile.properties");
		pro.store(fos, "CommonData");
		System.out.println("Data written sucessfully");
		

	}

}
