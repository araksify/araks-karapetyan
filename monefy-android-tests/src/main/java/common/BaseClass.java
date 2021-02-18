package common;

public class BaseClass {

    public interface Appium {
        String avdName = "Pixel_2_XL_API_26";
        String deviceName = "emulator-5554";
        String platformName = "Android";
        String url = "http://127.0.0.1:4723/wd/hub";
        String automationName = "UiAutomator2";
    }

    public interface App {
        String apkPath = System.getProperty("user.dir") + "/monefy.app.lite.apk";
    }

}
