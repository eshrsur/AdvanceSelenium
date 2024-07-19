package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "\"[alt='Create Organization...']")
	private WebElement plusImg;
	
	@FindBy(name = "accountname")
	private WebElement orgName;
	
	@FindBy(id = "phone")
	private WebElement phoneNum;
	
	@FindBy(id = "email")
	private WebElement emailId;
	
	@FindBy(xpath = "\"//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	/**
	 * @return the plusImg
	 */
	public WebElement getPlusImg() {
		return plusImg;
	}

	/**
	 * @return the orgName
	 */
	public WebElement getOrgName() {
		return orgName;
	}

	/**
	 * @return the phoneNum
	 */
	public WebElement getPhoneNum() {
		return phoneNum;
	}

	/**
	 * @return the emailId
	 */
	public WebElement getEmailId() {
		return emailId;
	}

	/**
	 * @return the saveButton
	 */
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void clickPlusImg()
	{
		plusImg.click();
	}
	
	public void enterOrganizationData(String OrgName, String phnNum, String email)
	{
		orgName.sendKeys(OrgName);
		phoneNum.sendKeys(phnNum);
		emailId.sendKeys(email);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	

}
