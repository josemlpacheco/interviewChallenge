package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.ItemSearchWithExternalDataSecond;


public class ItemSearchWithExternalDataSecond_Test {
	
	private WebDriver driver;
	ItemSearchWithExternalDataSecond itemSearchWithExternalDataSecond;

	@Before
	public void setUp() throws Exception {
		itemSearchWithExternalDataSecond = new ItemSearchWithExternalDataSecond(driver);
		driver = itemSearchWithExternalDataSecond.chromeDriverConnection();
		driver.manage().window().maximize();
		itemSearchWithExternalDataSecond.getUrl("https://www.amazon.com.mx");
		PageFactory.initElements(driver, itemSearchWithExternalDataSecond);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException, IOException {
		if (itemSearchWithExternalDataSecond.searchItem().equals(itemSearchWithExternalDataSecond.storePriceDetail()) ) {
			System.out.println("Prices match");
		} else {
			System.out.println("Prices don't match");
		}
		itemSearchWithExternalDataSecond.addToCart();
		assertEquals("Tu carrito de Amazon está vacío.",itemSearchWithExternalDataSecond.removeFromCart());
	}

}
