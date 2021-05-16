package appiumtest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class back_01 {

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
	      
	      
	      driver.findElementByXPath("//*[contains(@text,'Views')]").click();
	      driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Spinner\").instance(0))").click();
	      
	      ////io.appium.android.apis:id/spinner2  Earth
	      driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='io.appium.android.apis:id/spinner1']")).click();
	      driver.findElementByXPath("//android.widget.CheckedTextView[@text='orange']").click();
	      
	      driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='io.appium.android.apis:id/spinner2']")).click();
	      driver.findElementByXPath("//android.widget.CheckedTextView[@text='Earth']").click();
	      
	      driver.pressKey(new KeyEvent(AndroidKey.HOME));
	      
	      driver.activateApp("io.appium.android.apis");
	      
	      driver.runAppInBackground(Duration.ofSeconds(5));
	      
	      driver.activateApp("io.appium.android.apis");
	     

	}

}
