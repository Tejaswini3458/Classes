package rahulshettyacademy.Pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.abstractcomponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
	 
	WebDriver driver;
	
	  @FindBy (css = ".cartSection h3")
	    List<WebElement> cartProducts;
	  //private List<WebElement> cartProducts;
	    
	    @FindBy (css = "tr td:nth-child(3)")
	    List<WebElement> productNames;
	    //private List<WebElement> productNames;
	    
	    public OrderPage(WebDriver driver) { 
	    	//Initialization
	    	      super(driver);
	    	      this.driver=driver;
	    	      PageFactory.initElements(driver,this);
	    	      
	    }
	    
	         public Boolean verifyOrderDisplay(String productName) {
			        Boolean match = productNames.stream()
			                .anyMatch(product -> product.getText().trim().equalsIgnoreCase(productName));
			        return match;
	  }
       }
	         
	         
	        // public Boolean VerifyOrderDisplay(String productName) {
	         //Boolean match = productNames.stream().anyMatch(product->product.getText().
               //equalsIgnoreCase (productName));
                 //return match;

	               // Add findfirst method










			           // If you want to return the first matching product
			              // public WebElement findFirstMatchingProduct(String productName) {
			                 //return productNames.stream()
			                //.filter(product -> product.getText().trim().equalsIgnoreCase(productName))
			                //.findFirst()
			                //.orElse(null);
		