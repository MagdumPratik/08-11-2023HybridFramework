package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pr;
	
	public ReadConfig()
	{
		try
		{
			File src=new File(".//Config//Data.properties");
			FileInputStream fis=new FileInputStream(src);
			pr=new Properties();
			pr.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("File not found...........");
		}
	}
	
	public String getApplicationUrl()
	{
		return pr.getProperty("base_UrlBS");
	}
	
	public String getUsername()
	{
		return pr.getProperty("usernameBS");
	}
	
	public String getPassword()
	{
		return pr.getProperty("passwordBS");
	}
	
}
