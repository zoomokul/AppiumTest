package smartPulsePackage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TestCase02 {

public static void main(String[] args) throws IOException, Exception{
			
			
			 DesiredCapabilities dc = new DesiredCapabilities();

		        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel2"); 
		    	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
		        
		        dc.setCapability("appPackage", "com.foreks.android.epias");
		        dc.setCapability("appActivity", "com.foreks.android.epias.view.splash.SplashActivity");

		        URL url = new URL("http://127.0.0.1:4723/wd/hub");

		        AndroidDriver <WebElement>driver = new AndroidDriver<WebElement>(url, dc);
		        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		        
		        String path="	\r\n"
		        		+ "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.ImageView";
		        // Türkçe menü þecildi.
		        driver.findElementByXPath(path).click();
		        
		        // Tamam týklandý
		        driver.findElementById("com.foreks.android.epias:id/dialogEpiasLanguage_textView_ok").click();
		        

		       for (int i = 0; i < 6; i++) {
		    	   WebElement Panel=driver.findElementById("com.foreks.android.epias:id/layoutOnboarding_imageView");
			        Dimension dimension=Panel.getSize();
			        int Anchor =Panel.getSize().getHeight()/2;
			        Double ScreenWidthStart = dimension.getWidth() * 0.8;
					int scrollStart = ScreenWidthStart.intValue();
					
					Double ScreenWidthEnd = dimension.getWidth() * 0.2;
					int scrollEnd = ScreenWidthEnd.intValue();
					
					new TouchAction((PerformsTouchActions) driver)
					.press(PointOption.point(scrollStart, Anchor))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(scrollEnd, Anchor))
					.release().perform();
			}
		       
		     // devam týklandý.  
		    driver.findElementById("com.foreks.android.epias:id/layoutOnboarding_textView_continue").click();
		    
		    // Ana menu týklandý
		    driver.findElementById("com.foreks.android.epias:id/fragmentHome_imageView_menu").click();
		    
		    //Menü deki tüm elemanlar listeye atýldý
		    List<WebElement> menu=driver.findElementsByClassName("android.widget.TextView");
		    
		   
		    
		    // Tüm elemanlardan piyasalar týklandý
		    for (WebElement each : menu) {
			   
			   if (each.getText().equalsIgnoreCase("Piyasalar")) {
				   each.click();
				   break;
				
			}
			
			 		
		}
		   
		   
		    String ptfxPath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.TextView";
		    
		    // PTF týklandý
		    driver.findElementByXPath(ptfxPath).click();
		    
		    Thread.sleep(3000);
		    driver.findElementById("com.foreks.android.epias:id/layoutEpiasTopSelectionView_imageViewDate").click();
		    
		    WebElement allDate=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout");
		    Dimension allDateDimension=allDate.getSize();
		     
		    int start_x=(int)(allDateDimension.height*0.5);
		    int start_y=(int)(allDateDimension.height*0.8);
		    int end_x=(int)(allDateDimension.width*0.5);
		    int end_y=(int)(allDateDimension.width*0.2);
		     
		    TouchAction touchAction=new TouchAction(driver);
		    touchAction.press(PointOption.point(start_x,start_y)).
		            waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).
		            moveTo(PointOption.point(end_x,end_y)).release().perform();
		    
		    Thread.sleep(2000);
		  
		    //Tamam týklandý
		    driver.findElementById("com.foreks.android.epias:id/layoutFilterDateTime_textView_ok").click(); 
		   
		  
		    Thread.sleep(3000);
		    
		    //Alt Menü deki tüm elemanlar listeye atýldý
		    List<WebElement> altmenuler=driver.findElementsByClassName("android.widget.TextView");
		    

		    
		    // Tüm elemanlardan piyasalar týklandý
		    for (WebElement each : altmenuler) {
			   
			   if (each.getText().equalsIgnoreCase("Günlük")) {
				   each.click();
				   break;
				
			}
			
			 		
		}
		  
		    
		    
		    
		    String ortlamaXpath="	\r\n"
		    		+ "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.TextView[1]";
		    
		    
		    // Ortalama konsola yazdýrýldý
		    String ort=driver.findElementByXPath(ortlamaXpath).getText();
		    System.out.println(driver.findElementByXPath(ortlamaXpath).getText());

                String url2="https://outlook.live.com/owa/";
                System.setProperty("webdriver.chrome.driver", "C:\\seleniumwebdrivers\\s\\chromedriver1.exe");
        		ChromeDriver driver1=new ChromeDriver();
        		driver1.manage().window().maximize();
        		driver1.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        		driver1.get(url2);
        		driver1.findElementByXPath("(//a[@class='internal sign-in-link'])[2]").click();
        		driver1.findElementById("i0116").sendKeys("tester81@outlook.com.tr");
        		driver1.findElementById("idSIButton9").click();
        		driver1.findElementById("i0118").sendKeys("Ankara06");
        		Thread.sleep(3000);
        		driver1.findElementByXPath("//input[@type='submit']").click();
        		driver1.findElementById("idBtn_Back").click();
        		Thread.sleep(3000);
        		driver1.findElementByXPath("//button[@class='ms-Button GJoz3Svb7GjPbATIMTlpL _2W_XxC_p1PufyiP8wuAvwF lZNvAQjEfdlNWkGGuJb7d ms-Button--commandBar PleNk7rXi9dhw_-rxCXnh root-97']").click();
        		String metin="PTF ortalamasý: "+ort;
        		driver1.findElementByXPath("//input[@autocapitalize='off']").sendKeys("analyst.team@smartpulse.io"+Keys.TAB+Keys.TAB+Keys.TAB+"Ahmet BAYAR"+Keys.TAB+metin);
        		//String metin="PTF ortalamasý: "+ort;
        		

        		Thread.sleep(3000);
        		driver1.findElementByXPath("//div[@class='css-213']").click();
        		//driver1.close();

	}

}
