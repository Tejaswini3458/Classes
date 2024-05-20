package rahulshettyacademy.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.Pageobject.CartPage;
import rahulshettyacademy.Pageobject.OrderPage;



public abstract class AbstractComponents {
WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	@FindBy (css = "[routerlink*='myorders']")
	WebElement orderHeader;

	public void waitForElementToAppear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public CartPage goToCartPage() throws InterruptedException {
		cartHeader.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	
	public OrderPage goToOrdersPage() throws InterruptedException {
	    orderHeader.click();
		OrderPage ordersPage = new OrderPage(driver);
		return ordersPage;
	}
	
	public void waitForElementToDisappear (WebElement ele) throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(ele));
	//Thread.sleep (1000);
	// Or use Thread.sleep (1000) to speed up the execution process
	}
   }

//	  public void waitForElementToDisappear(WebElement ele) {
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	        wait.until(ExpectedConditions.invisibilityOf(ele));
//	    }
//
//	    public CartPage goToCartPage() {
//	        cartHeader.click();
//	        return new CartPage(driver);
//	    }
//
//	    public OrderPage goToOrdersPage() {
//	        orderHeader.click();
//	        return new OrderPage(driver);
//	    
	
  