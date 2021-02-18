package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage{
    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Top bar

    @AndroidFindBy(id = "menu_search")
    public AndroidElement searchButton;

    @AndroidFindBy(id = "transfer_menu_item")
    public AndroidElement transferButton;


    @AndroidFindBy(id = "expense_button")
    private AndroidElement expenseButton;

    @AndroidFindBy(id = "balance_amount")
    private AndroidElement balanceAmount;

    @AndroidFindBy(id = "piegraph")
    private AndroidElement pieGraph;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Navigate up\")")
    public AndroidElement backButton;

    @AndroidFindBy(id = "keyboard_action_button")
    public AndroidElement categoryActionButton;

    @AndroidFindBy(id = "snackbar_text")
    public AndroidElement snackbarView;

    public void tapOnTransferButton() {
        transferButton.click();
    }

    public void tapOnSearchButton() {
        searchButton.click();
    }

    public void tapOnExpenseButton() {
        expenseButton.click();
    }

    public String getTextFromSnackbar() {
        return snackbarView.getText();
    }

    public String getAmountFromSnackbar() {
        return snackbarView.getText().split(" ")[1];
    }

    public String getCategoryNameFromSnackbar() {
        return snackbarView.getText().split(":")[0];
    }

    public TransactionsPage tapOnBalanceAmount() {
        balanceAmount.click();
        return new TransactionsPage(driver);
    }

    public List<MobileElement> categoryList() {
        return getChildElements(pieGraph, "android.widget.ImageView");
    }

    public String[] getArrayFromCategoryNames() {
        String [] categoryText = new String[categoryList().size()];
        for(int i = 0; i < categoryList().size(); i++) {
            categoryList().get(i).click();
            categoryText[i] = categoryActionButton.getText();
            backButton.click();
        }
        return categoryText;
    }

}
