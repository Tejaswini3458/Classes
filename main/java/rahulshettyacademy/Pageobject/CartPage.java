package rahulshettyacademy.Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import rahulshettyacademy.abstractcomponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;
	
	@FindBy (css = ".totalRow button")
	WebElement checkoutEle;
	
	@FindBy (css = ".cartSection h3")
	private List<WebElement> cartProducts;
	
	public CartPage(WebDriver driver) {
		super (driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public Boolean verifyProductDisplay(String ProductName) throws InterruptedException {
		Thread.sleep(2000);
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	public CheckoutPage goToCheckout() {
		checkoutEle.click();
		CheckoutPage checkout = new CheckoutPage (driver);
		return checkout;
	}
}
