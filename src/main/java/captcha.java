import java.net.MalformedURLException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class captcha extends baseChrome {
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = Capabilities("device");
		
		driver.get("https://fantasycricket.dream11.com/IN/");
		
		
		
//		driver.findElementByXPath("//a[@href='#menu']").click();
//		driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
//		System.out.println(driver.getCurrentUrl());
//		
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,480)", "");
//		Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));
	}
	public void switchtoFrame(AndroidDriver<AndroidElement> driver) {
		int framecount = driver.findElements(By.tagName("iframe")).size();
		for (int i = 0; i < framecount; i++) {
			driver.switchTo().frame(i);
			if (0 < driver.findElements(By.xpath(".//*[@id='recaptcha-anchor']/div[5]")).size()) {
				driver.findElement(By.xpath(".//*[@id='recaptcha-anchor']/div[5]")).click();
				break;
			} else {
				System.out.println("continue looping");
			}
		}
		
	}
	
}
