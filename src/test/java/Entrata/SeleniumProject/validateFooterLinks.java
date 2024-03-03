package Entrata.SeleniumProject;

import org.testng.annotations.Test;

import Utilities.CommonUtility;

public class validateFooterLinks {
	 /*
     * Verify Terms of Use in Entrata website.
     */
	@Test()
	public void validateTermsOfUseFooterLink()  
	{
	
	CommonUtility.navigateToEntrata();
	CommonUtility.acceptCookies();
	CommonUtility.navigateToTermsOfUse();
	
	
	}

}
