package AppiumTestAutomation;

import static org.junit.Assert.assertTrue;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public AndroidDriver<MobileElement> driver;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 30");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("appPackage", "com.adematici.denemebankasi");
        caps.setCapability("appActivity",
                "com.adematici.denemebankasi.activities.GirisActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @Test
    public void loginTest() throws InterruptedException {
        loginAccount();
    }

    public void loginAccount() throws InterruptedException {
        MobileElement loginTc = driver.findElementById("etTcGiris");
        MobileElement loginPassword = driver.findElementById("etSifreGiris");
        MobileElement button = driver.findElementById("btYetkiliGirisiGiris");
        loginTc.sendKeys("1234");
        // 1234
        loginPassword.sendKeys("12345");
        // 12345
        button.click();
        Thread.sleep(5000L);
        loginPassword.sendKeys("1234");
        button.click();
        Thread.sleep(1000L);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }


}
