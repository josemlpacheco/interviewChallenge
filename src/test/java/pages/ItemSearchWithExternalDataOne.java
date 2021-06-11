package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom.Base;

public class ItemSearchWithExternalDataOne extends Base {
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(xpath = "//span[.='\"iphone 12 pro max\"']")
	WebElement searchPageLocator;
	
	By itemLocator = By.xpath("//div[@class='s-expand-height s-include-content-margin s-border-bottom s-latency-cf-section']//span[@class='a-size-base-plus a-color-base a-text-normal']");
	By priceItemLocator = By.xpath("//div[@class='s-expand-height s-include-content-margin s-border-bottom s-latency-cf-section']//span[@class='a-offscreen']");
	By priceNumber = By.xpath("//span[@class='a-price-whole']");
	By priceDecimal = By.xpath("//span[@class='a-price-fraction']");
	By priceDetail = By.id("priceblock_ourprice");
	By productTitle = By.id("productTitle");
	By addToCartLocator = By.id("add-to-cart-button");
	By shoppingCartLocator = By.xpath("//a[@href='https://www.amazon.com.mx/gp/cart/view.html?ref_=nav_cart']");
	By removeBtn = By.xpath("//input[@type='submit']");
	By productRemoved = By.xpath("//h1[@class='a-spacing-mini a-spacing-top-base']");
	By closeWindow = By.xpath("//a[@id='attach-close_sideSheet-link']");
	
	public ItemSearchWithExternalDataOne(WebDriver driver) {
		super(driver);
	}
	
	public String searchItem() throws InterruptedException, IOException {
		FileInputStream fs = new FileInputStream("D:\\file.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
		
		inputText((sheet.getRow(0).getCell(0).getStringCellValue()), searchBox);
		searchBox.submit();
		Thread.sleep(2000);
		String price="";
		if (isDisplayed(searchPageLocator)) {
			List<WebElement> items = findElements(itemLocator);
			price = storeNameItem();
			items.get(0).click();
		}
		return price;
	}
	
	public String storeNameItem() throws InterruptedException {
		List<WebElement> prices = findElements(priceNumber);
		List<WebElement> priceDecimals = findElements(priceDecimal);
		return "$"+getText(prices.get(0))+"."+getText(priceDecimals.get(0));
	}
	
	public String storePriceDetail() throws InterruptedException {
		Thread.sleep(2000);
		return getText(priceDetail);
	}
	
	public String productTitle() {
		return getText(productTitle);
	}
	
	public void addToCart() throws InterruptedException {
		click(addToCartLocator);
		Thread.sleep(2000);
		click(closeWindow);
		Thread.sleep(2000);
		click(shoppingCartLocator);
	}
	
	public String removeFromCart() throws InterruptedException {
		List<WebElement> btns = findElements(removeBtn);
		btns.get(6).click();
		Thread.sleep(2000);
		return getText(productRemoved);
		
	}
	
}
