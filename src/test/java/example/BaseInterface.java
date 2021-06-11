package example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface BaseInterface {
	public WebDriver chromeDriverConnection();
	public WebElement findElement(By locador);
	public List<WebElement> findElements(By locator);
	public String getText(WebElement element);
	public String getText(By locator);
	public void inputText(String inputText, By locator);
	public void click(By locator);
	public void click(WebElement element);
	public Boolean isDisplayed(By locator);
	public void getUrl(String url);
}
