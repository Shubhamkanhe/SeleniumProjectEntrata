package Utilities;

import java.time.Duration;

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
	
	public static void clickOnSignInButton()
	{
		
		WebElement signInButton=driver.findElement(By.xpath("//div[@class='header-desktop-buttons hide-on-mobile']//a[text()='Sign In']"));
		signInButton.click();
	}
	
	public static void navigateToEntrata()
	{
		
		driver.get("https://www.entrata.com/");
		driver.manage().window().maximize();
	}
	
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
	
	public static void acceptCookies()
	{
		WebElement acceptCookies=driver.findElement(By.xpath("//button[@aria-label='Accept cookies']"));
		acceptCookies.click();
	}

}
