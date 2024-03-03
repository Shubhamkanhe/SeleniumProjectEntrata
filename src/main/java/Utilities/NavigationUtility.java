package Utilities;

import org.openqa.selenium.WebDriver;

public class NavigationUtility {

	public static void navigateToEntrata()
	{
		WebDriver driver=CommonUtility.initializeChromeDriver();
		driver.get("https://www.entrata.com/");
	}
}
