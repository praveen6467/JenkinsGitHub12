   package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass { 
	
	
	 private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	    static Properties p;
	    static Logger logger;

	    public static WebDriver initilizeBrowser() throws IOException {

	        p = getProperties();
	        String browser = p.getProperty("browser").toLowerCase();

	        WebDriver localDriver = null; 

	        switch (browser) {
	            case "chrome":
	                localDriver = new ChromeDriver();
	                break;
	                
	            case "edge":
	                System.setProperty(
	                    "webdriver.edge.driver",
	                    "C:\\Drivers\\Edge\\msedgedriver.exe"
	                );
	                localDriver = new EdgeDriver();
	                break;
	                
	            case "firefox":
	                localDriver = new FirefoxDriver();
	                break;
	            default:
	                System.out.println("No matching browser");
	        }

	        driver.set(localDriver);
	        
	        driver.get().manage().deleteAllCookies();
	        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

	        return driver.get();
	    }

	    public static WebDriver getDriver() {
	        return driver.get();
	    }

/*	    public static void tearDown() {
	        driver.get().quit();
	        driver.remove();
	    } */
	    
	    
	    public static void tearDown() {
	        WebDriver drv = driver.get();
	        if (drv != null) {
	            drv.quit();
	            driver.remove();
	        }
	    }
	    
	    public static Properties getProperties() throws IOException {
	        FileReader file = new FileReader(
	                System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
	        p = new Properties();
	        p.load(file);
	        return p;
	    }

	    public static Logger getLogger() {
	        logger = LogManager.getLogger();
	        return logger;
	    }

	    public static String randomeString() {
	        return RandomStringUtils.randomAlphabetic(5);
	    }

	    public static String randomeNumber() {
	        return RandomStringUtils.randomNumeric(10);
	    }
	
}
