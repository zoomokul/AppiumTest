package appiumtest;

import org.openqa.selenium.Dimension;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Scroll02 {

	public static void main(String[] args) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("deviceName", "Pixel2");
		  capabilities.setCapability("platformName", "Android");
		  capabilities.setCapability("platformVersion", "7.0");
		  capabilities.setCapability("udid", "emulator-5554");
		  
		  capabilities.setCapability("appPackage", "com.h6ah4i.android.example.advrecyclerview");
		  capabilities.setCapability("appActivity","com.h6ah4i.android.example.advrecyclerview.launcher.MainActivity");
		  
		  
		  URL url = new URL("http://127.0.0.1:4723/wd/hub");

	      AndroidDriver driver = new AndroidDriver(url, capabilities);
	      
	      List<MobileElement> liste=driver.findElementsByClassName("android.widget.TextView");
	      
	      System.out.println(liste.size());
	      
	      // xpath kullanýmý
	      driver.findElementByXPath("//android.widget.TextView[@text='SWIPE']").click();
	      
	      driver.findElementByXPath("//android.widget.Button[@text='SWIPEABLE (MINIMAL)']").click();
	     // driver.findElementByXPath("//android.widget.Button[contains(@text,'SWIPEABLE (MINIMAL)')]").click();
	      
	     // System.out.println(driver.manage().window().getSize());  
	      
	      Dimension dimension=driver.manage().window().getSize();
	      
	      int startx=(int)((dimension.width)*0.5);
	     //System.out.println(startx);  540
	      int starty=(int)((dimension.height)*0.2);
	     // System.out.println(starty);  1435
	      int endx=(int)((dimension.width)*0.5);
	      int endy=(int)((dimension.height)*0.8);
	      //System.out.println(endy);  358
	     
	     
	      TouchAction touch=new TouchAction(driver);
	      touch.press(PointOption.point(startx, starty))
	     .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(endx, endy)).release().perform();
	    
	     
	
	      
	   
	     
	      /*
	     for (int i = 0; i <liste.size(); i++) {
	    	 System.out.println(liste.get(i).getText());
			
		}
		*/
		
	      
	
	      /*
	      for (MobileElement e : liste) {
			System.out.println(e.getAttribute("text")+" "+e.getId());
	    	 // System.out.println(e.getId());
	    	  //System.out.println(e.getText());
	    	  /*
	    	  if (e.getText().equalsIgnoreCase("SWIPE")) {
				e.click();
				
			}
			
	    	  
		}
	      
	      */
	     

	}



}
