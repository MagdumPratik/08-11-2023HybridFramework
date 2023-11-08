package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import PageObject.LoginPage;
import Utilities.ReadConfig;
import Utilities.XLUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig rd=new ReadConfig();
	XLUtils xl=new XLUtils();
	WebDriver driver;
	Logger logger;
	LoginPage lp;
	public String baseURL_BS=rd.getApplicationUrl();
	public String username_BS=rd.getUsername();
	public String password_BS=rd.getPassword();
	
	@BeforeClass
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		logger=logger.getLogger("GuruBanking");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Base class setUp method executed");
	}
	
	@AfterClass
	public void tearUp()
	{
		driver.quit();
		logger.info("Base Class tearUp method executed");
	}
	
	public boolean alertIsPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void captureScreenshot() throws IOException
	{
		String fileName=generateFileName();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(fileName));
		System.out.println("Screenshot taken SuccessFully");
	}
	
	  public static String generateFileName(){
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	        LocalDateTime now = LocalDateTime.now();
	        String currentDirectory = System.getProperty("user.dir");
	        String filePath = currentDirectory + "\\Screenshot\\";
	        String fileName = filePath + dtf.format(now) + ".png";
	        return fileName;
	    }
}
