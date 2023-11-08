package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PageObject.LoginPage;

public class TC_01_LoginTest extends BaseClass{

	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		driver.get(baseURL_BS);
		lp=new LoginPage(driver);
		logger.info("Url open");
		lp.setUsername(username_BS);
		logger.info("Username set");
		lp.setPassword(password_BS);
		logger.info("Password set");
		lp.clickLoginButton();
		if(alertIsPresent()==true)
		{
			driver.switchTo().alert().accept();
			logger.info("Test Case Failecd.....");
			captureScreenshot();
			Thread.sleep(4000);
		}
		else
		{
			logger.info("Next Linnee");
			}
		String expectedMasseg="Welcome To Manager's Page of Guru99 Bank";
		String actualMsg=lp.getSuccessfulMsg();
		if(expectedMasseg.equals(actualMsg))
		{
			logger.info("TEst Case Passed.......");
			lp.clickLogoutButton();
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
		}
		
	}	
	
	
}
