package Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonUtility {
	static WebDriver driver=WebDriverManager.chromedriver().create();
	
	/*
	 * Clicks on Sign in button.
	 */
	
	public static void clickOnSignInButton()
	{
		
		WebElement signInButton=driver.findElement(By.xpath("//div[@class='header-desktop-buttons hide-on-mobile']//a[text()='Sign In']"));
		signInButton.click();
	}
	
	/*
	 * Used to navigate to Entrata site.
	 */
	
	public static void navigateToEntrata()
	{
		
		driver.get("https://www.entrata.com/");
		driver.manage().window().maximize();
	}
	
	/*
	 * Verify when user enters invalid username and password in Property Manager Login The username and password provided are not valid. Please try again message is displayed
	 */
	public static void verifyPropertyManagementSignInFunctionality() 
	{
		String expectedResult="The username and password provided are not valid. Please try again.";
		Actions a=new Actions(driver);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement productText=driver.findElement(By.xpath("//div[@class='product-text']"));
		wait.until(ExpectedConditions.visibilityOf(productText));
		WebElement propertyManagementButton=driver.findElement(By.xpath("//a[@title='Client Login Button']"));
		a.moveToElement(propertyManagementButton).click().build().perform();
		WebElement username=driver.findElement(By.xpath("//input[@name='company_user[username]']"));
		username.sendKeys("Shubham Kanhe");
		WebElement password =driver.findElement(By.xpath("//input[@name='company_user[password]']"));
		password.sendKeys("P@ssw0rd");
		WebElement signInButton=driver.findElement(By.xpath("//button[text()='Sign In']"));
		signInButton.click();
		WebElement statusMessage=driver.findElement(By.xpath("//div[@class='login-errors']/p"));
		System.out.println(statusMessage.getText());
		Assert.assertEquals(statusMessage.getText(), expectedResult);
		
	}
	
	/*
	 * Used to Accept the cookies.
	 */
	public static void acceptCookies()
	{
		WebElement acceptCookies=driver.findElement(By.xpath("//button[@aria-label='Accept cookies']"));
		acceptCookies.click();
	}
	
	/*
	 * Navigate to Terms Of Use link present in the bottom of the website and verify on clicking on terms of use the url consist of terms of use in it.
	 */
	public static void navigateToTermsOfUse()  
	{
		
		WebElement termsOfUse=driver.findElement(By.xpath("//a[@title='Entrata Inc. Terms of Use']"));
		Actions a =new Actions(driver);
		a.moveToElement(termsOfUse).click().build().perform();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		String termsOfUseUrl=driver.getCurrentUrl();
		System.out.println("Current URL IS "+termsOfUseUrl);
		Boolean termsOfUsePresentInLink=termsOfUseUrl.contains("terms-of-use");
		Assert.assertTrue(termsOfUsePresentInLink, "URL Contains Terms Of Use in it");
		
		
	}
	/*
	 * Naviagte to base camp and then click on entrata logo it should navigate us to entrata landing page.
	 */
	public static void verifyEntrataLogo()
	{
		WebElement baseCamp=driver.findElement(By.xpath("//div[@class='header-nav-item']/a[text()='Base Camp']"));
		baseCamp.click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		WebElement entrataLogo=driver.findElement(By.xpath("//a[@href='https://www.entrata.com']"));
		entrataLogo.click();
		WebElement efficientOperationsHeader=driver.findElement(By.xpath("//div[@class='hero-left']/h1[text()='Enabling efficient operations']"));
		Boolean result=efficientOperationsHeader.isDisplayed();
		Assert.assertTrue(result, "Enabling Efficient Operations header got displayed");
	}

}
