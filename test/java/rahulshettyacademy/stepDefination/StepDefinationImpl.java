package rahulshettyacademy.stepDefination;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import Maaven.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.Pageobject.CartPage;
import rahulshettyacademy.Pageobject.CheckoutPage;
import rahulshettyacademy.Pageobject.ConfirmationPage;
import rahulshettyacademy.Pageobject.LoginPage;
import rahulshettyacademy.Pageobject.ProductListingPage;

public class StepDefinationImpl  extends BaseTest{

	public LoginPage loginPage;
	public ProductListingPage productListingPage;
    public CartPage cartpage;
    public CheckoutPage checkoutpage;
    public ConfirmationPage confirmationpage;
	
	@Given("I landed on Ecommerce page")
	
	public void I_landed_on_Ecommerce_page() throws IOException {
		loginPage = LaunchApplication();
	}
	@Given ("^Logged in with username(.+) and password (.+)$")
	 public void logged_in_username_and_password(String username, String password) throws InterruptedException {
		productListingPage = loginPage.loginApplication(username, password);
	}
	@When("^I add the product (.+) to the cart$")
			public void i_add_product_to_the_cart(String productName) throws InterruptedException {
			List <WebElement> products =productListingPage.getProductList();
			productListingPage.addproductToCart(productName);
    }
	@When("^Checkout(.+) and submit the order$")
	public void checkout_submit_order(String productName) throws InterruptedException {
		cartpage = productListingPage.goToCartPage();
		Boolean match = cartpage.verifyProductDisplay(productName);
		Thread.sleep(3000);
		//Assert.assertTrue(match);
		
		checkoutpage = cartpage.goToCheckout();
		checkoutpage.selectCountry("India");
		confirmationpage = checkoutpage.submitOrder();
	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_is_displayed_on_ConfirmationPage(String string) {
		String confirmMessage =confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
}
