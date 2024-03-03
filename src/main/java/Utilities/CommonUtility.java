package Utilities;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonUtility {
	
	public static WebDriver initializeChromeDriver()
	{
		WebDriver driver=WebDriverManager.chromedriver().create();
		return driver;
		
	}
	

}
