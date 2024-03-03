package Entrata.SeleniumProject;

import org.testng.annotations.Test;

import Utilities.CommonUtility;

public class validateEntrataLandingPageLogo {
	
	 /*
     * Verify Entrata logo present on the landing page.When user clicks on it should naviagte to entrata enabling efficient operations page.
     */
	@Test()
	public void validateEntrataLogo()   
	{
	
	CommonUtility.navigateToEntrata();
	CommonUtility.acceptCookies();
	CommonUtility.verifyEntrataLogo();
	
	}

}
