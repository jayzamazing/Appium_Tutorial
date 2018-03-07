import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class browse extends baseChrome {
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = Capabilities("device");
//		driver.get("http://facebook.com");
//		driver.findElementByXPath("//*[@id=\"m_login_email\"]").sendKeys("qwerty");
//		driver.findElementByName("pass").sendKeys("12345");
//		driver.findElementByXPath("//button[@value='Log In']").click();
		
		driver.get("http://cricbuzz.com");
		driver.findElementByXPath("//a[@href='#menu']").click();
		driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
		System.out.println(driver.getCurrentUrl());
	}
}
