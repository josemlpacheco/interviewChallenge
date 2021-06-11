package example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom.Base;

public class RegisterPage extends Base {
	
	//By registerLinkLocator = By.linkText("REGISTER");
	@FindBy(linkText = "REGISTER")
	WebElement registerLinkLocator;
	
	By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	
	By userNameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	
	By registerBtnLocator = By.name("submit");
	
	By registeredMessage = By.tagName("font");

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	public void registerUser() throws InterruptedException {
		click(registerLinkLocator);
		//registerLinkLocator.click();
		Thread.sleep(2000);
		if (isDisplayed(registerPageLocator)) {
			inputText("test33", userNameLocator);
			inputText("pass1", passwordLocator);
			inputText("pass1", confirmPasswordLocator);
			
			click(registerBtnLocator);
		} else {
			System.out.println("Register page was not found");
		}
	}
	
	public String registeredMessage() {
		List<WebElement> fonts = findElements(registeredMessage);
		return getText(fonts.get(5));
	}

}
