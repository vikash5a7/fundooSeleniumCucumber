package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	WebDriver ldriver;
	public SignUpPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="registration")
	WebElement registrationBtn;
	
	@FindBy(name="fname")
	WebElement fname;
	
	@FindBy(name="lname")
	WebElement lname;
	
	@FindBy(name="email")
	WebElement email; 
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(name="mobileNumber")
	WebElement phoneNumber;
	
	
	@FindBy(id="registrationBtn")
	WebElement registrationSubmitBtn;
	
	
	
	public void registrationBtn() {
		registrationBtn.click();
	}
	
	public void setFirstName(String userFname)
	{
		fname.sendKeys(userFname);
	}
	
	public void setLastName(String userLastName)
	{
		lname.sendKeys(userLastName);
	}
	
	public void setEmail(String userEmail)
	{
		email.sendKeys(userEmail);
	}
	
	public void SetPassword(String userPassword)
	{
		password.sendKeys(userPassword);
	}
	
	public void setConfirmationPassword(String userConfirmationPassword)
	{
		confirmPassword.sendKeys(userConfirmationPassword);
	}
	public void setUserPhoneNumber(String userPhoneNumber)
	{
		phoneNumber.sendKeys(userPhoneNumber);
	}
	
	
	public boolean isDisabledBtn() {
		return registrationSubmitBtn.isEnabled();
	}
	
	public void clickOnSubmitBtn() {
		registrationSubmitBtn.click();
	}
	
}
