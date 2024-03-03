package Entrata.SeleniumProject;

import org.testng.annotations.Test;

import Utilities.CommonUtility;


public class signInFunctionality {

	@Test()
	public void validateSignInFunctionality() 
	{
	
	CommonUtility.navigateToEntrata();
	CommonUtility.acceptCookies();
	CommonUtility.clickOnSignInButton();
	CommonUtility.verifyPropertyManagementSignInFunctionality();
	
	}
}
