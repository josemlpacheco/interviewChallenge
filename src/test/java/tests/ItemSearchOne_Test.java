package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.ItemSearchOne;

public class ItemSearchOne_Test {
	
	private WebDriver driver;
	ItemSearchOne itemSearchOne;

	@Before
	public void setUp() throws Exception {
		itemSearchOne = new ItemSearchOne(driver);
		driver = itemSearchOne.chromeDriverConnection();
		driver.manage().window().maximize();
		itemSearchOne.getUrl("https://www.amazon.com.mx");
		PageFactory.initElements(driver, itemSearchOne);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		
		if (itemSearchOne.searchItem().equals(itemSearchOne.storePriceDetail()) ) {
			System.out.println("Prices match");
		} else {
			System.out.println("Prices don't match");
		}
		itemSearchOne.addToCart();
		assertEquals("Tu carrito de Amazon está vacío.",itemSearchOne.removeFromCart());
	}

}
