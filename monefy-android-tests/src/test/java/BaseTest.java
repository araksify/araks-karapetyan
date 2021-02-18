import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import common.BaseClass.App;
import common.BaseClass.Appium;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static AppiumDriverLocalService service;
    public static AppiumDriver driver;
    public static WebDriverWait wait;

    private static DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("avd", Appium.avdName);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Appium.deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Appium.platformName);
        capabilities.setCapability(MobileCapabilityType.APP, App.apkPath);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, Appium.automationName);
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);
        return capabilities;
    }

    @BeforeSuite
    public void setupAppium() throws MalformedURLException {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        URL url = new URL(Appium.url);
        driver = new AppiumDriver(url, getCapabilities());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);

    }
    @BeforeMethod
    public void resetApp() {
        driver.resetApp();
        BasePage.dismissToastMessages();
    }
}
