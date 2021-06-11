package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.ItemSearchSecond;

public class ItemSearchSecond_Test {
	
	private WebDriver driver;
	ItemSearchSecond itemSearchSecond;

	@Before
	public void setUp() throws Exception {
		itemSearchSecond = new ItemSearchSecond(driver);
		driver = itemSearchSecond.chromeDriverConnection();
		driver.manage().window().maximize();
		itemSearchSecond.getUrl("https://www.amazon.com.mx");
		PageFactory.initElements(driver, itemSearchSecond);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		if (itemSearchSecond.searchItem().equals(itemSearchSecond.storePriceDetail()) ) {
			System.out.println("Prices match");
		} else {
			System.out.println("Prices don't match");
		}
		itemSearchSecond.addToCart();
		assertEquals("Tu carrito de Amazon está vacío.",itemSearchSecond.removeFromCart());
	}

}
