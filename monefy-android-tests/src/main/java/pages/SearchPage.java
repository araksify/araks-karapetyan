package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;


public class SearchPage extends BasePage{
    public SearchPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "et_search")
    private AndroidElement searchInputField;

    @AndroidFindBy(id = "empty_results_text_view")
    private AndroidElement emptyResultTextView;

    public void enterSearchText(String text) {
        searchInputField.sendKeys(text);
        driver.getKeyboard().pressKey(Keys.RETURN);
    }

    public boolean emptyResultViewIsShown() {
        return emptyResultTextView.isDisplayed();
    }
}
