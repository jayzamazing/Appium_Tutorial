import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Appi2 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, MalformedURLException {
		File appDir = new File("src");
		//
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		//launch app with specific package name
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.sirma.mobile.bible.android");
		//run specific activity
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.youversion.ui.MainActivity");
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}
}
