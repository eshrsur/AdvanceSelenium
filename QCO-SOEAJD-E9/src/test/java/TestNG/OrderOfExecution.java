package TestNG;

import org.testng.annotations.Test;


public class OrderOfExecution {
	//@Test(priority = 1)
	//@Test
	@Test(invocationCount = 2)
	public void createContactTest()
	{
		System.out.println("Contact Created");
		//.
	}
	//@Test(priority = 0)
	//@Test(dependsOnMethods = "createContactTest")
    //@Test(enabled = false)
	@Test
	public void modifyContactTest()
	{
		System.out.println("Contact Modified");
	}
	//@Test(priority = 2)
	@Test(dependsOnMethods = "createContactTest")
	public void deleteContactTest()
	{
		System.out.println("Contact Deleted");
	}

}
