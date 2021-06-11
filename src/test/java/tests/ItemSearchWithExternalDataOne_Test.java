package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.ItemSearchWithExternalDataOne;


public class ItemSearchWithExternalDataOne_Test {
	
	private WebDriver driver;
	ItemSearchWithExternalDataOne itemSearchWithExternalDataOne;

	@Before
	public void setUp() throws Exception {
		itemSearchWithExternalDataOne = new ItemSearchWithExternalDataOne(driver);
		driver = itemSearchWithExternalDataOne.chromeDriverConnection();
		driver.manage().window().maximize();
		itemSearchWithExternalDataOne.getUrl("https://www.amazon.com.mx");
		PageFactory.initElements(driver, itemSearchWithExternalDataOne);
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException, IOException {
		if (itemSearchWithExternalDataOne.searchItem().equals(itemSearchWithExternalDataOne.storePriceDetail()) ) {
			System.out.println("Prices match");
		} else {
			System.out.println("Prices don't match");
		}
		itemSearchWithExternalDataOne.addToCart();
		assertEquals("Tu carrito de Amazon está vacío.",itemSearchWithExternalDataOne.removeFromCart());
	}

}
