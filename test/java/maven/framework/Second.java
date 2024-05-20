
package maven.framework;
import java.time.Duration;

import java.util.List;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;



import Maaven.TestComponents.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.Pageobject.CartPage;
import rahulshettyacademy.Pageobject.CheckoutPage;
import rahulshettyacademy.Pageobject.ConfirmationPage;
import rahulshettyacademy.Pageobject.LoginPage;
import rahulshettyacademy.Pageobject.OrderPage;
import rahulshettyacademy.Pageobject.ProductListingPage;
import rahulshettyacademy.abstractcomponents.AbstractComponents;




public class Second  extends BaseTest {
	
	public static void main (String args[]) throws InterruptedException {	

		  String productName = "IPHONE 13 PRO";
		  //launchApplication();
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		  LoginPage loginpge = new LoginPage(driver); 
	
		  
	      loginpge.gotoSite(); //driver.get("https://rahulshettyacademy.com/client");
	      
		  ProductListingPage plp = loginpge.loginApplication("Tejaswini@test.com", "Test@123");
		  
		  List <WebElement> products =plp.getProductList();
		  plp.addproductToCart(productName);
//		  
		  CartPage cartpage = plp.goToCartPage();
		  Boolean match = cartpage.verifyProductDisplay(productName);
		  Assert.assertTrue(match);
//		  
          CheckoutPage checkoutPage = cartpage.goToCheckout();
	      checkoutPage.selectCountry("India");
//	      
		  ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		  String confirmMessage = confirmationPage.getConfirmationMessage();
		  Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	
//			
//		  //order page method
		  
		  OrderPage orderpage = confirmationPage.goToOrderPage();
				  boolean match1 = orderpage.verifyOrderDisplay(productName);
				  Assert.assertTrue(match1); 
		  
	}
	}
