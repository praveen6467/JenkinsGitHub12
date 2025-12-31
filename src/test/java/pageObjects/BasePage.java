package pageObjects;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	
	WebDriver driver;    // this Instance variable of BasePage
	
	WebDriverWait wait;                                       // **  EXPLICITY waits 
    
	
/* ****  1 ) You define this below constructor to receive an already-created WebDriver object
      i,e--> driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities); in'BaseClass'
      
	2)---> In BaseClass driver is intilized , and we Declared it as Global STATIC variable i,e 'static WebDriver driver; 
	-----> in BasePage we Declare  'WebDriver driver; it as INSTANCE variable
	 - This 'WebDriver driver; INSTANCE Variable We Are Assigning value by Creating Constructor  in BasePage
	
	  BaseClass.driver → static variable
      BasePage.driver → instance variable
	
--->  BasePage’s instance WebDriver variable is related to BaseClass’s static WebDriver variable 
	because the object reference created in BaseClass is passed to BasePage via constructor; 
	they are two variables pointing to the same browser object.”
	
	
	*/
	
	// Constructor   READ IT
	   public BasePage(WebDriver driver) 
	     {  
		     this.driver=driver;
		     
		     wait = new WebDriverWait(driver, Duration.ofSeconds(10));           // **  EXPLICITY waits 
		     
		     PageFactory.initElements(driver,this);
	     }

	   
	   
	   
	   
	   //1)-------> This Aproach For  EXPLICITY WAIT  // ----> Wait Command Should be in BASEPAGE ONLY
	   
	   public void waitForElementToBeVisible(WebElement element) {
	        wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    public void waitForElementToBeClickable(WebElement element) {
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

	    public void clickWhenReady(WebElement element) {
	        waitForElementToBeClickable(element);
	        element.click();
	    }
	   
	    
	    // Alert
	  
	   public void waitForAlert() {
	        wait.until(ExpectedConditions.alertIsPresent());
	    }

	    public void acceptAlert() {
	        waitForAlert();
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	    }

	    public void dismissAlert() {
	        waitForAlert();
	        Alert alert = driver.switchTo().alert();
	        alert.dismiss();
	    }

	    public String getAlertText() {
	        waitForAlert();
	        Alert alert = driver.switchTo().alert();
	        return alert.getText();
	    }

	    public void sendKeysToAlert(String text) {
	        waitForAlert();
	        Alert alert = driver.switchTo().alert();
	        alert.sendKeys(text);
	        alert.accept();
	    }
	    
	   
	}



















