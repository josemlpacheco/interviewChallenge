package example;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCase {
	
	private WebDriver driver; 
	
	@FindBy(linkText = "REGISTER")
	WebElement registerLinkLocator;
	
	//By registerLinkLocator = By.linkText("REGISTER");
	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	By userNameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	
	By registerBtnLocator = By.name("submit");
	
	By userLocator = By.name("userName");
	By passLocator = By.name("password"); 
	By signInBtnLocator = By.name("submit");
	
	By homePageLocator = By.tagName("h3");

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/index.php");
		PageFactory.initElements(driver, this);
	}

	@After
	public void tearDown() throws Exception {
		 driver.quit();
	}

	@Test
	public void registerUser() throws InterruptedException {
		registerLinkLocator.click();
		Thread.sleep(2000);
		if (driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(userNameLocator).sendKeys("test1");
			driver.findElement(passwordLocator).sendKeys("pass1");
			driver.findElement(confirmPasswordLocator).sendKeys("pass1");
			
			driver.findElement(registerBtnLocator).click();
		} else {
			System.out.println("Register page was not found");
		}
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		
		assertEquals("Note: Your user name is test1.", fonts.get(5).getText());
	}
	
	@Test
	public void signIn () throws InterruptedException {
		if (driver.findElement(userLocator).isDisplayed()) {
			driver.findElement(userLocator).sendKeys("test1");
			driver.findElement(passLocator).sendKeys("pass1");
			driver.findElement(signInBtnLocator).click();
			Thread.sleep(2000);
			
			assertTrue(driver.findElement(homePageLocator).isDisplayed());
		} else {
			System.out.println("username textbox was not present");
		}
	}

}
