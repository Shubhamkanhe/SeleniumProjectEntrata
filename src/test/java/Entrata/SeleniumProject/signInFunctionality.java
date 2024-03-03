package Entrata.SeleniumProject;

import org.testng.annotations.Test;

import Utilities.CommonUtility;
import Utilities.NavigationUtility;

public class signInFunctionality {
	@Test()
	public void validateSignInFunctionality()
	{
	CommonUtility.initializeChromeDriver();
	NavigationUtility.navigateToEntrata();
	}
}
