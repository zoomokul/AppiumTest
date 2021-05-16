
//============================BAÞARILI==============================================
package appiumtest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Scroll01 {
	
	/*
	 * 	1-First we will open API Demos App, 
		2-Tap on "Views".
		3-On next screen, Scroll down till element which contain text "Tabs".
		4-And tap on element which contain text "Tabs". 
	 */

	public static void main(String[] args) throws Exception  {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("deviceName", "Pixel2");
		  capabilities.setCapability("platformName", "Android");
		  capabilities.setCapability("platformVersion", "7.0");
		  capabilities.setCapability("udid", "emulator-5554");
		  
		  capabilities.setCapability("appPackage", "io.appium.android.apis");
		  capabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		  
		  
		  URL url = new URL("http://127.0.0.1:4723/wd/hub");
		  
		  AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, capabilities);

	     
	      //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	      AndroidElement ViewsButton=driver.findElementByXPath("//*[contains(@text,'Views')]");
	      ViewsButton.click();
	      
	      	Dimension dimensions = driver.manage().window().getSize();
	        Double point = dimensions.getHeight() * 0.45;
	        int pointAsAnInteger = point.intValue();
	        
	        //System.out.println(point);
	        //System.out.println(pointAsAnInteger); //807
	        
	        int spinner_Count = driver.findElements(By.xpath("//android.widget.TextView[@text='Spinner']")).size();
	        System.out.println("Spinner count is : " + spinner_Count);
	        /*
	        File file  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(file, new File("C:/temp/bir.jpg"));
	        
	        TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(0 , pointAsAnInteger * 2)) //1600
            .moveTo(PointOption.point(0 , pointAsAnInteger)) //800
            .release()
            .perform();
            File file1  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(file1, new File("C:/temp/iki.jpg"));
            
            Thread.sleep(2000);	 
            action.press(PointOption.point(0 , pointAsAnInteger * 2))
            .moveTo(PointOption.point(0 , pointAsAnInteger))
            .release()
            .perform();
            
            File file2  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(file2, new File("C:/temp/uc.jpg"));
	        */
	        
	        do { 
	        	TouchAction action = new TouchAction(driver);
	            action.press(PointOption.point(0 , pointAsAnInteger * 2))
	            .moveTo(PointOption.point(0 , pointAsAnInteger))
	            .release()
	            .perform();
	        	spinner_Count = driver.findElements(By.xpath("//android.widget.TextView[@text='Spinner']")).size();
	        	System.out.println("Spinner count is : " + spinner_Count);
	        } while(spinner_Count==0);
	 
	      
	      
	        AndroidElement spinnerButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Spinner']"));
	        spinnerButton.click();
	        Thread.sleep(5000);
	   
		  
	
	      System.out.println("Succesfully");

	}

}
