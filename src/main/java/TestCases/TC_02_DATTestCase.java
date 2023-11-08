package TestCases;

import java.io.IOException;

import org.testng.annotations.*;

import PageObject.LoginPage;

public class TC_02_DATTestCase extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user, String passw) throws IOException, InterruptedException
	{
		driver.get(baseURL_BS);
		lp=new LoginPage(driver);
		logger.info("Url open");
		lp.setUsername(user);
		logger.info("Username set");
		lp.setPassword(passw);
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
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String ExcelFilePath=".//LoginData.xlsx";
		int rowcount=xl.getRowCount(ExcelFilePath, "Sheet1");
		int cellcount=xl.getCellCount(ExcelFilePath, "Sheet1", 1);
		
		String[][] loginData=new String[rowcount][cellcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int c=0;c<cellcount;c++)
			{
				loginData[i-1][c]=xl.getCellData(ExcelFilePath, "Sheet1", i, c);
			}
		}
		return loginData;
	}
}
