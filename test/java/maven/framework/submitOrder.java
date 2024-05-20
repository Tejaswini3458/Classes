package maven.framework;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Maaven.TestComponents.BaseTest;
import rahulshettyacademy.Pageobject.CartPage;
import rahulshettyacademy.Pageobject.CheckoutPage;
import rahulshettyacademy.Pageobject.ConfirmationPage;
import rahulshettyacademy.Pageobject.LoginPage;
import rahulshettyacademy.Pageobject.OrderPage;
import rahulshettyacademy.Pageobject.ProductListingPage;

public class submitOrder  extends BaseTest {
	
	@Test
      public void submitOrder() throws InterruptedException {
    	  
		 String productName = "ZARA COAT 3";
		 
		 LoginPage loginpge = new LoginPage(driver);
		 
		 loginpge.gotoSite(); //driver.get("https://rahulshettyacademy.com/client");
		 
		 ProductListingPage plp = loginpge.loginApplication("Tejaswini@test.com", "Test@123");
		 
		  List <WebElement> products =plp.getProductList(); 
		  plp.addproductToCart(productName);
		  
		  CartPage cartpage = plp.goToCartPage();
		  Boolean match = cartpage.verifyProductDisplay(productName);
		  Assert.assertTrue(match);
		  
         CheckoutPage checkoutPage = cartpage.goToCheckout();
	      checkoutPage.selectCountry("India");
	      
		  ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		  String confirmMessage = confirmationPage.getConfirmationMessage();
		  Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	
			
		  //order page method
		     
		  OrderPage orderpage = confirmationPage.goToOrderPage();
				  boolean match1 = orderpage.verifyOrderDisplay(productName);
				  Assert.assertTrue(match1); 
		  
	}
	}