package Object_Repository;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "\"//img[@alt='Create Campaign...']")
	private WebElement plusSign;
	
	@FindBy(name = "campaignname")
	private WebElement campName;
	
	@FindBy(xpath = "\"//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public void clickOnPlusSign1()
	{
		plusSign.click();
	}
	
	

	/**
	 * @return the plusSign
	 */
	public WebElement getPlusSign() {
		return plusSign;
	}

	/**
	 * @return the campName
	 */
	public WebElement getCampName() {
		return campName;
	}

	/**
	 * @return the saveButton
	 */
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void clickOnPlusSign()
	{
		plusSign.click();
	}
	
	public void enterCampaignName(String campaignName)
	{
		campName.sendKeys(campaignName);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	

}
