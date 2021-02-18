package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TransferPage extends BasePage{
    public TransferPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "icon")
    private List<AndroidElement> accountList;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Payment Card\")")
    private AndroidElement dropDownPaymentCard;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Cash\")")
    private AndroidElement dropDownCash;

    @AndroidFindBy(id = "show_keyboard_fab")
    private AndroidElement keyboardShowButton;

    @AndroidFindBy(id = "keyboard_action_button")
    private AndroidElement addTransferButton;

    @AndroidFindBy(id = "textViewDate")
    private AndroidElement dateSelector;

    @AndroidFindBy(id = "month_grid")
    private AndroidElement monthGrid;

    @AndroidFindBy(id = "mtrl_picker_header_toggle")
    private AndroidElement editButton;

    @AndroidFindBy(id = "confirm_button")
    private AndroidElement confirmDate;

    public void choosePaymentCardFromDropDown() {
        accountList.get(0).click();
        dropDownPaymentCard.click();
    }

    public void chooseCashFromDropDown() {
        accountList.get(1).click();
        dropDownCash.click();
    }

    public void tapOnCalculatorButton() {
        keyboardShowButton.click();
    }

    public void tapOnAddTransferButton() {
        addTransferButton.click();
    }

    public void tapOnDatePicker() {
        dateSelector.click();
    }

    public void tapOnEditButton() {
        editButton.click();
    }

    public void tapOnConfirmButton() {
        confirmDate.click();
    }

    public List<MobileElement> dateList() {
        return getChildElements(monthGrid, "android.widget.TextView");
    }

    public void selectDate(int date) {
        //FIXME values outside calendar view needs to be handled
        dateList().get(date - 1).click();
    }

    public boolean dateContainsSelectedDate(int date) {
        return dateSelector.getText().contains(String.valueOf(date));
    }
}
