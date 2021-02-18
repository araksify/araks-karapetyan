package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class ExpensePage extends CalculatorPage {
    public ExpensePage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "keyboard_action_button")
    private AndroidElement chooseCategory;

    @AndroidFindBy(id = "textCategoryName")
    private List<AndroidElement> categoryList;

    private void tapToChooseCategory() {
        chooseCategory.click();
    }

    public void selectCategory(String category) {
        tapToChooseCategory();
        for(int i = 0; i < categoryList.size(); i++) {
            if(categoryList.get(i).getText().contains(category)) {
                categoryList.get(i).click();
                return;
            }
            else continue;
        }
    }


}
