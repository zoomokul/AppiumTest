package appiumtest;

import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class Scroll05 {

	public static void main(String[] args) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("deviceName", "Pixel2");
		  capabilities.setCapability("platformName", "Android");
		  capabilities.setCapability("platformVersion", "7.0");
		  capabilities.setCapability("udid", "emulator-5554");
		  
		  capabilities.setCapability("appPackage", "io.appium.android.apis");
		  capabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		  
		  
		  URL url = new URL("http://127.0.0.1:4723/wd/hub");
		  
		  AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, capabilities);

	     
	      
	      AndroidElement ViewsButton=driver.findElementByXPath("//*[contains(@text,'App')]");
	      ViewsButton.click();
	      Thread.sleep(2000);
	      
	  	Dimension dimensions = driver.manage().window().getSize();
        Double point = dimensions.getHeight() * 0.45;
        int pointAsAnInteger = point.intValue();
        
        while(true) {
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(0 , pointAsAnInteger*2)) 
        .moveTo(PointOption.point(0 , pointAsAnInteger)) 
        .release()
        .perform();
        
        Thread.sleep(2000);
        
        action.press(PointOption.point(0 , pointAsAnInteger)) 
        .moveTo(PointOption.point(0 , pointAsAnInteger*2)) 
        .release()
        .perform();
        }

	}

}
