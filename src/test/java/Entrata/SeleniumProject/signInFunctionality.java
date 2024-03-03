package Entrata.SeleniumProject;

import org.testng.annotations.Test;

import Utilities.CommonUtility;


public class signInFunctionality {
	
    /*
     * Validate that when user clicks on sign in and selects Property Manager Login and enters invalid username and password "The username and password provided are not valid. Please try again." appears.
     */
	@Test()
	public void validateSignInFunctionality() 
	{
	
	CommonUtility.navigateToEntrata();
	CommonUtility.acceptCookies();
	CommonUtility.clickOnSignInButton();
	CommonUtility.verifyPropertyManagementSignInFunctionality();
	
	}
}
