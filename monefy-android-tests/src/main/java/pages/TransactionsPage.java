package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class TransactionsPage extends BasePage {
    public TransactionsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "transaction_group_header")
    public List<AndroidElement> transactionHeader;

    @AndroidFindBy(id = "textViewTransactionNote")
    public AndroidElement transactionNote;


    public void tapToExpandCategory() {
        transactionHeader.get(0).click();
    }

    public String getTransactionText() {
        return transactionNote.getText();
    }

}
