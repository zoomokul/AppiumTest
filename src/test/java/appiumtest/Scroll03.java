
//============================BAÞARILI==============================================
package appiumtest;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Scroll03 {

	public static void main(String[] args) throws Exception {
		 DesiredCapabilities caps = new DesiredCapabilities();
	      caps.setCapability("deviceName", "pixel2");
	      caps.setCapability("udid", "emulator-5554"); // DeviceId from "adb devices" command
	      caps.setCapability("platformName", "Android");
	      caps.setCapability("platformVersion", "7.0");
	      caps.setCapability("appPackage", "io.appium.android.apis");
	      caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
	      AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      
	      driver.findElementByXPath("//*[contains(@text,'Graphics')]").click();
	      driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Sweep\").instance(0))").click();
	      /*
	      List<MobileElement> elementler=driver.findElementsByClassName("android.widget.TextView");
	      
	      for (int i = 0; i < 14; i++) {
	    	  System.out.println(i+"   "+elementler.get(i).getText());
			
		}
		*/
	      
	      
	      	//driver.findElementByXPath("//*[contains(@text,'Views')]").click();
	      
	      // driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Focus\").instance(0))").click();;
	  
	      //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))").click();
	      //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"TextClock\").instance(0))").click();
	      Thread.sleep(5000);
	      //driver.quit();

	}

}
