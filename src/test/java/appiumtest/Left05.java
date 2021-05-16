package appiumtest;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Left05 {

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
		  
		  AndroidElement animationButton = driver.findElementByXPath("//android.widget.TextView[@text='Animation']");
	        animationButton.click();
	        Thread.sleep(3000);
	       
	        AndroidElement bouncingBallsButton = driver.findElementByXPath("//android.widget.TextView[@text='Bouncing Balls']");
	        bouncingBallsButton.click();
	        Thread.sleep(3000);
	        
	        
	        Dimension dimensions = driver.manage().window().getSize();
	        System.out.println("Device X and Y are: " + dimensions);
	        
	        Double point = dimensions.getWidth() * 0.45;
	        System.out.println("45% of the screen width will be : " + point);
	        
	        int pointAsAnInteger = point.intValue();
	        System.out.println(pointAsAnInteger);
	        System.out.println(pointAsAnInteger * 2);
	        
	        TouchAction action = new TouchAction(driver);
	        action.press(PointOption.point(0 , pointAsAnInteger))
	        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(5000)))
	        .moveTo(PointOption.point(pointAsAnInteger*2 , pointAsAnInteger))
	        .release()
	        .perform();
	        
	        
	        action.press(PointOption.point(pointAsAnInteger*2 , pointAsAnInteger))
	        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(5000)))
	        .moveTo(PointOption.point( 0, pointAsAnInteger))
	        .release()
	        .perform();
	}

}
