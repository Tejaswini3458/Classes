package Maaven.TestComponents;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.Pageobject.LoginPage;

public class BaseTest {
    public WebDriver driver;
    //public LoginPage loginpge; add when before annotation is used
    
    public WebDriver initializeDriver  ()throws IOException{
    	Properties prop = new Properties();
    	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//rahulshettyacademy//resources//GlobalProperties.properties");
    	prop.load(fis);
    	String browserName = prop.getProperty("browser");
    	if (browserName.equalsIgnoreCase("chrome"))
    	{
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
    		}
    	else if (browserName.equalsIgnoreCase("fireFox")) {
             WebDriverManager.firefoxdriver().setup();
              driver = new FirefoxDriver();
    	}
    	else if (browserName.equalsIgnoreCase("edge")) {
    		WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
    	}
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.manage().window().maximize();
    	return driver;
    }
    
    @BeforeMethod
    public LoginPage LaunchApplication ()throws IOException {
    	driver = initializeDriver();
    	LoginPage loginpge = new LoginPage(driver);
    	loginpge.gotoSite();
    	return loginpge;
    }
    @AfterMethod
    public void close() {
    	driver.close();
    }
    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File (System.getProperty("user.dir")+ "//reports" + testCaseName + ".png");
		FileUtils.copyFile(source,file);	
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
    
  }
