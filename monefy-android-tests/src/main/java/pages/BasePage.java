package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;

public class BasePage {
    //common methods to be written here

    public AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Tap to add a new expense record\")")
    public static AndroidElement toast1;
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Or tap the category icon to add a record faster\")")
    public static AndroidElement toast2;
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Tap the 'Transfer' button to move money between accounts\")")
    public static AndroidElement toast3;
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Main currency can be changed here\")")
    public static AndroidElement toast4;

    @AndroidFindBy(id = "overflow")
    public static AndroidElement settingsOverflowButton;

    public static void dismissToastMessages() {
        clickIfDisplayed(toast1);
        clickIfDisplayed(toast2);
        clickIfDisplayed(toast3);
        clickIfDisplayed(toast4);
        settingsOverflowButton.click();
    }

    private static void clickIfDisplayed(AndroidElement element) {
        if(element.isDisplayed()) {
            element.click();
        }
    }

    public List<MobileElement> getChildElements(AndroidElement element, String classname) {
        List<MobileElement> elements = element.findElements(By.className(classname));
        return elements;
    }
}
