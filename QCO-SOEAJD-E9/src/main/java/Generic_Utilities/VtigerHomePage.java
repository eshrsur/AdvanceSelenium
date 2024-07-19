package Generic_Utilities;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class VtigerHomePage {

		public VtigerHomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(linkText = "More")
		private WebElement moreLink;
		
		@FindBy(linkText = "Campaigns")
		private WebElement campaignLink;
		
		@FindBy(linkText = "Organizations")
		private WebElement organizationLink;
		
		@FindBy(linkText = "Products")
		private WebElement productLink;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement admLink;
		
		@FindBy(linkText = "Sign Out")
		private WebElement signOutLink;

		
		public WebElement getMoreLink() {
			return moreLink;
		}

		public WebElement getCampaignLink() {
			return campaignLink;
		}

		public WebElement getOrganizationLink() {
			return organizationLink;
		}

		public WebElement getProductLink() {
			return productLink;
		}

		public WebElement getAdmLink() {
			return admLink;
		}

		public WebElement getSignOutLink() {
			return signOutLink;
		}
	/**
	 * This method is used to click more Link
	 * @author Surabhi
	 */
		public void clickMoreLink()
		{
			moreLink.click();
		}
		
		/**
		 * This method is used to click campaigns Link
		 */
		public void clickCampaignsLink()
		{
			campaignLink.click();
		}
		
		public void clickOrganizationLink()
		{
			organizationLink.click();
		}
		
		public void clickProductLink()
		{
			productLink.click();
		}
		
		public void clickAdmImg()
		{
			admLink.click();
		}
		public void clickOnSignOut()
		{
			signOutLink.click();
		}

		public void logOut(WebDriver driver) {
			// TODO Auto-generated method stub
			
		}
	}
	 


