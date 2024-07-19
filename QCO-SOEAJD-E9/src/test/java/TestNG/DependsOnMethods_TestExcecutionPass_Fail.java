package TestNG;

import org.testng.annotations.Test;

public class DependsOnMethods_TestExcecutionPass_Fail {
	@Test
	public void createContact()
	{
	int[]arr= {1,2,3};
	System.out.println(arr[3]);
	System.out.println("contact created");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void modifyContact()
	{
		System.out.println("modify contact");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void deleteContact()
	{
		System.out.println("delete contact");
	}
	

}
