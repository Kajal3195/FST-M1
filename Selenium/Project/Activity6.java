//Verify that the “Directory” menu item is visible and clickable
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void driverSetup() {
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
	}

	@Test
	public void headingMatch() throws InterruptedException {
		wait = new WebDriverWait(driver,50);
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));

		username.sendKeys("orange");
		password.sendKeys("orangepassword123");
		loginButton.click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menu_directory_viewDirectory']")));
		boolean displayElement = driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']")).isDisplayed();
		System.out.println("Element Displayed : "+ displayElement);
		WebElement button = driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", button );	
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='head']"))));
		String title = driver.findElement(By.xpath("//div[@class='head']")).getText();
		System.out.println(title);
		if(title.equals("Search Directory")) {
			System.out.println("Heading Matched");	
		}
		
	}

	@AfterTest
	public void closeDriver() {
		//driver.close();
	}
}