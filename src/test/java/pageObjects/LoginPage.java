package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name ="email")
	@CacheLookup
	WebElement email;
	
	@CacheLookup
	@FindBy(name="password")
	WebElement password;
	
	@CacheLookup
	@FindBy(xpath="/html/body/app-root/app-login/div/mat-card/form/button[2]")
	WebElement btnLogin;	
	
	@FindBy(xpath="/html/body/app-root/app-fundoo-dashboard/app-navbar/html/body/div[1]/mat-toolbar/div[7]")
	WebElement popUpBtn;
	
	@FindBy(name="logout")
	WebElement logoutBtn;
	
	
	public void setEmailAddress(String userEmail)
	{
		email.sendKeys(userEmail);
	}
	public void setPassword(String userPassword)
	{
		password.sendKeys(userPassword);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	
	public void clickOnMenu() {
		popUpBtn.click();
	}

	public void clickLogout() throws InterruptedException
	{
		clickOnMenu();
		Thread.sleep(1000);
		logoutBtn.click();
	}
	
	
}
