package pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.text.DecimalFormat;

public class CalculatorPage extends BasePage {
    public CalculatorPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "buttonKeyboard5")
    private AndroidElement digitFive;

    @AndroidFindBy(id = "buttonKeyboard7")
    private AndroidElement digitSeven;

    @AndroidFindBy(id = "buttonKeyboard8")
    private AndroidElement digitEight;

    @AndroidFindBy(id = "buttonKeyboard0")
    private AndroidElement digitZero;

    @AndroidFindBy(id = "buttonKeyboardEquals")
    private AndroidElement digitEqualTo;

    @AndroidFindBy(id = "buttonKeyboardMultiply")
    private AndroidElement digitMultiply;

    @AndroidFindBy(id = "amount_text")
    private MobileElement calculatedAmount;

    @AndroidFindBy(id = "textViewNote")
    public AndroidElement noteInputField;

    private void tapOnDigitZero() { digitZero.click(); }
    private void tapOnDigitFive() { digitFive.click(); }
    private void tapOnDigitSeven() { digitSeven.click(); }
    private void tapOnDigitEight() { digitEight.click(); }
    private void tapOnEqualTo() { digitEqualTo.click(); }
    private void tapOnMultiply() { digitMultiply.click(); }

    public String getAmount() {
        String amount =  calculatedAmount.getText();
        Float fl = Float.parseFloat(amount);
        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        amount = df.format(fl);
        return amount;
    }

    public void multiplyFiveTimesEight() {
        tapOnDigitFive();
        tapOnMultiply();
        tapOnDigitEight();
        tapOnEqualTo();
    }

    public void enterSevenHundred() {
        tapOnDigitSeven();
        tapOnDigitZero();
        tapOnDigitZero();
    }

    public void enterNote(String text) {
        noteInputField.sendKeys(text);
    }


}
