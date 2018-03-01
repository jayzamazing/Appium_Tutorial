import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class misc extends base{
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.currentActivity());
		//views - native, hybrid, webview - get context tells which you are in
		System.out.println(driver.getContext());
		System.out.println(driver.getOrientation());//self explanatory
		System.out.println(driver.isLocked());
//		driver.hideKeyboard();
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        FluentWait<WebDriver> wait = new WebDriverWait(driver, 5).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']")));
		driver.pressKeyCode(AndroidKeyCode.BACK);
	}
}