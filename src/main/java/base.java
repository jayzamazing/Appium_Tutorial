import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {
	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
		//get the apk file
		File f = new File("src/main/java");
		File fs = new File(f, "Raaga.apk");
		//create capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel XL API 27");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		//driver to connect to server
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}
}