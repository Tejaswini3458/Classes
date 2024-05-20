package rahulshettyacademy.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.Pageobject.OrderPage; // Import the OrderPage class
import rahulshettyacademy.abstractcomponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    	}
	
	 @FindBy(css = ".hero-primary")
	    WebElement confirmMessage;
	 
	 //@FindBy(css = ".go-to-order-page-btn")
	 @FindBy(css = "label[routerlink='/dashboard/myorders")
	 WebElement orderLink;

	    public String getConfirmationMessage() {
	        return confirmMessage.getText();
	    }
	    

	    public OrderPage goToOrderPage() throws InterruptedException {
	        // Click on the "Go to Order Page" button
	    	Thread.sleep(2000);
	       orderLink.click();
	        return new OrderPage(driver);
	        
	    }
	}