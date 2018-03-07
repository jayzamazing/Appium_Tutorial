
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class scrolling extends base{
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//deal with different screen sizes
		Dimension size = driver.manage().window().getSize();
		int x = size.getWidth() / 2;
		int starty = (int) (size.getHeight() * 0.60);
		int endy = (int) (size.getHeight() * 0.10);
		new TouchAction(driver).press(starty, x).waitAction(Duration.ofMillis(3000)).moveTo(endy, x).release().perform();
		//driver.findElementByAndroidUIAutomator("attribute(value)");
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		//scroll using android functionality
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"))");
		
	}
}
