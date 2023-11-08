package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement username;
	
	public void setUsername(String user)
	{
		username.sendKeys(user);
	}
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	public void setPassword(String pass)
	{
		Password.sendKeys(pass);
	}
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement clkLoginButon;
	
	public void clickLoginButton()
	{
		clkLoginButon.click();
	}
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement clkLogoutButon;
	
	public void clickLogoutButton()
	{
		clkLogoutButon.click();
	}
	
	@FindBy(xpath="//marquee[@class='heading3']")
	WebElement successfullMsg;
	
	public String getSuccessfulMsg()
	{
		return successfullMsg.getText();
	}
}
