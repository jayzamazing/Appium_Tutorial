import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Exerci extends base {
	@Test
	public void test() throws MalformedURLException, InterruptedException{
		File appDir = new File("src/main/java");
		File app = new File(appDir, "Raaga.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		//Device or emulator depending on which you want to test
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "1000");
		//launch app with specific package name
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.Button[@text='LATER']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Done']").click();
		driver.findElementById("com.raaga.android:id/landing_skip_to_raaga").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='World Music']").click();
		Thread.sleep(3000);
		TouchAction t = new TouchAction(driver);
//		t.press(driver.findElement(By.xpath("//android.widget.TextView[@text='NEW RELEASES']"))).waitAction(Duration.ofMillis(3000)).moveTo(driver.findElement(By.xpath("//android.widget.TextView[@text='TRENDING']"))).release().perform();
		Thread.sleep(3000);
		MobileElement element1 = driver.findElement(By.xpath("//android.widget.TextView[@text='NEW RELEASES' and @index ='0']"));
		MobileElement element2 = driver.findElement(By.xpath("//android.widget.TextView[@text='INSTRUMENTAL' and @index ='0']"));
		t.press(element2).waitAction(Duration.ofSeconds(5)).moveTo(element1).release().perform();
		WebElement abc = driver.findElement(By.xpath("//android.widget.TextView[@text='TRENDING']"));
		t.tap(abc).perform();
		Thread.sleep(10000);
		List<AndroidElement> xyz = driver.findElementsByClassName("android.widget.TextView");
		for(int i = 0; i<xyz.size(); i++) {
			if (xyz.get(i).getText().contains("Konjum Manjal")) {
				xyz.get(i).click();
				Thread.sleep(5000);
				driver.findElementById("com.raaga.android:id/controls_play_song").click();
				System.out.println("Song successfully played");
				break;
			}
		}
	}
}
